package com.beans;

import java.io.Serializable;

public class Transaction implements Serializable{
	private int university_number;
	private int component_id;
	private int quantity;
	private String faculty;
	private String borrow_date;
	public int getUniversity_number() {
		return university_number;
	}
	public void setUniversity_number(int university_number) {
		this.university_number = university_number;
	}
	public int getComponent_id() {
		return component_id;
	}
	public void setComponent_id(int component_id) {
		this.component_id = component_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
}
