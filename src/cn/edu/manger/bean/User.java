package cn.edu.manger.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import cn.edu.point.bean.Convert;
import cn.edu.rubbish.bean.RubbishItem;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	private Date time;
	private Set<Convert> converts;
	private Set<RubbishItem> rubbishItems;
	private Integer point;
	private String eamil;
	private String telphone;
	private String address;

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Convert> getConverts() {
		return converts;
	}

	public void setConverts(Set<Convert> converts) {
		this.converts = converts;
	}

	public Set<RubbishItem> getRubbishItems() {
		return rubbishItems;
	}

	public void setRubbishItems(Set<RubbishItem> rubbishItems) {
		this.rubbishItems = rubbishItems;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public User() {
		super();
	}

	public User(String name, String password, Date time, Set<Convert> converts, Set<RubbishItem> rubbishItems,
			Integer point, String eamil, String telphone, String address) {
		super();
		this.name = name;
		this.password = password;
		this.time = time;
		this.converts = converts;
		this.rubbishItems = rubbishItems;
		this.point = point;
		this.eamil = eamil;
		this.telphone = telphone;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", time=" + time + ", point=" + point
				+ ", eamil=" + eamil + ", telphone=" + telphone + ", address=" + address + "]";
	}

}
