package cn.edu.util.form;

public class RubbishForm {

	private Integer id;
	private String name;
	private String active;
	private String descr;
	private String point;
	private String monitor;
	private String condition;
	private Integer parRubbishId;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParRubbishId() {
		return parRubbishId;
	}

	public void setParRubbishId(Integer parRubbishId) {
		this.parRubbishId = parRubbishId;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public RubbishForm(String name, String active, String descr, String point, String monitor, Integer parRubbishId) {
		super();
		this.name = name;
		this.active = active;
		this.descr = descr;
		this.point = point;
		this.monitor = monitor;
		this.parRubbishId = parRubbishId;
	}

	public RubbishForm() {
		super();
	}

	@Override
	public String toString() {
		return "RubbishForm [name=" + name + ", active=" + active + ", descr=" + descr + ", point=" + point
				+ ", monitor=" + monitor + ", parRubbishId=" + parRubbishId + "]";
	}
}
