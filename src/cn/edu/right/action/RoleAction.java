package cn.edu.right.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import cn.edu.right.service.RoleService;
import cn.edu.util.PageBean;
import cn.edu.util.form.RoleForm;

@Controller
public class RoleAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private RoleForm form = new RoleForm();
	private MangerService mangerService;
	private ClassesService classesService;
	private RightService rightService;
	private Role role;
	private Integer mangerId;
	private RoleService roleService;
	private PageBean<Role> pageBean = new PageBean<Role>();

	public Integer getMangerId() {
		return mangerId;
	}

	public void setMangerId(Integer mangerId) {
		this.mangerId = mangerId;
	}

	@Autowired
	public void setMangerService(MangerService mangerService) {
		this.mangerService = mangerService;
	}

	public PageBean<Role> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Role> pageBean) {
		this.pageBean = pageBean;
	}

	@Autowired
	public void setRightService(RightService rightService) {
		this.rightService = rightService;
	}

	@Autowired
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RoleForm getForm() {
		return form;
	}

	public void setForm(RoleForm form) {
		this.form = form;
	}

	public String findAllByPage() throws Exception {

		int pageNum = 1;
		int pageSize = 3;
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
		pageBean = roleService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		List<Classes> classes = classesService.getAll();
		ServletActionContext.getContext().getSession().put("classes", classes);
		setPageBean(new PageBean<Role>());
		return SUCCESS;
	}

	public String toEditPage() {
		if (form.getId() != null) {
			role = roleService.getById(form.getId());
			if (role != null)
				ServletActionContext.getContext().getSession().put("checkRole", role);
		} else {
			ServletActionContext.getContext().getSession().put("checkRole", null);
		}
		List<Classes> classes = classesService.getAll();
		ServletActionContext.getContext().getSession().put("classes", classes);
		form = new RoleForm();
		return "toEditPage";
	}

	public String saveOrUpdate() {
		if (form.getId() != null) {
			this.role = roleService.getById(form.getId());
		} else {
			this.role = new Role();
		}
		role.setName(form.getName());
		Set<Integer> rightsInt = form.getRights();
		Set<Right> rights = new HashSet<Right>();
		for (Integer rightInt : rightsInt) {
			Right right = rightService.getById(rightInt);
			if (right != null)
				rights.add(right);
		}
		role.setRights(rights);
		roleService.saveOrUpdate(role);
		form = new RoleForm();
		flushSession();
		return "saveOrUpdate";
	}

	public String toDistributionPage() {
		int pageNum = 1;
		int pageSize = 5;
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
		PageBean<Manger> pageBean = mangerService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		List<Role> roles = roleService.getAll();
		List<Classes> classes = classesService.getAll();
		ServletActionContext.getContext().getSession().put("classes", classes);
		ServletActionContext.getContext().getSession().put("roles", roles);
		return "toDistributionPage";
	}

	public String setRole() {

		Manger manger = mangerService.getById(getMangerId());
		Role role = roleService.getById(form.getId());
		manger.setRole(role);
		mangerService.saveOrUpdate(manger);
		flushSession();
		return "setRole";
	}

	public String delete() {
		if (form.getId() != null) {
			role = roleService.getById(form.getId());
			if (role != null)
				roleService.delete(role);
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
