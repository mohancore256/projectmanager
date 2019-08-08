package com.projectmanager.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TASK_ID")
	private Long taskId;

	/*
	 * @Column(name = "PARENT_ID") private Long parentId;
	 */


	@Column(name = "START_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@Column(name = "END_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name ="TASK_NAME")
	private String taskName;

	@OneToMany(mappedBy="task",cascade = CascadeType.ALL)	
	private Set<User> users;
	
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	//@JsonIgnore	
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_TASK_ID",nullable=true)
	//@JsonIgnore
	private ParentTask parentTask;

	
    
	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}




	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority
				+ ", status=" + status + ", taskName=" + taskName + ", users=" + users + ", project=" + project
				+ ", parentTask=" + parentTask + "]";
	}



	

}
