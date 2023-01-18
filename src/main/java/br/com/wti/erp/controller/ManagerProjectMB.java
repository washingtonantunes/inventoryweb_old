package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.entity.Filter;
import br.com.wti.erp.domain.entity.Project;
import br.com.wti.erp.domain.vo.QuantityObjectForProject;
import br.com.wti.erp.service.ProjectService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManagerProjectMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjectService projectService;
	
	@Getter
	@Setter
	private Project entity;
	
	@Inject
	@Getter
	@Setter
	private Filter filter;

	@Getter
	private List<Project> searchResult;
	
	@PostConstruct
	public void init() {
	}
	
	public void search() {
		searchResult = projectService.findAllByParam(filter);

		if (searchResult.isEmpty()) {
			messageInfo("Sua consulta não retornou registros.");
		}
	}
	
	public void updateQuantity() {
		
		if(entity != null) {
			QuantityObjectForProject quantity = projectService.getQuantityObjectForProject(entity.getId());
			
			entity.setQuantityComputers(quantity.getComputers());
			entity.setQuantityMonitors(quantity.getMonitors());
			entity.setQuantityUsers(quantity.getUsers());
		}
	}
}
