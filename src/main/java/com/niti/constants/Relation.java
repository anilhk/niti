package com.niti.constants;

public enum Relation {

	Spouse("Spouse"),
	Child("Child"),
	Other("Other");
	
	private String name;
	
	private Relation(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
