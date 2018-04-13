package com.example.hibernate.model;

import java.io.Serializable;

public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer projectId;
	private String projectName;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
