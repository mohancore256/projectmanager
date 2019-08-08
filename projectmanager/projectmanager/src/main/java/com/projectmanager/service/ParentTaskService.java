package com.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.model.ParentTask;
import com.projectmanager.repository.ParentTaskRepository;

@Service
public class ParentTaskService {

	@Autowired
	private ParentTaskRepository parentTaskRepository;
	
	
	public ParentTask saveParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}
	
	public ParentTask updateParentTask(ParentTask parentTask) {
		return parentTaskRepository.save(parentTask);
	}
	
	public List<ParentTask> getAllParentTask( ) {
		return parentTaskRepository.findAll();
	}
	
	public ParentTask getParentTaskById(Long parentTaskId) {
	    return parentTaskRepository.findById(parentTaskId).get();	
	}
	
	public void deleteParentTaskById(Long parentTaskId) {
		parentTaskRepository.deleteById(parentTaskId);
	}
	
	
	
	
	
	
	
}
