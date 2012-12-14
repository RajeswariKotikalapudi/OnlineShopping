package com.pc.onlineshopping.entities;

import java.io.Serializable;

public class Account implements Serializable{
	private String name;
	private String description;
	private String referenceId;
	
	public Account(){}

	public Account(String name, String description, String referenceId) {
		super();
		this.name = name;
		this.description = description;
		this.referenceId = referenceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	
}
