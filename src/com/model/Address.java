package com.model;

public class Address {
	private Integer aid;
	private String province;
	private String city;
	private String area;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer aid, String province, String city, String area) {
		super();
		this.aid = aid;
		this.province = province;
		this.city = city;
		this.area = area;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return province + city +area ;
	}
	
	

}
