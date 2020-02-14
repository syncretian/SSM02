package com.model;

import java.util.Arrays;

public class MyFile {
	private Integer id;
	private String username;
	private String description;
	
	private byte[] text;
	private byte[] picture;
	public MyFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyFile(Integer id, String username, String description, byte[] text, byte[] picture) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.text = text;
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "MyFile [id=" + id + ", username=" + username + ", description=" + description + ", text="
				+ Arrays.toString(text) + ", picture=" + Arrays.toString(picture) + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getText() {
		return text;
	}
	public void setText(byte[] text) {
		this.text = text;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	
}
