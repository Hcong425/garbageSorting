package cn.edu.point.bean;

import java.io.Serializable;

public class ConvertItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Commodity commodity;
	private int quantity;
	private Convert convert;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Convert getConvert() {
		return convert;
	}

	public void setConvert(Convert convert) {
		this.convert = convert;
	}

	public ConvertItem(Commodity commodity) {
		this.commodity = commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Commodity getCommodity() {
		return this.commodity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ConvertItem() {
		super();
	}

	public ConvertItem(Commodity commodity, int quantity, Convert convert) {
		super();
		this.commodity = commodity;
		this.quantity = quantity;
		this.convert = convert;
	}

	@Override
	public String toString() {
		return "ConvertItem [id=" + id + ", quantity=" + quantity + "]";
	}

}
