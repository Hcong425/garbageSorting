package cn.edu.manger.action;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.manger.bean.Manger;
import cn.edu.manger.service.MangerService;
import cn.edu.manger.service.UserService;
import cn.edu.point.bean.Commodity;
import cn.edu.point.bean.Convert;
import cn.edu.point.service.CommodityService;
import cn.edu.point.service.ConvertService;
import cn.edu.right.service.RightService;
import cn.edu.rubbish.bean.Rubbish;
import cn.edu.rubbish.bean.RubbishItem;
import cn.edu.rubbish.service.RecyclePointService;
import cn.edu.rubbish.service.RubbishItemService;
import cn.edu.rubbish.service.RubbishService;
import cn.edu.util.PageBean;

@Controller
public class MangerAction extends ActionSupport implements ModelDriven<Manger> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecyclePointService recyclePointService;
	private MangerService mangerService;
	private UserService userService;
	private RightService rightService;
	private RubbishService rubbishService;
	private ConvertService convertService;
	private CommodityService commodityService;
	private RubbishItemService rubbishItemService;
	private int result;
	private Manger manger;

	@Autowired
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	@Autowired
	public void setRubbishService(RubbishService rubbishService) {
		this.rubbishService = rubbishService;
	}

	@Autowired
	public void setConvertService(ConvertService convertService) {
		this.convertService = convertService;
	}

	@Autowired
	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRubbishItemService(RubbishItemService rubbishItemService) {
		this.rubbishItemService = rubbishItemService;
	}

	@Autowired
	public void setMangerService(MangerService mangerService) {
		this.mangerService = mangerService;
	}

	public void setManger(Manger manger) {
		this.manger = manger;
	}

	public Manger getManger() {
		return manger;
	}

	@Autowired
	public void setRecyclePointService(RecyclePointService recyclePointService) {
		this.recyclePointService = recyclePointService;
	}

	public String login() throws ParseException {
		String name = manger.getName().trim();
		String password = manger.getPassword().trim();
		if (name == null || name.equals("")) {
			setResult(3);
			return "ajax";
		}
		if (password == null || password.equals("")) {
			setResult(4);
			return "ajax";
		}
		Manger manger = mangerService.getByName(name);
		if (manger == null) {
			setResult(2);
			return "ajax";
		}

		if (manger.getPassword().equals(password)) {
			ServletActionContext.getContext().getSession().put("currentManger", manger);
			ServletActionContext.getContext().getSession().put("allRight", rightService.getAll());
			ServletActionContext.getContext().getSession().put("rights", manger.getRole().getRights());
			setResult(0);
			return "ajax";
		} else {
			setResult(1);
			return "ajax";
		}

	}

	public String toIndexPage() throws ParseException {
		if (ServletActionContext.getContext().getSession().get("currentManger") != null) {
			float totalWeight = recyclePointService.getAllWeight().floatValue();
			float todayWeight = rubbishItemService.getTodayWegiht().floatValue();
			int todayAmount = convertService.getTodayAmount();
			int totalNumber = userService.size();
			int totalAmount = convertService.getTotalAmount();
			int totalPoint = recyclePointService.size();
			PageBean<RubbishItem> rubbishItemPageBean = rubbishItemService.getByPage(1, 7, "time", "desc");
			PageBean<Convert> convertPageBean = convertService.getAllByPage(1, 7, "time", "desc");
			Date start = null;
			Date end = null;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_MONTH, -7);
			start = calendar.getTime();
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_MONTH, 0);
			end = calendar.getTime();
			List<Rubbish> rankRubbish = rubbishService.getRankBySpell(1, 18, start, end);
			List<Commodity> rankCommodity = commodityService.getRankBySpell(1, 18, start, end);
			ServletActionContext.getRequest().setAttribute("rankCommodity", rankCommodity);
			ServletActionContext.getRequest().setAttribute("rankRubbish", rankRubbish);
			ServletActionContext.getRequest().setAttribute("rubbishItemPageBean", rubbishItemPageBean);
			ServletActionContext.getRequest().setAttribute("convertPageBean", convertPageBean);
			ServletActionContext.getRequest().setAttribute("totalWeight", totalWeight);
			ServletActionContext.getRequest().setAttribute("todayAmount", todayAmount);
			ServletActionContext.getRequest().setAttribute("todayWeight", todayWeight);
			ServletActionContext.getRequest().setAttribute("totalNumber", totalNumber);
			ServletActionContext.getRequest().setAttribute("totalAmount", totalAmount);
			ServletActionContext.getRequest().setAttribute("totalPoint", totalPoint);
			return SUCCESS;

		} else {
			return ERROR;
		}
	}

	@Override
	public Manger getModel() {
		manger = new Manger();
		return manger;
	}

	public String logout() {
		Manger manger = (Manger) ServletActionContext.getContext().getSession().get("currentManger");
		if (manger != null) {
			ServletActionContext.getContext().getSession().put("currentManger", null);
		}
		return "logout";
	}

}
