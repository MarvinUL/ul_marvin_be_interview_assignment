package com.ul.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ul.api.enumeration.StatusEnum;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "projects")
public class Project {
	
	public Project(String name, StatusEnum status, LocalDateTime dateCreated, Boolean archived) {
		this.name=name;
		this.status=status;
		this.dateCreated=dateCreated;
		this.archived=archived;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private StatusEnum status;
	@Column
	private LocalDateTime dateCreated;
	@Column
	boolean archived;

	
}
