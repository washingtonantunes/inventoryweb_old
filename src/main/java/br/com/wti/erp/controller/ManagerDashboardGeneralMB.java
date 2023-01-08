package br.com.wti.erp.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.dashboard.DashboardGeneral;
import br.com.wti.erp.service.DashboardService;
import lombok.Getter;

@Named
@ViewScoped
public class ManagerDashboardGeneralMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DashboardService service;

	@Inject
	@Getter
	private DashboardGeneral dashboard;
	
	@Getter
	private List<String> years = new ArrayList<>();

	@PostConstruct
	public void init() {
		
		years.add("2021");
		years.add("2022");
		years.add("2023");
		
		dashboard.setYearSelected(Integer.toString(LocalDate.now().getYear()));
		
		service.setDataCardsGeneral(dashboard);

		service.setLogisticsBarChartModel(dashboard);

		service.setPercentagePieChartModel(dashboard);
	}
	
	public void changeParameterSearch() {
		service.setDataCardsGeneral(dashboard);

		service.setLogisticsBarChartModel(dashboard);

		service.setPercentagePieChartModel(dashboard);

	}

}
