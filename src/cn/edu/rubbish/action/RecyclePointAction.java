package cn.edu.rubbish.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.rubbish.bean.Address;
import cn.edu.rubbish.bean.Cell;
import cn.edu.rubbish.bean.RecyclePoint;
import cn.edu.rubbish.service.AddressService;
import cn.edu.rubbish.service.CellService;
import cn.edu.rubbish.service.RecyclePointService;
import cn.edu.util.HttpRequest;
import cn.edu.util.PageBean;
import cn.edu.util.form.RecyclePointForm;

@Controller
public class RecyclePointAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private AddressService addressService;
	private RecyclePointService recyclePointService;
	private RecyclePoint recyclePoint;
	private Integer parAddressId;
	private CellService cellService;
	private String result;
	private PageBean<RecyclePoint> pageBean = new PageBean<RecyclePoint>();
	private RecyclePointForm form = new RecyclePointForm();

	@Autowired
	public void setCellService(CellService cellService) {
		this.cellService = cellService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getParAddressId() {
		return parAddressId;
	}

	public void setParAddressId(Integer parAddressId) {
		this.parAddressId = parAddressId;
	}

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public void setPageBean(PageBean<RecyclePoint> pageBean) {
		this.pageBean = pageBean;
	}

	public PageBean<RecyclePoint> getPageBean() {
		return pageBean;
	}

	public void setForm(RecyclePointForm form) {
		this.form = form;
	}

	public RecyclePointForm getForm() {
		return form;
	}

	@Autowired
	public void setRecyclePointService(RecyclePointService recyclePointService) {
		this.recyclePointService = recyclePointService;
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
		PageBean<RecyclePoint> pageBean = recyclePointService.getAllByPage(pageNum, pageSize, line, way);
		Map<Integer, Integer> pointWeight = new HashMap<Integer, Integer>();
		for (RecyclePoint recyclePoint : pageBean.getList()) {
			pointWeight.put(recyclePoint.getId(), recyclePointService.getWeight(recyclePoint.getId()).intValue());
		}
		ServletActionContext.getRequest().setAttribute("pointWeight", pointWeight);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		setPageBean(new PageBean<RecyclePoint>());
		form = new RecyclePointForm();
		return SUCCESS;
	}

	public String saveOrUpdate() {
		if (form.getId() != null)
			recyclePoint = recyclePointService.getById(form.getId());
		else {
			recyclePoint = new RecyclePoint();
			recyclePoint.setTime(new Date());
		}
		recyclePoint.setName(getForm().getPointName());
		Cell cell = null;
		if (form.getCell() != null) {
			cell = cellService.getById(form.getCell());
		}
		recyclePoint.setCell(cell);
		if (form.getActive() != null && form.getActive().equals("true"))
			recyclePoint.setActive(1);
		else
			recyclePoint.setActive(0);
		recyclePointService.saveOrUpdate(recyclePoint);
		form = new RecyclePointForm();
		HttpRequest.sendGet("http://127.0.0.1:3000/totalPointFlush", "totalPoint="+recyclePointService.size());
		return "saveOrUpdate";
	}

	public String delete() {
		recyclePointService.deleteById(Integer.valueOf(form.getId()));
		return "delete";
	}

	public String toEditPage() {
		if (form.getId() != null) {
			recyclePoint = recyclePointService.getById(form.getId());
			if (recyclePoint != null)
				ServletActionContext.getRequest().setAttribute("checkRecyclePoint", recyclePoint);
		} else {
			ServletActionContext.getRequest().setAttribute("checkRecyclePoint", null);
		}
		List<Address> parAddress = addressService.getParAddress();
		ServletActionContext.getRequest().setAttribute("parAddress", parAddress);
		form = new RecyclePointForm();
		return "toEditPage";
	}

	public String fingAddressByPar() {
		if (getParAddressId() != null) {
			List<Address> childAddress = addressService.getChildAddress(getParAddressId());
			if (childAddress.size() > 0) {
				for (Address address : childAddress) {
					address.setParAddress(null);
					address.setChildAddress(null);
				}
				Gson json = new Gson();
				String jsonStr = json.toJson(childAddress);
				setResult(jsonStr);
			}
		}
		return "ajax";

	}

	public String toMapPage() {
		return "map";
	}

}
