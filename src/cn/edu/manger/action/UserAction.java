package cn.edu.manger.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.manger.bean.User;
import cn.edu.manger.service.UserService;
import cn.edu.util.PageBean;

@Controller
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private PageBean<User> pageBean = new PageBean<User>();
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PageBean<User> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<User> pageBean) {
		this.pageBean = pageBean;
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
		PageBean<User> pageBean = userService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		setPageBean(new PageBean<User>());
		return SUCCESS;
	}

	public String delete() {
		if (getId() != null) {
			User user = userService.getById(getId());
			if (user != null) {
				userService.delete(user);
				return "deleteSuccess";
			}
		}
		return ERROR;

	}

}
