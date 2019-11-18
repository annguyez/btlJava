package com.gr21.model;

public class SizeDTO {

	private int size_id;
	private String size;
	public int getSize_id() {
		return size_id;
	}
	public String getSize() {
		return size;
	}
	public void setSize_id(int size_id) {
		this.size_id = size_id;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public SizeDTO(int size_id, String size) {
		super();
		this.size_id = size_id;
		this.size = size;
	}
	
}
