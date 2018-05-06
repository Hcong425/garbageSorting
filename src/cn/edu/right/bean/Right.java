package cn.edu.right.bean;

import java.io.Serializable;
import java.util.Set;

public class Right implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String url;
	private Integer active;
	private Classes classes;
	private Set<Role> roles;

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Right() {
		super();
	}

	public Right(String name, String url, Integer active, Classes classes, Set<Role> roles) {
		super();
		this.name = name;
		this.url = url;
		this.active = active;
		this.classes = classes;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Right [id=" + id + ", name=" + name + ", url=" + url + ", active=" + active + "]";
	}

}
