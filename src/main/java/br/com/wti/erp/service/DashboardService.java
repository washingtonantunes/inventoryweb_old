package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.pie.PieChartOptions;

import br.com.wti.erp.domain.dashboard.CardDetailComputer;
import br.com.wti.erp.domain.dashboard.CardDetailLicense;
import br.com.wti.erp.domain.dashboard.CardDetailMonitor;
import br.com.wti.erp.domain.dashboard.CardDetailPeripheral;
import br.com.wti.erp.domain.dashboard.CardDetailUser;
import br.com.wti.erp.domain.dashboard.DashboardForProject;
import br.com.wti.erp.domain.dashboard.DashboardGeneral;
import br.com.wti.erp.domain.dto.QuantityChangesForMonth;
import br.com.wti.erp.domain.dto.QuantityForStatus;
import br.com.wti.erp.domain.dto.QuantityObjectForProject;
import br.com.wti.erp.domain.enums.StatusEquipmentEnum;
import br.com.wti.erp.domain.enums.StatusUserEnum;
import br.com.wti.erp.domain.enums.TypeChangeEnum;
import br.com.wti.erp.repository.DashboardRepository;

public class DashboardService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DashboardRepository dashboardRepository;

	public void setDataCardsGeneral(DashboardGeneral dashboard) {
		
		dashboard.setCardDetailComputer(getCardComputer());

		dashboard.setCardDetailMonitor(getCardMonitor());

		dashboard.setCardDetailPeripheral(getCardPeripheral());

		dashboard.setCardDetailLicense(getCardLicense());

		dashboard.setCardDetailUser(getCardUser());
	}

	public void setDataCardsForProject(DashboardForProject dashboard) {
		
		final QuantityObjectForProject  quantityObjectForProject = new QuantityObjectForProject();
		
		quantityObjectForProject.setComputers(Math.round(Math.random() * 100));
		quantityObjectForProject.setMonitors(Math.round(Math.random() * 100));
		quantityObjectForProject.setPeripherals(Math.round(Math.random() * 100));
		quantityObjectForProject.setLicenses(Math.round(Math.random() * 100));
		quantityObjectForProject.setUsers(Math.round(Math.random() * 100));
		
		dashboard.setQuantityObject(quantityObjectForProject);
	}

	public void setLogisticsBarChartModel(DashboardGeneral dashboard) {
		BarChartModel barModel = new BarChartModel();

		ChartData data = new ChartData();

		data.addChartDataSet(getDataDeliveries(dashboard));
		data.addChartDataSet(getDataExchanges(dashboard));
		data.addChartDataSet(getDataDevolutions(dashboard));

		List<String> labels = new ArrayList<>();
		labels.add("Janeiro");
		labels.add("Fevereiro");
		labels.add("Março");
		labels.add("Abril");
		labels.add("Maio");
		labels.add("Junho");
		labels.add("Julho");
		labels.add("Agosto");
		labels.add("Setembro");
		labels.add("Outubro");
		labels.add("Novembro");
		labels.add("Dezembro");
		data.setLabels(labels);

		barModel.setData(data);

		BarChartOptions options = new BarChartOptions();

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Logística");
		title.setFontSize(20);
		options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("bottom");
		options.setLegend(legend);

		barModel.setOptions(options);

		dashboard.setLogisticsBarChartModel(barModel);
	}

	public void setCostLineChartModel(DashboardForProject dashboard) {
		LineChartModel lineModel = new LineChartModel();

		ChartData data = new ChartData();

		data.addChartDataSet(obterDadosCusto());

		List<String> labels = new ArrayList<>();
		labels.add("Janeiro");
		labels.add("Fevereiro");
		labels.add("Março");
		labels.add("Abril");
		labels.add("Maio");
		labels.add("Junho");
		labels.add("Julho");
		labels.add("Agosto");
		labels.add("Setembro");
		labels.add("Outubro");
		labels.add("Novembro");
		labels.add("Dezembro");
		data.setLabels(labels);

		lineModel.setData(data);

		LineChartOptions options = new LineChartOptions();

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Custo");
		title.setFontSize(20);
		options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("bottom");
		options.setLegend(legend);

		lineModel.setOptions(options);

		dashboard.setCostLineChartModel(lineModel);
	}

	public void setPercentagePieChartModel(DashboardGeneral dashboard) {
		dashboard.setPercentageComputersPieChartModel(obterDadosPercentageComputers());
		dashboard.setPercentageMonitorsPieChartModel(obterDadosPercentageMonitors());
		dashboard.setPercentagePeripheralsPieChartModel(obterDadosPercentagePeripherals());
		dashboard.setPercentageLicensesPieChartModel(obterDadosPercentageLicenses());
	}

	private BarChartDataSet getDataDeliveries(DashboardGeneral dashboard) {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Entregas");
		dataSet.setBackgroundColor("rgba(163, 157, 212, 0.7)");
		dataSet.setBorderColor("rgb(163, 157, 212)");
		dataSet.setBorderWidth(1);

		List<QuantityChangesForMonth> values = dashboardRepository.getListChangesForYearAndType(dashboard.getYearSelected(), TypeChangeEnum.DELIVERY_TO_USER);

		if (values != null && !values.isEmpty()) {
			dataSet.setData(converterList(values));
		}

		return dataSet;
	}

	private BarChartDataSet getDataExchanges(DashboardGeneral dashboard) {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Trocas");
		dataSet.setBackgroundColor("rgba(236, 47, 111, 0.7)");
		dataSet.setBorderColor("rgb(236, 47, 111)");
		dataSet.setBorderWidth(1);

		List<QuantityChangesForMonth> values = dashboardRepository.getListChangesForYearAndType(dashboard.getYearSelected(), TypeChangeEnum.EXCHANGE_TO_USER);

		if (values != null && !values.isEmpty()) {
			dataSet.setData(converterList(values));
		}

		return dataSet;
	}

	private BarChartDataSet getDataDevolutions(DashboardGeneral dashboard) {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Devoluções");
		dataSet.setBackgroundColor("rgba(161, 171, 122, 0.7)");
		dataSet.setBorderColor("rgb(161, 171, 122)");
		dataSet.setBorderWidth(1);

		List<QuantityChangesForMonth> values = dashboardRepository.getListChangesForYearAndType(dashboard.getYearSelected(), TypeChangeEnum.DEVOLUTION_TO_USER);

		if (values != null && !values.isEmpty()) {
			dataSet.setData(converterList(values));
		}

		return dataSet;
	}

	private LineChartDataSet obterDadosCusto() {
		LineChartDataSet dataSet = new LineChartDataSet();
		dataSet.setLabel("Sinquia");
		dataSet.setBackgroundColor("rgba(248, 11, 5, 0.7)");
		dataSet.setBorderColor("rgb(248, 11, 5)");
		dataSet.setTension(0.1);
		dataSet.setFill(false);

		List<Object> values = new ArrayList<>();
		values.add(1500);
		values.add(1900);
		values.add(2005);
		values.add(10000);
		values.add(5600);
		values.add(45000);
		values.add(10000);
		values.add(20000);
		values.add(7000);
		values.add(80000);
		values.add(30000);
		values.add(4000);
		dataSet.setData(values);

		return dataSet;
	}

	private PieChartModel obterDadosPercentageComputers() {
		PieChartModel pieModel = new PieChartModel();

		ChartData data = new ChartData();

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(300);
		values.add(50);
		values.add(100);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(42, 150, 153)");
		bgColors.add("rgb(74, 189, 158)");
		bgColors.add("rgb(237, 77, 101)");
		dataSet.setBackgroundColor(bgColors);

		List<String> labels = new ArrayList<>();
		labels.add("Disponivel");
		labels.add("Em Uso");
		labels.add("Desativados");
		data.setLabels(labels);

		data.addChartDataSet(dataSet);

		pieModel.setData(data);

		PieChartOptions options = new PieChartOptions();

		Legend legend = new Legend();
		legend.setDisplay(false);
		options.setLegend(legend);

		pieModel.setOptions(options);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Computadores");
		title.setFontSize(15);
		options.setTitle(title);

		return pieModel;
	}

	private PieChartModel obterDadosPercentageMonitors() {
		PieChartModel pieModel = new PieChartModel();

		ChartData data = new ChartData();

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(300);
		values.add(50);
		values.add(100);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(0, 35, 245)");
		bgColors.add("rgb(120, 67, 21)");
		bgColors.add("rgb(169, 33, 107)");
		dataSet.setBackgroundColor(bgColors);

		List<String> labels = new ArrayList<>();
		labels.add("Disponivel");
		labels.add("Em Uso");
		labels.add("Desativados");
		data.setLabels(labels);

		data.addChartDataSet(dataSet);

		pieModel.setData(data);

		PieChartOptions options = new PieChartOptions();

		Legend legend = new Legend();
		legend.setDisplay(false);
		options.setLegend(legend);

		pieModel.setOptions(options);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Monitores");
		title.setFontSize(15);
		options.setTitle(title);

		return pieModel;
	}

	private PieChartModel obterDadosPercentagePeripherals() {
		PieChartModel pieModel = new PieChartModel();

		ChartData data = new ChartData();

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(300);
		values.add(50);
		values.add(100);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(55, 125, 34)");
		bgColors.add("rgb(235, 51, 36)");
		bgColors.add("rgb(239, 136, 190)");
		dataSet.setBackgroundColor(bgColors);

		List<String> labels = new ArrayList<>();
		labels.add("Disponivel");
		labels.add("Em Uso");
		labels.add("Desativados");
		data.setLabels(labels);

		data.addChartDataSet(dataSet);

		pieModel.setData(data);

		PieChartOptions options = new PieChartOptions();

		Legend legend = new Legend();
		legend.setDisplay(false);
		options.setLegend(legend);

		pieModel.setOptions(options);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Peripheral");
		title.setFontSize(15);
		options.setTitle(title);

		return pieModel;
	}

	private PieChartModel obterDadosPercentageLicenses() {
		PieChartModel pieModel = new PieChartModel();

		ChartData data = new ChartData();

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(300);
		values.add(50);
		values.add(100);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(137, 56, 118)");
		bgColors.add("rgb(43, 89, 38)");
		bgColors.add("rgb(75, 164, 166)");
		dataSet.setBackgroundColor(bgColors);

		List<String> labels = new ArrayList<>();
		labels.add("Disponivel");
		labels.add("Em Uso");
		labels.add("Desativados");
		data.setLabels(labels);

		data.addChartDataSet(dataSet);

		pieModel.setData(data);

		PieChartOptions options = new PieChartOptions();

		Legend legend = new Legend();
		legend.setDisplay(false);
		options.setLegend(legend);

		pieModel.setOptions(options);

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Licenças");
		title.setFontSize(15);
		options.setTitle(title);

		return pieModel;
	}

	private List<Number> converterList(List<QuantityChangesForMonth> values) {

		QuantityChangesForMonth[] quantidades = new QuantityChangesForMonth[12];

		for (QuantityChangesForMonth value : values) {
			int id = value.getDate();
			quantidades[id - 1] = value;
		}

		List<Number> numbers = new ArrayList<>();

		for (QuantityChangesForMonth quantity : quantidades) {
			if (quantity != null) {
				numbers.add(quantity.getQuantity());
			} else {
				numbers.add(0L);
			}
		}

		return numbers;
	}
	
	public CardDetailComputer getCardComputer() {
		
		List<QuantityForStatus> listQuantityStatus = dashboardRepository.getQuantityForStatusComputer();

		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			long quantityStandBy = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.STAND_BY)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityInUse = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.IN_USE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityDisabled = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityTotal = quantityStandBy + quantityInUse + quantityDisabled;
			
			return new CardDetailComputer(quantityTotal, quantityStandBy, quantityInUse, quantityDisabled);
		}
		return new CardDetailComputer();
	}
	
	public CardDetailMonitor getCardMonitor() {

		List<QuantityForStatus> listQuantityStatus = dashboardRepository.getQuantityForStatusMonitor();
		//TODO unificar o status
		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			long quantityStandBy = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.STAND_BY)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityInUse = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.IN_USE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityDisabled = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityTotal = quantityStandBy + quantityInUse + quantityDisabled;

			return new CardDetailMonitor(quantityTotal, quantityStandBy, quantityInUse, quantityDisabled);
		}
		return new CardDetailMonitor();
	}
	
	public CardDetailPeripheral getCardPeripheral() {

		List<QuantityForStatus> listQuantityStatus = dashboardRepository.getQuantityForStatusPeripheral();

		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			long quantityStandBy = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.STAND_BY)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityInUse = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.IN_USE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityDisabled = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityTotal = quantityStandBy + quantityInUse + quantityDisabled;

			return new CardDetailPeripheral(quantityTotal, quantityStandBy, quantityInUse, quantityDisabled);
		}
		return new CardDetailPeripheral();
	}
	
	public CardDetailLicense getCardLicense() {

		List<QuantityForStatus> listQuantityStatus = dashboardRepository.getQuantityForStatusLicense();

		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			long quantityStandBy = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.STAND_BY)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityInUse = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.IN_USE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityExpired = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityTotal = quantityStandBy + quantityInUse + quantityExpired;

			return new CardDetailLicense(quantityTotal, quantityStandBy, quantityInUse, quantityExpired);
		}
		return new CardDetailLicense();
	}
	
	public CardDetailUser getCardUser() {
		
		List<QuantityForStatus> listQuantityStatus = dashboardRepository.getQuantityForStatusUser();

		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			long quantityActive = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusUserEnum.ACTIVE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityDisabled = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusUserEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityTotal = quantityActive + quantityDisabled;

			return new CardDetailUser(quantityTotal, quantityActive, quantityDisabled);
		}
		return new CardDetailUser();
	}
}
