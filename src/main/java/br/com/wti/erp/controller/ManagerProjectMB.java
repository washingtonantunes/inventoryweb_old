package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.ProjectService;
import br.com.wti.erp.util.FacesMessages;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManagerProjectMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages messages;

	@Inject
	private ProjectService projectService;

	@Getter
	@Setter
	private Project project;

	@Getter
	private List<Project> listProjects;

	@Inject
	@Getter
	@Setter
	private Filter filter;

	public void search() {
		listProjects = projectService.findAllByParam(this.filter);

		if (listProjects.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
}
