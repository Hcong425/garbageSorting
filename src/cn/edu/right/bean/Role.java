package cn.edu.right.bean;

import java.io.Serializable;
import java.util.Set;

import cn.edu.manger.bean.Manger;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Set<Manger> mangers;
	private Set<Right> rights;

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

	public Set<Manger> getMangers() {
		return mangers;
	}

	public void setMangers(Set<Manger> mangers) {
		this.mangers = mangers;
	}

	public Set<Right> getRights() {
		return rights;
	}

	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}

	public Role(String name, Set<Manger> mangers, Set<Right> rights) {
		super();
		this.name = name;
		this.mangers = mangers;
		this.rights = rights;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", rights=" + rights + "]";
	}

}
