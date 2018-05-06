package cn.edu.rubbish.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import cn.edu.manger.bean.Manger;

public class RecyclePoint implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Cell cell;
	private String name;
	private Date time;
	private Set<Manger> mangers;
	private Set<RubbishItem> rubbishItems;
	private Integer active;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Manger> getMangers() {
		return mangers;
	}

	public void setMangers(Set<Manger> mangers) {
		this.mangers = mangers;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
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

	public Set<RubbishItem> getRubbishItems() {
		return rubbishItems;
	}

	public void setRubbishItems(Set<RubbishItem> rubbishItems) {
		this.rubbishItems = rubbishItems;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public RecyclePoint(Cell cell, String name, Date time, Set<Manger> mangers, Set<RubbishItem> rubbishItems,
			Integer active) {
		super();
		this.cell = cell;
		this.name = name;
		this.time = time;
		this.mangers = mangers;
		this.rubbishItems = rubbishItems;
		this.active = active;
	}

	public RecyclePoint() {
		super();
	}

}
