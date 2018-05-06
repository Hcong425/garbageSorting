package cn.edu.rubbish.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.rubbish.service.RecyclePointService;

@Controller
public class NodeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecyclePointService recyclePointService ;
	private String rusult;
	
	public void setRusult(String rusult) {
		this.rusult = rusult;
	}
	
	public String getRusult() {
		return rusult;
	}
	
	@Autowired
	public void setRecyclePointService(RecyclePointService recyclePointService) {
		this.recyclePointService = recyclePointService;
	}
	
	public String totalPointFlush(){
		int totalPoint = recyclePointService.size();
		ServletActionContext.getRequest().setAttribute("totalPoint", totalPoint);
		setRusult("{'totalPoint': '"+ totalPoint +"'}");
		return "ajax";
	}

}
