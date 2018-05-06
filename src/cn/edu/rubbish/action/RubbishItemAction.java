package cn.edu.rubbish.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.manger.bean.Manger;
import cn.edu.manger.bean.User;
import cn.edu.manger.service.MangerService;
import cn.edu.manger.service.UserService;
import cn.edu.rubbish.bean.RecyclePoint;
import cn.edu.rubbish.bean.Rubbish;
import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.rubbish.service.RecyclePointService;
import cn.edu.rubbish.service.RubbishItemService;
import cn.edu.rubbish.service.RubbishService;
import cn.edu.util.HttpRequest;
import cn.edu.util.PageBean;
import cn.edu.util.form.RubbishItemForm;

/**
 * 
 */
@Controller
public class RubbishItemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RubbishItemService rubbishItemService;
	private UserService userService;
	private MangerService mangerService;
	private RubbishService rubbishService;
	private RecyclePointService recyclePointService;
	private PageBean<RubbishItem> pageBean = new PageBean<RubbishItem>();
	private Integer userId;
	private RubbishItemForm form = new RubbishItemForm();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public PageBean<RubbishItem> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<RubbishItem> pageBean) {
		this.pageBean = pageBean;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RubbishItemForm getForm() {
		return form;
	}

	public void setForm(RubbishItemForm form) {
		this.form = form;
	}

	@Autowired
	public void setRubbishItemService(RubbishItemService rubbishItemService) {
		this.rubbishItemService = rubbishItemService;
	}

	@Autowired
	public void setRubbishService(RubbishService rubbishService) {
		this.rubbishService = rubbishService;
	}

	@Autowired
	public void setMangerService(MangerService mangerService) {
		this.mangerService = mangerService;
	}

	@Autowired
	public void setRecyclePointService(RecyclePointService recyclePointService) {
		this.recyclePointService = recyclePointService;
	}

	public String add() throws ParseException {

		String weightStr = form.getRubbishWeight();
		BigDecimal weight = new BigDecimal(weightStr);
		Rubbish rubbish = rubbishService.getById(form.getRubbish());
		User user = userService.getById(form.getUser());
		Manger manger = mangerService.getById(form.getManger());
		RecyclePoint recyclePoint = recyclePointService.getById(form.getRecyclePoint());
		int point = (weight.multiply(new BigDecimal(rubbish.getPoint()))).intValue();

		RubbishItem rubbishItem = new RubbishItem(rubbish, point, user, new Date(), manger, weight, recyclePoint);
		rubbishItemService.saveOrUpdate(rubbishItem, user);
		HttpRequest.sendGet("http://127.0.0.1:3000/todayWeightFlush", "todayWeight="+rubbishItemService.getTodayWegiht().floatValue());
		HttpRequest.sendGet("http://127.0.0.1:3000/totalWeightFlush", "totalWeight="+recyclePointService.getAllWeight().floatValue());
		return "add";

	}

	public String findAllByPage() throws Exception {

		int pageNum = 1;
		int pageSize = 10;
		String line = "time";
		String way = "desc";
		if (getPageBean().getPageNum() != 0)
			pageNum = getPageBean().getPageNum();
		if (getPageBean().getPageSize() != 0)
			pageSize = getPageBean().getPageSize();
		if (getPageBean().getLine() != null && !getPageBean().getLine().equals(""))
			line = getPageBean().getLine();
		if (getPageBean().getWay() != null && !getPageBean().getWay().equals(""))
			way = getPageBean().getWay();
		pageBean = rubbishItemService.getByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		ServletActionContext.getContext().getSession().put("user", null);
		setPageBean(new PageBean<RubbishItem>());
		return SUCCESS;
	}

	public String findByPageUserId() {
		int pageNum = 1;
		int pageSize = 10;
		String line = "time";
		String way = "asc";
		if (getPageBean().getPageNum() != 0)
			pageNum = getPageBean().getPageNum();
		if (getPageBean().getPageSize() != 0)
			pageSize = getPageBean().getPageSize();
		if (getPageBean().getLine() != null && !getPageBean().getLine().equals(""))
			line = getPageBean().getLine();
		if (getPageBean().getWay() != null && !getPageBean().getWay().equals(""))
			way = getPageBean().getWay();
		pageBean = rubbishItemService.getByPageUserId(pageNum, pageSize, line, way, getUserId());
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		ServletActionContext.getContext().getSession().put("user", userService.getById(getUserId()));
		setPageBean(new PageBean<RubbishItem>());
		return SUCCESS;

	}

	public String delete() {
		if (form.getRubbishItem() != null) {
			RubbishItem rubbishItem = rubbishItemService.getById(form.getRubbishItem());
			if (rubbishItem != null) {
				rubbishItemService.delete(rubbishItem);
				return "deletesuccess";
			}
		}
		return "deleteerror";

	}

}
