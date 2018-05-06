package cn.edu.util.form;

public class RubbishItemForm {

	private Integer rubbishItem;
	private Integer manger;
	private Integer user;
	private Integer recyclePoint;
	private Integer rubbish;
	private String rubbishWeight;

	public Integer getRubbishItem() {
		return rubbishItem;
	}

	public void setRubbishItem(Integer rubbishItem) {
		this.rubbishItem = rubbishItem;
	}

	public Integer getManger() {
		return manger;
	}

	public void setManger(Integer manger) {
		this.manger = manger;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getRecyclePoint() {
		return recyclePoint;
	}

	public void setRecyclePoint(Integer recyclePoint) {
		this.recyclePoint = recyclePoint;
	}

	public Integer getRubbish() {
		return rubbish;
	}

	public void setRubbish(Integer rubbish) {
		this.rubbish = rubbish;
	}

	public String getRubbishWeight() {
		return rubbishWeight;
	}

	public void setRubbishWeight(String rubbishWeight) {
		this.rubbishWeight = rubbishWeight;
	}

	public RubbishItemForm(Integer rubbishItem, Integer manger, Integer user, Integer recyclePoint, Integer rubbish,
			String rubbishWeight) {
		super();
		this.rubbishItem = rubbishItem;
		this.manger = manger;
		this.user = user;
		this.recyclePoint = recyclePoint;
		this.rubbish = rubbish;
		this.rubbishWeight = rubbishWeight;
	}

	public RubbishItemForm() {
		super();
	}

}
