package com.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanager.model.ParentTask;

@Repository
public interface ParentTaskRepository  extends JpaRepository<ParentTask, Long>{

}
