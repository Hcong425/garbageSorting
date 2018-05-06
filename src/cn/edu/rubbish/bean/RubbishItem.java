package cn.edu.rubbish.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.edu.manger.bean.Manger;
import cn.edu.manger.bean.User;

public class RubbishItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Rubbish rubbish;
	private Integer point;
	private User user;
	private Date time;
	private Manger manger;
	private BigDecimal weight;
	private RecyclePoint recyclePoint;

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

	public Manger getManger() {
		return manger;
	}

	public void setManger(Manger manger) {
		this.manger = manger;
	}

	public RecyclePoint getRecyclePoint() {
		return recyclePoint;
	}

	public void setRecyclePoint(RecyclePoint recyclePoint) {
		this.recyclePoint = recyclePoint;
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

	public Rubbish getRubbish() {
		return rubbish;
	}

	public void setRubbish(Rubbish rubbish) {
		this.rubbish = rubbish;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public RubbishItem(Rubbish rubbish, Integer point, User user, Date time, Manger manger, BigDecimal weight,
			RecyclePoint recyclePoint) {
		super();
		this.rubbish = rubbish;
		this.point = point;
		this.user = user;
		this.time = time;
		this.manger = manger;
		this.weight = weight;
		this.recyclePoint = recyclePoint;
	}

	public RubbishItem() {
		super();
	}

}
