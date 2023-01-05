package br.com.wti.erp.domain.dashboard;

import java.io.Serializable;

import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.donut.DonutChartModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long serialVersionUID = 1L;

	private DetailObjectCard cardDetailComputers;

	private DetailObjectCard cardDetailMonitors;

	private DetailObjectCard cardDetailPeripherals;

	private DetailObjectCard cardDetailLicenses;

	private DetailObjectCard cardDetailUsers;

	private DonutChartModel consumptionDonutChartModel;

	private BarChartModel logisticsBarChartModel;

}
