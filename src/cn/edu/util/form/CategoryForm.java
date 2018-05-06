package cn.edu.util.form;

public class CategoryForm {

	private Integer id;
	private String name;
	private String isPar;
	private Integer parCategoryId;

	public String getIsPar() {
		return isPar;
	}

	public void setIsPar(String isPar) {
		this.isPar = isPar;
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

	public Integer getParCategoryId() {
		return parCategoryId;
	}

	public void setParCategoryId(Integer parCategoryId) {
		this.parCategoryId = parCategoryId;
	}

	public CategoryForm() {
		super();
	}

	public CategoryForm(String name, String isPar, Integer parCategoryId) {
		super();
		this.name = name;
		this.isPar = isPar;
		this.parCategoryId = parCategoryId;
	}

}
