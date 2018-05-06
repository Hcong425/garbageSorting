package cn.edu.util.form;

public class RightForm {

	private Integer id;
	private String name;
	private String url;
	private String active;
	private Integer classes;

	public Integer getClasses() {
		return classes;
	}

	public void setClasses(Integer classes) {
		this.classes = classes;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public RightForm(String name, String url, String active, Integer classes) {
		super();
		this.name = name;
		this.url = url;
		this.active = active;
		this.classes = classes;
	}

	public RightForm() {
		super();
	}

	@Override
	public String toString() {
		return "RightForm [id=" + id + ", name=" + name + ", url=" + url + ", active=" + active + ", classes=" + classes
				+ "]";
	}

}
