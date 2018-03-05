/**
 * 
 */
package com.beans;

import java.io.Serializable;

/**
 * @author dranandrao
 *
 */
public class Component implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7529030392968700769L;
	private int component_id;
	private String component_name;
	private int quantity;
	private String branch;

	public int getComponent_id() {
		return component_id;
	}

	public void setComponent_id(int component_id) {
		this.component_id = component_id;
	}

	public String getComponent_name() {
		return component_name;
	}

	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
