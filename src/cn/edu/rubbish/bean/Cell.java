package cn.edu.rubbish.bean;

public class Cell {

	private Integer id;
	private Address address;
	private String longitude; // 经度
	private String latitude; // 纬度
	private String name;
	private boolean terget;

	public void setTerget(boolean terget) {
		this.terget = terget;
	}

	public boolean isTerget() {
		return terget;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cell(Address address, String longitude, String latitude, String name) {
		super();
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
	}

	public Cell() {
		super();
	}

}
