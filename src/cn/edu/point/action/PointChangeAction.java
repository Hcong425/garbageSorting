package cn.edu.point.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.point.bean.PointChange;
import cn.edu.point.service.PointChangeService;
import cn.edu.util.PageBean;

@Service
public class PointChangeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PointChangeService pointChangeService;
	private PageBean<PointChange> pageBean = new PageBean<PointChange>();

	public PageBean<PointChange> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<PointChange> pageBean) {
		this.pageBean = pageBean;
	}

	@Autowired
	public void setPointChangeService(PointChangeService pointChangeService) {
		this.pointChangeService = pointChangeService;
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
		PageBean<PointChange> pageBean = pointChangeService.getAllByPage(pageNum, pageSize, line, way);
		ServletActionContext.getContext().getSession().put("pageBean", pageBean);
		setPageBean(new PageBean<PointChange>());
		return SUCCESS;
	}

}
