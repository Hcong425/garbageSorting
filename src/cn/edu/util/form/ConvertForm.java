package cn.edu.util.form;

import java.util.List;

public class ConvertForm {

	private Integer user;
	private List<Integer> commodity;
	private List<Integer> amount;

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public List<Integer> getCommodity() {
		return commodity;
	}

	public void setCommodity(List<Integer> commodity) {
		this.commodity = commodity;
	}

	public List<Integer> getAmount() {
		return amount;
	}

	public void setAmount(List<Integer> amount) {
		this.amount = amount;
	}

	public ConvertForm() {
		super();
	}

	@Override
	public String toString() {
		return "ConvertForm [user=" + user + ", commodity=" + commodity + ", amount=" + amount + "]";
	}
}
