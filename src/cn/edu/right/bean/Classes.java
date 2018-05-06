package cn.edu.right.bean;

import java.io.Serializable;
import java.util.Set;

public class Classes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
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

	public Set<Right> getRights() {
		return rights;
	}

	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}

	public Classes(String name, Set<Right> rights) {
		super();
		this.name = name;
		this.rights = rights;
	}

	public Classes() {
		super();
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + "]";
	}

}
