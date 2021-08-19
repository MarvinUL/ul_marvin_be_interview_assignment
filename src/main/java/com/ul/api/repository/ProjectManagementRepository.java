package com.ul.api.repository;

import java.util.List;
/**
 * @author neelabh
 * Repository for Project Management Flow
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ul.api.entity.Project;

@Repository
public interface ProjectManagementRepository extends JpaRepository<Project, Long> {
	/**
	 * 
	 * @return list of Projects
	 */
	List<Project> findByArchivedFalse();

}
