package com.ul.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ul.api.enumeration.StatusEnum;

/**
 * 
 * @author neelabh
 * @apiNote Model file for Project Management Flow
 *
 */
@Entity
@Table(name = "projects")
public class Project {
	/**
	 * 
	 * @param name
	 * @param status
	 * @param dateCreated
	 * @param archived
	 */
	public Project(String name, StatusEnum status, LocalDateTime dateCreated, Boolean archived) {
		this.name = name;
		this.status = status;
		this.dateCreated = dateCreated;
		this.archived = archived;
	}

	/**
	 * Defaul Constructor
	 */
	public Project() {

	}

	/**
	 * Long id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * name
	 */
	@Column
	private String name;
	@Column
	/**
	 * status
	 */
	private StatusEnum status;
	@Column
	/**
	 * dateCreated
	 */
	private LocalDateTime dateCreated;
	/**
	 * archived
	 */
	@Column
	boolean archived;

	/**
	 * 
	 * @return Long id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param Long id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return String name of the project
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param String name of the project
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Enum ("IN_PROGRESS","FINISHED")
	 */
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * 
	 * @param Return enum status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	/**
	 * 
	 * @return Date and time
	 */
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	/**
	 * 
	 * @param Date and time
	 */
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * @return Boolean Archived
	 */
	public boolean isArchived() {
		return archived;
	}

	/**
	 * 
	 * @param Boolean Archived
	 */
	public void setArchived(boolean archived) {
		this.archived = archived;
	}

}
