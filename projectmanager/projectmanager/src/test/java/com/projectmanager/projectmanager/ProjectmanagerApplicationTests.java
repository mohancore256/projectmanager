package com.projectmanager.projectmanager;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.projectmanager.model.Project;
import com.projectmanager.model.User;
import com.projectmanager.service.ProjectService;
import com.projectmanager.service.UserService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectmanagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@LocalServerPort
    int randomServerPort;
	
	@Autowired
	private ProjectService projectService;	
	
	

	@Autowired
	private UserService userService;
	
	
	//For User Module Service
	@Test
	public void saveUser() {	
		User user = new User(null,"Mohan","Kasetti","PI00784",null,null);
		user = userService.saveUser(user);
		Assert.assertNotNull(user.getUserId());	    
	}
	
	@Test
	public void getAllUser() {
		List<User> users = userService.getAll();
		Assert.assertEquals(1, users.size());
	}
	
	//For Project module Service
	@Test
	public void saveProject() {
		Project project = new Project(null,"Sample Project",new Date(),new Date(),10,null,null,"IN-COMPLETE");
		project = projectService.saveProject(project);
		Assert.assertNotNull(project.getProjectId());
	}
	
	@Test
	public void getAllProjects() {
		Project project = new Project(null,"Sample Project",new Date(),new Date(),10,null,null,"IN-COMPLETE");
		project = projectService.saveProject(project);
		Project  projectObj = projectService.getProjectById(1L);
		Assert.assertNotNull(projectObj);	
	}
}
