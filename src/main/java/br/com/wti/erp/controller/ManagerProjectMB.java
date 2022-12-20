package br.com.wti.erp.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.service.ProjectService;

@Named
@ViewScoped
public class ManagerProjectMB extends BaseCrudMB<Project> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjectService projectService;
	
	@PostConstruct
	@Override
	public void init() {
		setService(projectService);
	}

	@Override
	public void preNew(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posNew(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posUpdate(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSave(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posSave(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	@Getter
	private Long allComputers;
	
	@Getter
	private Long allUsers;
	
	@Getter
	private Long allMonitors;
	
	public void updateQuantity() {
		if(project != null) {
			allComputers = projectService.allComputers(project);
			
			allUsers = projectService.allUsers(project);
			
			allMonitors = projectService.allMonitors(project);
		}
	}
}
