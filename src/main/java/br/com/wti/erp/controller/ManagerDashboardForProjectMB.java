package br.com.wti.erp.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.dashboard.DashboardForProject;
import br.com.wti.erp.service.DashboardService;
import br.com.wti.erp.service.ProjectService;
import lombok.Getter;

@Named
@ViewScoped
public class ManagerDashboardForProjectMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DashboardService dashboardService;
	
	@Inject
	private ProjectService projectService;

	@Inject
	@Getter
	private DashboardForProject dashboard;
	
	@Getter
	private List<String> projects = new ArrayList<>();
	
	@Getter
	private List<String> years = new ArrayList<>();

	@PostConstruct
	public void init() {
		projects = projectService.findAllString();
		
		years.add("2021");
		years.add("2022");
		years.add("2023");
		
		dashboard.setYearSelected(Integer.toString(LocalDate.now().getYear()));
	}

	public void changeParameterSearch() {
		dashboardService.setDataCardsForProject(dashboard);

		dashboardService.setCostLineChartModel(dashboard);

	}
}
