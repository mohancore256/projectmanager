/**
 * 
 */
package com.projectmanager.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author mkase
 *
 */
@Entity
public class ParentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "PARENT_TASK_NAME")
	private String parentTaskName;
	
	@Column(name = "PARENT_TASK_ID")
	private long parentTaskId;
	
	@OneToMany(mappedBy="parentTask",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Task> tasks;
	
		
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getParentTaskName() {
		return parentTaskName;
	}
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}
	public long getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public Set<Task> getTasks() {
		return this.tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}	
}
