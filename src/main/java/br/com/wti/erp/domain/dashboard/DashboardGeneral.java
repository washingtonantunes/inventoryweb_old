package br.com.wti.erp.domain.dashboard;

import java.io.Serializable;

import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.pie.PieChartModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardGeneral implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer yearSelected;

	private DetailObjectCard cardDetailComputers;

	private DetailObjectCard cardDetailMonitors;

	private DetailObjectCard cardDetailPeripherals;

	private DetailObjectCard cardDetailLicenses;

	private DetailObjectCard cardDetailUsers;

	private BarChartModel logisticsBarChartModel;

	private PieChartModel percentageComputersPieChartModel;

	private PieChartModel percentageMonitorsPieChartModel;

	private PieChartModel percentagePeripheralsPieChartModel;

	private PieChartModel percentageLicensesPieChartModel;
}
