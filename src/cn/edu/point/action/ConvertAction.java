package cn.edu.point.action;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.manger.bean.User;
import cn.edu.manger.service.UserService;
import cn.edu.point.bean.Commodity;
import cn.edu.point.bean.Convert;
import cn.edu.point.bean.ConvertItem;
import cn.edu.point.service.CommodityService;
import cn.edu.point.service.ConvertService;
import cn.edu.util.HttpRequest;
import cn.edu.util.PageBean;
import cn.edu.util.form.ConvertForm;

@Controller
public class ConvertAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConvertService convertService;
	private UserService userService;
	private CommodityService commodityService;
	private PageBean<Convert> pageBean = new PageBean<Convert>();
	private Integer userId;
	private Integer commodityId;
	private ConvertForm form = new ConvertForm();

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public PageBean<Convert> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Convert> pageBean) {
		this.pageBean = pageBean;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	@Autowired
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setForm(ConvertForm form) {
		this.form = form;
	}

	public ConvertForm getForm() {
		return form;
	}

	@Autowired
	public void setConvertService(ConvertService convertService) {
		this.convertService = convertService;
	}

	public String add() throws ParseException {
		User user = null;
		int point = 0;
		int amount = 0;
		Convert convert = new Convert();
		Set<ConvertItem> convertItems = new HashSet<ConvertItem>();
		if (form.getUser() != null)
			user = userService.getById(form.getUser());
		List<Integer> commodities = form.getCommodity();
		List<Integer> amounts = form.getAmount();
		if (commodities.size() > 0) {
			for (int i = 0; i < commodities.size(); i++) {
				if (commodities.get(i) != null) {
					Commodity commodity = commodityService.getById(commodities.get(i));
					ConvertItem convertItem;
					if (commodity != null && amounts.get(i) != null) {
						convertItem = new ConvertItem(commodity, amounts.get(i), convert);
						convertItems.add(convertItem);
						amount += form.getAmount().get(i);
						point += commodity.getPoint() * form.getAmount().get(i);
						commodity.setSales(commodity.getSales() + amounts.get(i));
						commodity.setRepertory(commodity.getRepertory() - amounts.get(i));
					}
				}
			}
		}
		convert.setAmount(amount);
		convert.setPoint(point);
		convert.setUser(user);
		convert.setTime(new Date());
		convert.setConvertItems(convertItems);
		convertService.saveOrUpdate(convert, user);
		HttpRequest.sendGet("http://127.0.0.1:3000/todayAmountFlush", "todayAmount="+convertService.getTodayAmount());
		HttpRequest.sendGet("http://127.0.0.1:3000/totalAmountFlush", "totalAmount="+convertService.getTotalAmount());
		
		return "add";
	}

	public String findAllByPage() {

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
		pageBean = convertService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		ServletActionContext.getRequest().setAttribute("user", null);
		return SUCCESS;
	}

	public String findByPageUserId() {
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
		if (getUserId() != null) {
			User user = userService.getById(getUserId());
			if (user != null) {
				PageBean<Convert> pageBean = convertService.getPageByUserId(pageNum, pageSize, line, way, getUserId());
				ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
				ServletActionContext.getRequest().setAttribute("user", user);
				System.out.println(pageBean.getList());
				return SUCCESS;
			}
		}
		return ERROR;

	}

	public String findByPageCommodityId() {

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
		if (getCommodityId() != null) {
			Commodity commodity = commodityService.getById(getCommodityId());
			if (commodity != null) {
				PageBean<Convert> pageBean = convertService.getPageByCommodityId(pageNum, pageSize, line, way,
						getCommodityId());
				ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
				ServletActionContext.getRequest().setAttribute("foundCommodtiy", commodity);
				return SUCCESS;
			}
		}
		return ERROR;

	}

}
