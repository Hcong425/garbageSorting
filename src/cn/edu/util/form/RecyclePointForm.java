package cn.edu.util.form;

public class RecyclePointForm {

	private Integer id;
	private Integer cell;
	private String pointName;
	private String robotNum;
	private String active;
	private String monitor;

	public Integer getCell() {
		return cell;
	}

	public void setCell(Integer cell) {
		this.cell = cell;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getRobotNum() {
		return robotNum;
	}

	public void setRobotNum(String robotNum) {
		this.robotNum = robotNum;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public RecyclePointForm(Integer cell, String pointName, String robotNum, String active, String monitor) {
		super();
		this.cell = cell;
		this.pointName = pointName;
		this.robotNum = robotNum;
		this.active = active;
		this.monitor = monitor;
	}

	public RecyclePointForm() {
		super();
	}

}
