package br.com.wti.erp.domain.dashboard;

import java.io.Serializable;

import org.primefaces.model.charts.donut.DonutChartModel;

import br.com.wti.erp.domain.enums.TypeConsumptionEnum;
import lombok.Getter;
import lombok.Setter;

public class Dashboard implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private DetailObjectCard cardDetailComputers;
	
	@Getter
	@Setter
	private DetailObjectCard cardDetailMonitors;
	
	@Getter
	@Setter
	private DetailObjectCard cardDetailPeripherals;
	
	@Getter
	@Setter
	private DetailObjectCard cardDetailLicenses;
	
	@Getter
	@Setter
	private DetailObjectCard cardDetailUsers;
	
	@Getter
	@Setter
	private TypeConsumptionEnum typeConsumptionSelected;
	
	@Getter
	@Setter
	private DonutChartModel donutModel;

}
