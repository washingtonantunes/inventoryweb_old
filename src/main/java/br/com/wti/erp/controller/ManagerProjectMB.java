package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.ProjectService;
import br.com.wti.erp.util.FacesMessages;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ManagerProjectMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesMessages messages = new FacesMessages();

	private ProjectService projectService = new ProjectService();

	@Getter
	@Setter
	private Project project;

	@Getter
	private List<Project> listProjects;

	@Getter
	@Setter
	private Filter filter = new Filter();

	public void search() {
		listProjects = projectService.findAllByParam(this.filter);

		if (listProjects.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
}
