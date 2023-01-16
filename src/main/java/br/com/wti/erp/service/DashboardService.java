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
import br.com.wti.erp.domain.enums.StatusEquipmentEnum;
import br.com.wti.erp.domain.enums.StatusUserEnum;
import br.com.wti.erp.domain.enums.TypeChangeEnum;
import br.com.wti.erp.domain.vo.QuantityForMonth;
import br.com.wti.erp.domain.vo.QuantityForStatus;
import br.com.wti.erp.domain.vo.QuantityObjectForProject;
import br.com.wti.erp.repository.ChangeRepository;
import br.com.wti.erp.repository.ComputerRepository;
import br.com.wti.erp.repository.DashboardRepository;
import br.com.wti.erp.repository.MonitorRepository;
import br.com.wti.erp.repository.ProjectRepository;
import br.com.wti.erp.repository.UserRepository;

public class DashboardService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DashboardRepository dashboardRepository;
	
	@Inject
	private ChangeRepository changeRepository;
	
	@Inject
	private ComputerRepository computerRepository;
	
	@Inject
	private MonitorRepository monitorRepository;
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	private ProjectRepository projectRepository;

	public void setDataCardsGeneral(DashboardGeneral dashboard) {
		dashboard.setCardDetailComputer(getCardComputer());
		dashboard.setCardDetailMonitor(getCardMonitor());
		dashboard.setCardDetailPeripheral(getCardPeripheral());
		dashboard.setCardDetailLicense(getCardLicense());
		dashboard.setCardDetailUser(getCardUser());
	}

	public void setDataCardsForProject(DashboardForProject dashboard) {
		//TODO unificar buscar no banco
		
		Long id = dashboard.getProjectSelected().getId();
		
		final QuantityObjectForProject quantity = new QuantityObjectForProject();
		
		quantity.setComputers(computerRepository.getQuantityForProject(id));
		quantity.setMonitors(monitorRepository.getQuantityForProject(id));
//		quantity.setPeripherals(Math.round(Math.random() * 100));
//		quantity.setLicenses(Math.round(Math.random() * 100));
		quantity.setUsers(userRepository.getQuantityForProject(id));
		
		dashboard.setQuantityObject(quantity);
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

		LineChartDataSet dataSet = new LineChartDataSet();
		dataSet.setLabel(dashboard.getProjectSelected().getName());
		dataSet.setBackgroundColor("rgba(248, 11, 5, 0.7)");
		dataSet.setBorderColor("rgb(248, 11, 5)");
		dataSet.setTension(0.1);
		dataSet.setFill(false);
		
		List<QuantityForMonth> values = projectRepository.getListCostForYear(dashboard.getProjectSelected().getId());

		if (values != null && !values.isEmpty()) {
			dataSet.setData(converterListCost(values));
		}
		
		data.addChartDataSet(dataSet);

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
		dashboard.setPercentageComputersPieChartModel(getDataPercentageComputers());
		dashboard.setPercentageMonitorsPieChartModel(getDataPercentageMonitors());
		dashboard.setPercentagePeripheralsPieChartModel(obterDadosPercentagePeripherals());
		dashboard.setPercentageLicensesPieChartModel(obterDadosPercentageLicenses());
	}

	private BarChartDataSet getDataDeliveries(DashboardGeneral dashboard) {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Entregas");
		dataSet.setBackgroundColor("rgba(163, 157, 212, 0.7)");
		dataSet.setBorderColor("rgb(163, 157, 212)");
		dataSet.setBorderWidth(1);

		List<QuantityForMonth> values = changeRepository.getListChangesForYearAndType(dashboard.getYearSelected(), TypeChangeEnum.DELIVERY_TO_USER);

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

		List<QuantityForMonth> values = changeRepository.getListChangesForYearAndType(dashboard.getYearSelected(), TypeChangeEnum.EXCHANGE_TO_USER);

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

		List<QuantityForMonth> values = changeRepository.getListChangesForYearAndType(dashboard.getYearSelected(), TypeChangeEnum.DEVOLUTION_TO_USER);

		if (values != null && !values.isEmpty()) {
			dataSet.setData(converterList(values));
		}

		return dataSet;
	}

	private PieChartModel getDataPercentageComputers() {
		PieChartModel pieModel = new PieChartModel();

		ChartData data = new ChartData();
		
		List<QuantityForStatus> listQuantityStatus = computerRepository.getQuantityForStatusComputer();

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			values.add(listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.STAND_BY)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity());
			values.add(listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.IN_USE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity());
			values.add(listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity());
		}
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

	private PieChartModel getDataPercentageMonitors() {
		PieChartModel pieModel = new PieChartModel();

		ChartData data = new ChartData();
		//TODO melhora o grafico no caso de não ter valores
		List<QuantityForStatus> listQuantityStatus = monitorRepository.getQuantityForStatusMonitor();

		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		
		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			values.add(listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.STAND_BY)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity());
			values.add(listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.IN_USE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity());
			values.add(listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusEquipmentEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity());
		}
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
		//TODO alterar quando peripheral for mapeada
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
		//TODO alterar quando licenses for mapeada
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

	private List<Number> converterList(List<QuantityForMonth> values) {

		QuantityForMonth[] quantidades = new QuantityForMonth[12];

		for (QuantityForMonth value : values) {
			int id = value.getDate();
			quantidades[id - 1] = value;
		}

		List<Number> numbers = new ArrayList<>();

		for (QuantityForMonth quantity : quantidades) {
			if (quantity != null) {
				numbers.add(quantity.getQuantity());
			} else {
				numbers.add(0L);
			}
		}

		return numbers;
	}
	
	private List<Object> converterListCost(List<QuantityForMonth> values) {

		QuantityForMonth[] quantidades = new QuantityForMonth[12];

		for (QuantityForMonth value : values) {
			int id = value.getDate();
			quantidades[id - 1] = value;
		}

		List<Object> numbers = new ArrayList<>();

		for (QuantityForMonth quantity : quantidades) {
			if (quantity != null) {
				numbers.add(quantity.getQuantity());
			} else {
				numbers.add(0L);
			}
		}

		return numbers;
	}
	
	public CardDetailComputer getCardComputer() {
		
		List<QuantityForStatus> listQuantityStatus = computerRepository.getQuantityForStatusComputer();

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

		List<QuantityForStatus> listQuantityStatus = monitorRepository.getQuantityForStatusMonitor();
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
		
		List<QuantityForStatus> listQuantityStatus = userRepository.getQuantityForStatusUser();

		if(listQuantityStatus != null && !listQuantityStatus.isEmpty()) {
			long quantityActive = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusUserEnum.ACTIVE)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityDisabled = listQuantityStatus.stream().filter(value -> value.getStatus().equals(StatusUserEnum.DISABLED)).findFirst().orElse(new QuantityForStatus(StatusUserEnum.UNDEFINED, 0)).getQuantity();
			long quantityTotal = quantityActive + quantityDisabled;

			return new CardDetailUser(quantityTotal, quantityActive, quantityDisabled);
		}
		return new CardDetailUser();
	}
}
