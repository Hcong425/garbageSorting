package cn.edu.manger.bean;

import java.io.Serializable;
import java.util.Set;

import cn.edu.right.bean.Role;
import cn.edu.rubbish.bean.RecyclePoint;

public class Manger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	private Set<RecyclePoint> recyclePoints;
	private Role role;

	public Set<RecyclePoint> getRecyclePoints() {
		return recyclePoints;
	}

	public void setRecyclePoints(Set<RecyclePoint> recyclePoints) {
		this.recyclePoints = recyclePoints;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Manger() {
		super();
	}

	public Manger(String name, String password, Set<RecyclePoint> recyclePoints, Role role) {
		super();
		this.name = name;
		this.password = password;
		this.recyclePoints = recyclePoints;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Manger [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
