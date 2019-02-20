package com.example.demo.model;

import java.io.Serializable;

public class Greeting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1644262086084126656L;

	private String content;

	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Greeting(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
