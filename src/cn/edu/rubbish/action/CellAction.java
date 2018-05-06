package cn.edu.rubbish.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.rubbish.bean.Address;
import cn.edu.rubbish.bean.Cell;
import cn.edu.rubbish.service.AddressService;
import cn.edu.rubbish.service.CellService;

@Controller
public class CellAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CellService cellService;
	private Cell form;
	private String result = "";
	private AddressService addressService;
	private Integer addressId;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Cell getForm() {
		return form;
	}

	public void setForm(Cell form) {
		this.form = form;
	}

	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Autowired
	public void setCellService(CellService cellService) {
		this.cellService = cellService;
	}

	public String saveOrUpdate() {
		if (form.getId() != null) {
			form = cellService.getById(form.getId());
		} else {
			form = new Cell();
		}
		if (getAddressId() != null) {
			Address address = addressService.getById(getAddressId());
			if (address != null)
				form.setAddress(address);
		}
		cellService.saveOrUpdate(form);
		return "saveOrUpdateSuccess";
	}

	public String findAllCellInMap() {
		setResult("");
		Integer targetId = form.getId();
		List<Cell> cells = cellService.getAll();
		if (cells.size() > 0) {
			for (Cell cell : cells) {
				if (cell.getId() == targetId) {
					cell.setTerget(true);
				}
				cell.setAddress(null);
			}
			Gson json = new Gson();
			String jsonStr = json.toJson(cells);
			setResult(jsonStr);
		}
		return "ajax";
	}

	public String findCellByAddressInMap() {
		setResult("");
		if (getAddressId() != null) {
			List<Cell> cells = cellService.getByAddressId(getAddressId());
			if (cells.size() > 0) {
				for (Cell cell : cells) {
					cell.setAddress(null);
				}
				Gson json = new Gson();
				String jsonStr = json.toJson(cells);
				setResult(jsonStr);
			}
		}
		return "ajax";
	}

}
