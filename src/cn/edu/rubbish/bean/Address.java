package cn.edu.rubbish.bean;

import java.io.Serializable;
import java.util.Set;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Set<Address> childAddress;
	private Address parAddress;

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

	public Set<Address> getChildAddress() {
		return childAddress;
	}

	public void setChildAddress(Set<Address> childAddress) {
		this.childAddress = childAddress;
	}

	public Address getParAddress() {
		return parAddress;
	}

	public void setParAddress(Address parAddress) {
		this.parAddress = parAddress;
	}

	public Address(Integer id, String name, Set<Address> childAddress, Address parAddress) {
		super();
		this.id = id;
		this.name = name;
		this.childAddress = childAddress;
		this.parAddress = parAddress;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + "]";
	}

}
