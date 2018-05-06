package cn.edu.point.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.manger.bean.Manger;
import cn.edu.point.bean.Category;
import cn.edu.point.bean.Commodity;
import cn.edu.point.bean.PointChange;
import cn.edu.point.service.CategoryService;
import cn.edu.point.service.CommodityService;
import cn.edu.point.service.PointChangeService;
import cn.edu.util.PageBean;
import cn.edu.util.form.CommodityForm;

@Controller
public class CommodityAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Commodity commodity;
	private PointChange pointChange;
	private CommodityService commodityService;
	private PointChangeService pointChangeService;
	private CategoryService categoryService;
	private CommodityForm form = new CommodityForm();
	private PageBean<Commodity> pageBean = new PageBean<Commodity>();
	private String result;
	private File upload;
	private String uploadFileName;

	public void setForm(CommodityForm form) {
		this.form = form;
	}

	public CommodityForm getForm() {
		return form;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Autowired
	public void setPointChangeService(PointChangeService pointChangeService) {
		this.pointChangeService = pointChangeService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Autowired
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public PageBean<Commodity> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Commodity> pageBean) {
		this.pageBean = pageBean;
	}

	public String findAllByPage() throws Exception {

		int pageNum = 1;
		int pageSize = 7;
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
		pageBean = commodityService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		setPageBean(new PageBean<Commodity>());
		return SUCCESS;
	}

	int previousPoint = -1;

	public String saveOrUpdate() throws IOException {
		if (form.getId() != null) {
			Manger manger = (Manger) ServletActionContext.getContext().getSession().get("currentManger");
			commodity = commodityService.getById(form.getId());
			previousPoint = commodity.getPoint();
			if (previousPoint != -1 && commodity.getPoint() != previousPoint) {
				pointChange = new PointChange(new Date(), previousPoint, commodity.getPoint(), manger, null, commodity);
				pointChangeService.saveOrUpdate(pointChange);
			}
		}
		if (form.getId() == null) {
			commodity = new Commodity();
			commodity.setTime(new Date());
			if (getUploadFileName() != "" && getUpload() != null) {
				InputStream is = new FileInputStream(getUpload());
				OutputStream os = new FileOutputStream(ServletActionContext.getRequest().getSession()
						.getServletContext().getRealPath("commodityImg\\" + getUploadFileName()));
				byte buffer[] = new byte[1024];
				int count;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();
				commodity.setImg(getUploadFileName());
			}
		}
		Category category = categoryService.getById(form.getCategoryId());
		if (category != null) {
			commodity.setCategory(category);
		}
		commodity.setDescr(form.getDescr());
		commodity.setName(form.getName());
		commodity.setPoint(form.getPoint());
		commodity.setRepertory(form.getRepertory());
		commodityService.saveOrUpdate(commodity);
		form = new CommodityForm();
		return "saveOrUpdate";
	}

	public String delete() {
		if (form.getId() != null) {
			Commodity commodity = commodityService.getById(form.getId());
			if (commodity != null)
				commodityService.delete(commodity);
		}
		form = new CommodityForm();
		return "delete";
	}

	public String toEditPage() {
		if (form.getId() != null) {
			Commodity commodity = commodityService.getById(form.getId());
			ServletActionContext.getRequest().setAttribute("checkCommodity", commodity);
		} else {
			ServletActionContext.getRequest().setAttribute("checkCommodity", null);
		}
		List<Category> topCategory = categoryService.getTopCategory();
		ServletActionContext.getRequest().setAttribute("topCategory", topCategory);
		form = new CommodityForm();
		return "toEditPage";
	}

	public String findTodayRank() {
		Date start = null;
		Date end = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		start = calendar.getTime();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		end = calendar.getTime();
		List<Commodity> commodities = commodityService.getRankBySpell(1, 18, start, end);
		String jsonStr = toRankString(commodities);
		setResult(jsonStr);
		return "ajax";
	}

	public String findThisWeekRank() {
		Date start = null;
		Date end = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		start = calendar.getTime();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		end = calendar.getTime();
		List<Commodity> commodities = commodityService.getRankBySpell(1, 18, start, end);
		String jsonStr = toRankString(commodities);
		setResult(jsonStr);
		return "ajax";
	}

	public String findThisMouthRank() {
		Date start = null;
		Date end = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		start = calendar.getTime();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		end = calendar.getTime();
		List<Commodity> commodities = commodityService.getRankBySpell(1, 18, start, end);
		String jsonStr = toRankString(commodities);
		setResult(jsonStr);
		return "ajax";
	}

	public String toRankString(List<Commodity> commodities) {
		for (Commodity commodity : commodities) {
			commodity.setCategory(null);
			commodity.setConvertItems(null);
			commodity.setPointChanges(null);
			;
		}
		Gson json = new Gson();
		String jsonStr = json.toJson(commodities);
		return jsonStr;
	}

}
