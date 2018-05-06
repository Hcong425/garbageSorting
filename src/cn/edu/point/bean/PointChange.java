package cn.edu.point.bean;

import java.io.Serializable;
import java.util.Date;

import cn.edu.manger.bean.Manger;
import cn.edu.rubbish.bean.Rubbish;

public class PointChange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date time;
	private Integer beforePoint;
	private Integer afterPoint;
	private Manger manger;
	private Rubbish rubbish;
	private Commodity commodity;

	public Rubbish getRubbish() {
		return rubbish;
	}

	public void setRubbish(Rubbish rubbish) {
		this.rubbish = rubbish;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public PointChange() {
		super();
	}

	public Integer getBeforePoint() {
		return beforePoint;
	}

	public void setBeforePoint(Integer beforePoint) {
		this.beforePoint = beforePoint;
	}

	public Integer getAfterPoint() {
		return afterPoint;
	}

	public void setAfterPoint(Integer afterPoint) {
		this.afterPoint = afterPoint;
	}

	public PointChange(Date time, Integer beforePoint, Integer afterPoint, Manger manger, Rubbish rubbish,
			Commodity commodity) {
		super();
		this.time = time;
		this.beforePoint = beforePoint;
		this.afterPoint = afterPoint;
		this.manger = manger;
		this.rubbish = rubbish;
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "PointChange [id=" + id + ", time=" + time + ", beforePoint=" + beforePoint + ", afterPoint="
				+ afterPoint + "]";
	}

}
