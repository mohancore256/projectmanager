package com.projectmanager.repository;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projectmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query( nativeQuery = true, value="select * from Task Orderby START_DATE ")
	public List<Task> sortingTaskByStartDate();
	
	@Query( nativeQuery = true, value="select * from Task Orderby END_DATE ")
	public List<Task> sortingTaskByEndDate();

}
