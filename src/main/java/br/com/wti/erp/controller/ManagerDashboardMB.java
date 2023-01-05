package br.com.wti.erp.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.dashboard.Dashboard;
import br.com.wti.erp.domain.enums.TypeConsumptionEnum;
import br.com.wti.erp.service.DashboardService;
import lombok.Getter;

@Named
@ViewScoped
public class ManagerDashboardMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DashboardService service;

	@Inject
	@Getter
	private Dashboard dashboard;
	
	@PostConstruct
	public void init() {
		service.setDataCards(dashboard);
		
		service.setDataDonut(dashboard);
	}
	
	public void changeDados() {
		service.setDataDonut(dashboard);
	}
	
	public TypeConsumptionEnum[] getTypeConsumption() {
		return TypeConsumptionEnum.values();
	}

}
