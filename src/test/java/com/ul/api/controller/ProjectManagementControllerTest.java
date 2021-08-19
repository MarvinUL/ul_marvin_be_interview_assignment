package com.ul.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ul.api.BackendAppTest;
import com.ul.api.entity.Project;
import com.ul.api.enumeration.StatusEnum;

/**
 * 
 * @author neelabh
 * @apiNote This is test file for ProjectManagementController
 * @category ProjectManagementController
 *
 */

public class ProjectManagementControllerTest extends BackendAppTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	/**
	 * @apiNote junit test for findProjectsNotArchived method of
	 *          ProjectManagementController
	 * @throws Exception
	 */
	@Test
	public void findProjectsNotArchivedTest() throws Exception {
		String uri = "/projectManagement/projects";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/**
	 * @apiNote junit test for createProject method of ProjectManagementController
	 * @throws Exception
	 */
	@Test
	public void createProjectTest() throws Exception {
		String uri = "/projectManagement/projects";
		Project project = new Project();
		project.setId(1L);
		project.setName("test");
		project.setStatus(StatusEnum.IN_PROGRESS);
		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
	}

	/**
	 * @apiNote junit test for archiveProjectById method of
	 *          ProjectManagementController
	 * @throws Exception
	 */
	@Test
	public void archiveProjectByIdTest() throws Exception {
		String uri = "/projectManagement/projects/1";
		Project project = new Project();
		project.setArchived(Boolean.TRUE);
		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
