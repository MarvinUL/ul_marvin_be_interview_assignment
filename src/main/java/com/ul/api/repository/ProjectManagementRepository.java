package com.ul.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ul.api.entity.Project;
@Repository
public interface ProjectManagementRepository extends JpaRepository<Project, Long>{

	List<Project> findByArchivedFalse();

}
