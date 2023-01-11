package br.com.wti.erp.domain.dashboard;

import java.io.Serializable;

import org.primefaces.model.charts.line.LineChartModel;

import br.com.wti.erp.domain.dto.QuantityObjectForProject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardForProject implements Serializable {

	private static final long serialVersionUID = 1L;

	private String projectSelected;

	private String yearSelected;

	private QuantityObjectForProject quantityObject;

	private LineChartModel costLineChartModel;
}
