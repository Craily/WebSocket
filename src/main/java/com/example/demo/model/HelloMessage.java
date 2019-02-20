package com.example.demo.model;

import java.io.Serializable;

public class HelloMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4395183044455382813L;
	private String name;

	public HelloMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
