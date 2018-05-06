package cn.edu.right.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.manger.bean.Manger;
import cn.edu.manger.service.MangerService;
import cn.edu.right.bean.Classes;
import cn.edu.right.bean.Right;
import cn.edu.right.bean.Role;
import cn.edu.right.service.ClassesService;
import cn.edu.right.service.RightService;
import cn.edu.util.PageBean;
import cn.edu.util.form.RightForm;

@Controller
public class RightAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private Right right;
	private RightService rightService;
	private MangerService mangerService;
	private ClassesService classesService;
	private RightForm form = new RightForm();
	private PageBean<Right> pageBean = new PageBean<Right>();
	private String result;

	@Autowired
	public void setMangerService(MangerService mangerService) {
		this.mangerService = mangerService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public PageBean<Right> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Right> pageBean) {
		this.pageBean = pageBean;
	}

	@Autowired
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	@Autowired
	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	public RightForm getForm() {
		return form;
	}

	public void setForm(RightForm form) {
		this.form = form;
	}

	public String findAllByPage() throws Exception {

		int pageNum = 1;
		int pageSize = 10;
		String line = "id";
		String way = "asc";
		if (getPageBean().getPageNum() != 0)
			pageNum = getPageBean().getPageNum();
		if (getPageBean().getPageSize() != 0)
			pageSize = getPageBean().getPageSize();
		if (getPageBean().getLine() != null && !getPageBean().getLine().equals(""))
			line = getPageBean().getLine();
		if (getPageBean().getWay() != null && !getPageBean().getWay().equals(""))
			way = getPageBean().getWay();
		pageBean = rightService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		setPageBean(new PageBean<Right>());
		return SUCCESS;
	}

	public String toEditPage() {
		if (form.getId() != null) {
			right = rightService.getById(form.getId());
			ServletActionContext.getContext().getSession().put("checkRight", right);
		} else {
			ServletActionContext.getContext().getSession().put("checkRight", null);
		}
		List<Classes> classes = classesService.getAll();
		ServletActionContext.getContext().getSession().put("classes", classes);
		form = new RightForm();
		return "toEditPage";
	}

	public String saveOrUpdate() {

		if (form.getId() != null) {
			this.right = rightService.getById(form.getId());
		} else {
			this.right = new Right();
		}

		right.setName(form.getName());
		right.setUrl(form.getUrl());
		if (form.getActive() != null && form.getActive().equals("true"))
			right.setActive(1);
		else
			right.setActive(0);
		Classes classes = classesService.getById(form.getClasses());
		right.setClasses(classes);
		rightService.saveOrUpdate(right);
		form = new RightForm();
		return "saveOrUpdateSuccess";
	}

	public String findByRoleId() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Right> rights = rightService.getByRoleId(getRoleId());

		for (Right right : rights) {
			stringBuilder.append(right.getId());
			stringBuilder.append(",");
		}
		setResult(stringBuilder.substring(0, stringBuilder.length() - 1).toString());
		return "ajax";
	}

	public String delete() {
		if (form.getId() != null) {
			Right right = rightService.getById(form.getId());
			if (right != null) {
				for (Role role : right.getRoles()) {
					role.getRights().remove(right);
				}
				right.setRoles(null);
				rightService.delete(right);
			}
		}
		flushSession();
		return "delete";
	}

	public void flushSession() {
		Manger manger = (Manger) ServletActionContext.getContext().getSession().get("currentManger");
		Manger newManger = mangerService.getById(manger.getId());
		ServletActionContext.getContext().getSession().put("currentManger", newManger);
		ServletActionContext.getContext().getSession().put("allRight", rightService.getAll());
		ServletActionContext.getContext().getSession().put("rights", newManger.getRole().getRights());
	}

}
