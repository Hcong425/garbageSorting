package cn.edu.rubbish.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import cn.edu.point.bean.PointChange;

public class Rubbish implements Serializable, Comparable<Rubbish> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Rubbish parRubbish;
	private Integer active;
	private Integer point;
	private String descr;
	private String image;
	private BigDecimal sortKey;
	private Set<RubbishItem> rubbishItems;
	private Set<Rubbish> childRubbishs;
	private Set<PointChange> pointChanges;

	public BigDecimal getSortKey() {
		return sortKey;
	}

	public void setSortKey(BigDecimal sortKey) {
		this.sortKey = sortKey;
	}

	public Set<PointChange> getPointChanges() {
		return pointChanges;
	}

	public void setPointChanges(Set<PointChange> pointChanges) {
		this.pointChanges = pointChanges;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Set<Rubbish> getChildRubbishs() {
		return childRubbishs;
	}

	public void setChildRubbishs(Set<Rubbish> childRubbishs) {
		this.childRubbishs = childRubbishs;
	}

	public Rubbish getParRubbish() {
		return parRubbish;
	}

	public void setParRubbish(Rubbish parRubbish) {
		this.parRubbish = parRubbish;
	}

	public Set<RubbishItem> getRubbishItems() {
		return rubbishItems;
	}

	public void setRubbishItems(Set<RubbishItem> rubbishItems) {
		this.rubbishItems = rubbishItems;
	}

	public Rubbish() {
		super();
	}

	public Rubbish(String name, Rubbish parRubbish, Integer active, Integer point, String descr, String image,
			Set<RubbishItem> rubbishItems, Set<Rubbish> childRubbishs, Set<PointChange> pointChanges) {
		super();
		this.name = name;
		this.parRubbish = parRubbish;
		this.active = active;
		this.point = point;
		this.descr = descr;
		this.image = image;
		this.rubbishItems = rubbishItems;
		this.childRubbishs = childRubbishs;
		this.pointChanges = pointChanges;
	}

	@Override
	public String toString() {
		return "Rubbish [id=" + id + ", name=" + name + ", sortKey=" + sortKey + "]";
	}

	@Override
	public int compareTo(Rubbish rubbish) {
		return rubbish.getSortKey().compareTo(this.getSortKey());
	}

}
