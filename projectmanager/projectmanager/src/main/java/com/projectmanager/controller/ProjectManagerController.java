package com.projectmanager.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.TraceableResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanager.model.Project;
import com.projectmanager.model.User;
import com.projectmanager.repository.ProjectRepository;
import com.projectmanager.service.ProjectService;
import com.projectmanager.service.UserService;

@RestController
@CrossOrigin
public class ProjectManagerController {
	
	Logger logger = LoggerFactory.getLogger(ProjectManagerController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(path="projectManager/user/save",method=RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user){
		logger.info("Adding New User ");

		User userResponse = userService.saveUser(user);
		if(null != userResponse) {
			return ResponseEntity.ok(userResponse);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(user);
		}
	}
	
	@RequestMapping(path="projectManager/user/update",method=RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User user){
		logger.info("updating user");
		
		User userResponse = userService.saveUser(user);
		if(null != userResponse) {
			return ResponseEntity.ok(userResponse);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(user);
		}
	}
	
	@RequestMapping(path="projectManager/user/delete",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathParam("userId") long userId){
		logger.info("deleteing user");
		User user = userService.getUserById(userId);
		if(null != user) {
			userService.deleteUser(user);
			return ResponseEntity.ok(HttpStatus.OK);
		}else {
			return ResponseEntity.ok(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "projectManager/user/getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getAllUser(){
		logger.info("Get All User ");
		List<User> allUserList = userService.getAll();
		return ResponseEntity.ok(allUserList);
		
	}
	
	
	@RequestMapping( value="projectManager/project/save", method=RequestMethod.POST)
	public ResponseEntity<?> saveProject(@RequestBody Project project){
		logger.info("Adding new project");
		Project projectRespponse = projectService.saveProject(project);
		if( null != projectRespponse) {
			return ResponseEntity.ok(projectRespponse);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(projectRespponse);
		}
		
	}
	
	@RequestMapping( value="projectManager/project/delete", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteProject(@PathParam("projectId") Long projectId){
		Project projectResponse = projectService.getProjectById(projectId);
		if( null != projectResponse ) {
			 projectService.deleteProjectById(projectId);
			 return ResponseEntity.ok(projectResponse);
		}else {
			return ResponseEntity.ok(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/projectManager/project/getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getAllProject(){
		List<Project> projectList = projectService.getAll();
		if(null != projectList) {
			return ResponseEntity.ok(projectList);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(projectList);
		}
	}
	
	@RequestMapping(value="/projectManager/project/update", method=RequestMethod.POST)
	public ResponseEntity<?> updateProject(@RequestBody Project project){
		Project projectResponse = projectService.saveProject(project);
		if(null != projectResponse) {
			return ResponseEntity.ok(projectResponse);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(projectResponse);
		}
	}
	
	
	

}
