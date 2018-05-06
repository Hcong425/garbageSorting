package cn.edu.point.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import cn.edu.manger.bean.User;

public class Convert implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Integer point;
	private Date time;
	private int amount;
	private Set<ConvertItem> convertItems;

	public Set<ConvertItem> getConvertItems() {
		return convertItems;
	}

	public void setConvertItems(Set<ConvertItem> convertItems) {
		this.convertItems = convertItems;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Convert() {
		super();
	}

	public Convert(User user, Integer point, Date time, int amount, Set<ConvertItem> convertItems) {
		super();
		this.user = user;
		this.convertItems = convertItems;
		this.point = point;
		this.time = time;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Convert [id=" + id + ", user=" + user + ", point=" + point + ", time=" + time + ", amount=" + amount
				+ ", convertItems=" + convertItems + "]";
	}

}
