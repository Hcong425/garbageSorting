package cn.edu.rubbish.action;

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
import cn.edu.point.bean.PointChange;
import cn.edu.point.service.PointChangeService;
import cn.edu.rubbish.bean.Rubbish;
import cn.edu.rubbish.service.RubbishService;
import cn.edu.util.PageBean;
import cn.edu.util.form.RubbishForm;

@Controller
public class RubbishAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Rubbish rubbish;
	private PointChange pointChange;
	private PointChangeService pointChangeService;
	private PageBean<Rubbish> pageBean = new PageBean<Rubbish>();
	private RubbishForm form = new RubbishForm();
	private RubbishService rubbishService;
	private String result;
	private File upload;
	private String uploadFileName;

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

	public PageBean<Rubbish> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Rubbish> pageBean) {
		this.pageBean = pageBean;
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

	public RubbishForm getForm() {
		return form;
	}

	public void setForm(RubbishForm form) {
		this.form = form;
	}

	@Autowired
	public void setRubbishService(RubbishService rubbishService) {
		this.rubbishService = rubbishService;
	}

	public String findAllChildByPage() throws Exception {
		int pageNum = 1;
		int pageSize = 20;
		if (getPageBean().getPageNum() != 0)
			pageNum = getPageBean().getPageNum();
		if (getPageBean().getPageSize() != 0)
			pageSize = getPageBean().getPageSize();
		ServletActionContext.getContext().getSession().put("parRubbishId", getForm().getParRubbishId());
		pageBean = rubbishService.getAllChildByPage(pageNum, pageSize, getForm().getParRubbishId());
		List<Rubbish> rubbishs = rubbishService.getParRubbish();
		ServletActionContext.getRequest().setAttribute("parRubbish", rubbishs);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		setPageBean(new PageBean<Rubbish>());
		form = new RubbishForm();
		return SUCCESS;
	}

	public String saveOrUpdate() throws IOException {
		if (form.getId() != null) {
			this.rubbish = rubbishService.getById(form.getId());
			Manger manger = (Manger) ServletActionContext.getContext().getSession().get("currentManger");
			if (rubbish.getPoint() != Integer.parseInt(form.getPoint())) {
				pointChange = new PointChange(new Date(), rubbish.getPoint(), Integer.parseInt(form.getPoint()), manger,
						rubbish, null);
				pointChangeService.saveOrUpdate(pointChange);
			}
		} else {
			this.rubbish = new Rubbish();
		}
		if (getUploadFileName() != null && getUpload() != null) {
			InputStream is = new FileInputStream(getUpload());
			OutputStream os = new FileOutputStream(ServletActionContext.getRequest().getSession().getServletContext()
					.getRealPath("rubbishImg\\" + getUploadFileName()));
			byte buffer[] = new byte[1024];
			int count;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
			rubbish.setImage(uploadFileName);
		}
		rubbish.setPoint(Integer.parseInt(form.getPoint()));
		rubbish.setName(form.getName());
		rubbish.setDescr(form.getDescr());
		if (form.getActive() != null) {
			rubbish.setActive(1);
		} else {
			rubbish.setActive(0);
		}
		Rubbish parRubbish = rubbishService.getById(form.getParRubbishId());
		if (parRubbish != null)
			rubbish.setParRubbish(parRubbish);
		parRubbish.getChildRubbishs().add(rubbish);
		rubbishService.saveOrUpdate(parRubbish);
		form = new RubbishForm();
		return "saveOrUpdate";
	}

	public String toEditPage() {
		if (form.getId() != null) {
			rubbish = rubbishService.getById(form.getId());
			if (rubbish != null)
				ServletActionContext.getRequest().setAttribute("checkRubbish", rubbish);
		} else {
			ServletActionContext.getRequest().setAttribute("checkRubbish", null);
		}
		List<Rubbish> rubbishs = rubbishService.getParRubbish();
		ServletActionContext.getRequest().setAttribute("parRubbish", rubbishs);
		form = new RubbishForm();
		return "toEditPage";

	}

	public String delete() {
		Rubbish rubbish = rubbishService.getById(form.getId());
		if (rubbish != null)
			rubbishService.delete(rubbish);
		return "delete";
	}

	public String search() {
		String condition = getForm().getCondition();
		ServletActionContext.getRequest().setAttribute("condition", condition);
		if (condition == null)
			return "addSuccess";
		condition = condition.trim().toUpperCase();
		if (condition == "")
			return "addSuccess";
		int pageNum = 1;
		int pageSize = 20;
		if (getPageBean().getPageNum() != 0)
			pageNum = getPageBean().getPageNum();
		if (getPageBean().getPageSize() != 0)
			pageSize = getPageBean().getPageSize();
		pageBean = rubbishService.getByConditionPage(pageNum, pageSize, condition);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		setPageBean(new PageBean<Rubbish>());
		form = new RubbishForm();
		return SUCCESS;
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
		List<Rubbish> rankRubbishs = rubbishService.getRankBySpell(1, 18, start, end);
		String jsonStr = toRankString(rankRubbishs);
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
		List<Rubbish> rankRubbishs = rubbishService.getRankBySpell(1, 18, start, end);
		String jsonStr = toRankString(rankRubbishs);
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
		List<Rubbish> rankRubbishs = rubbishService.getRankBySpell(1, 18, start, end);
		String jsonStr = toRankString(rankRubbishs);
		setResult(jsonStr);
		return "ajax";
	}

	public String toRankString(List<Rubbish> rankRubbishs) {
		for (Rubbish rankRubbish : rankRubbishs) {
			rankRubbish.setChildRubbishs(null);
			rankRubbish.setParRubbish(null);
			rankRubbish.setRubbishItems(null);
			rankRubbish.setPointChanges(null);
		}
		Gson json = new Gson();
		String jsonStr = json.toJson(rankRubbishs);
		return jsonStr;
	}

}
