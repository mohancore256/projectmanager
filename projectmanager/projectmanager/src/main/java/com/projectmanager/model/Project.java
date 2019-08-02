package com.projectmanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROJECT_ID")
	private Long ProjectId;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="START_DATE")
	@JsonFormat (pattern = "MM-dd-yyy")
	private Date startDate;
	
	@Column(name="END_DATE")
	@JsonFormat(pattern = "MM-dd-yyy")
	private Date endDate;
	
	@Column(name="PRIORITY")
	private Integer Priority;

	public Long getProjectId() {
		return ProjectId;
	}

	public void setProjectId(Long projectId) {
		ProjectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public Integer getPriority() {
		return Priority;
	}

	public void setPriority(Integer priority) {
		Priority = priority;
	}

	@Override
	public String toString() {
		return "Project [ProjectId=" + ProjectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", Priority=" + Priority + "]";
	}
	
	
	

}
