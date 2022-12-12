package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.service.ProjectService;
import br.com.wti.erp.util.FacesMessages;

@ManagedBean
@ViewScoped
public class ManagerProjectMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesMessages messages = new FacesMessages();

	private ProjectService projectService = new ProjectService();

	private Project project;

	private List<Project> listProjects;

	private String paramSearch;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void search() {
		listProjects = projectService.findAllByParam(this.paramSearch);

		if (listProjects.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	public List<Project> getListProjects() {
		return listProjects;
	}

	public String getParamSearch() {
		return paramSearch;
	}

	public void setParamSearch(String paramSearch) {
		this.paramSearch = paramSearch;
	}
}
