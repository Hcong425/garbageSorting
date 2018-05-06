package cn.edu.util.form;

import java.util.Set;

public class RoleForm {

	private Integer id;
	private String name;
	private Set<Integer> rights;

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

	public Set<Integer> getRights() {
		return rights;
	}

	public void setRights(Set<Integer> rights) {
		this.rights = rights;
	}

	public RoleForm(Integer id, String name, Set<Integer> rights) {
		super();
		this.id = id;
		this.name = name;
		this.rights = rights;
	}

	public RoleForm() {
		super();
	}

	@Override
	public String toString() {
		return "RoleForm [id=" + id + ", name=" + name + ", rights=" + rights + "]";
	}

}
