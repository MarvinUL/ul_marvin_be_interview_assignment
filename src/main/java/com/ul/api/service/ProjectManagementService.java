package com.ul.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ul.api.entity.Project;
import com.ul.api.enumeration.StatusEnum;
import com.ul.api.repository.ProjectManagementRepository;

/**
 * 
 * @author neelabh
 * @apiNote This is service layer of Project Management Flow
 *
 */
@Service
public class ProjectManagementService {

	@Autowired
	ProjectManagementRepository projectManagementRepository;

	/**
	 * 
	 * @param project
	 * @return created project
	 */
	public ResponseEntity<Project> createProject(Project project) {
		try {
			Project projectData = projectManagementRepository.save(
					new Project(project.getName(), project.getStatus(), LocalDateTime.now(), project.isArchived()));
			return new ResponseEntity<>(projectData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @return list of projects that are not archived
	 */
	public ResponseEntity<List<Project>> findProjectsNotArchived() {
		try {
			List<Project> projects = new ArrayList<>();

			projectManagementRepository.findByArchivedFalse().forEach(projects::add);

			if (projects.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(projects, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param id
	 * @return Updated project with status FINISHED and archived True
	 */
	public ResponseEntity<Project> archiveProjectById(Long id) {
		Optional<Project> projectData = projectManagementRepository.findById(id);

		if (projectData.isPresent()) {
			Project project = projectData.get();
			project.setStatus(StatusEnum.FINISHED);
			project.setArchived(Boolean.TRUE);
			return new ResponseEntity<>(projectManagementRepository.save(project), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
