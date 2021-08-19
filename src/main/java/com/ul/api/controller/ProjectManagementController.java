package com.ul.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ul.api.entity.Project;
import com.ul.api.service.ProjectManagementService;
/**
 * 
 * @author neelabh
 * @apiNote ProjectManagementController file containing POST,GET and PUT methods
 *
 */
@RestController
@RequestMapping("/projectManagement")
public class ProjectManagementController {
	@Autowired
	ProjectManagementService projectManagementService;

	@PostMapping("/projects")
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		return projectManagementService.createProject(project);
	}

	@GetMapping("/projects")
	public ResponseEntity<List<Project>> findProjectsNotArchived() {
		return projectManagementService.findProjectsNotArchived();
	}

	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> archiveProjectById(@PathVariable("id") long id) {
		return projectManagementService.archiveProjectById(id);
	}

}
