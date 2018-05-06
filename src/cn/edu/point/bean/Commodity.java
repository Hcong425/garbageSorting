package cn.edu.point.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Commodity implements Serializable, Comparable<Commodity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String descr;
	private String img;
	private Date time;
	private int repertory;
	private int sales;
	private BigDecimal price;
	private int point;
	private int sortKey;
	private Category category;
	private Set<PointChange> pointChanges;
	private Set<ConvertItem> convertItems;

	public int getSortKey() {
		return sortKey;
	}

	public void setSortKey(int sortKey) {
		this.sortKey = sortKey;
	}

	public void setConvertItems(Set<ConvertItem> convertItems) {
		this.convertItems = convertItems;
	}

	public Set<ConvertItem> getConvertItems() {
		return convertItems;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getRepertory() {
		return repertory;
	}

	public void setRepertory(int repertory) {
		this.repertory = repertory;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<PointChange> getPointChanges() {
		return pointChanges;
	}

	public void setPointChanges(Set<PointChange> pointChanges) {
		this.pointChanges = pointChanges;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Commodity() {
		super();
	}

	public Commodity(String name, String descr, String img, Date time, int repertory, int sales, Category category,
			BigDecimal price, int point, Set<PointChange> pointChanges, Set<ConvertItem> convertItems) {
		super();
		this.convertItems = convertItems;
		this.name = name;
		this.descr = descr;
		this.img = img;
		this.time = time;
		this.repertory = repertory;
		this.sales = sales;
		this.category = category;
		this.price = price;
		this.point = point;
		this.pointChanges = pointChanges;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", descr=" + descr + ", img=" + img + ", time=" + time
				+ ", repertory=" + repertory + ", sales=" + sales + ", price=" + price + ", point=" + point + "]";
	}

	@Override
	public int compareTo(Commodity o) {
		return o.getSortKey() - this.getSortKey();
	}

}
