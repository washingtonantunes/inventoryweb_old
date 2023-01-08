package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

import br.com.wti.erp.domain.dashboard.DashboardGeneral;
import br.com.wti.erp.domain.dashboard.DashboardForProject;
import br.com.wti.erp.domain.dashboard.DetailObjectCard;

public class DashboardService implements Serializable {

	private static final long serialVersionUID = 1L;

	public void setDataCardsGeneral(DashboardGeneral dashboard) {

		DetailObjectCard computers = new DetailObjectCard();

		computers.setColor("#228B22");

		computers.setTitleMain("Computadores");
		computers.setValueMain(500L);

		computers.setTitleFirst("Disponivel");
		computers.setValueFirst(300L);

		computers.setTitleSecond("Em Uso");
		computers.setValueSecond(200L);

		computers.setTitleThird("Desativados");
		computers.setValueThird(100L);

		dashboard.setCardDetailComputers(computers);

		DetailObjectCard monitors = new DetailObjectCard();

		monitors.setColor("#B22222");

		monitors.setTitleMain("Monitores");
		monitors.setValueMain(300L);

		monitors.setTitleFirst("Disponivel");
		monitors.setValueFirst(150L);

		monitors.setTitleSecond("Em Uso");
		monitors.setValueSecond(100L);

		monitors.setTitleThird("Desativados");
		monitors.setValueThird(50L);

		dashboard.setCardDetailMonitors(monitors);

		DetailObjectCard peripherals = new DetailObjectCard();

		peripherals.setColor("#FFA500");

		peripherals.setTitleMain("Periféricos");
		peripherals.setValueMain(200L);

		peripherals.setTitleFirst("Disponivel");
		peripherals.setValueFirst(150L);

		peripherals.setTitleSecond("Em Uso");
		peripherals.setValueSecond(30L);

		peripherals.setTitleThird("Desativados");
		peripherals.setValueThird(20L);

		dashboard.setCardDetailPeripherals(peripherals);

		DetailObjectCard licenses = new DetailObjectCard();

		licenses.setColor("#0000CD");

		licenses.setTitleMain("Licenças");
		licenses.setValueMain(50L);

		licenses.setTitleFirst("Disponivel");
		licenses.setValueFirst(30L);

		licenses.setTitleSecond("Em Uso");
		licenses.setValueSecond(20L);

		licenses.setTitleThird("Vencidas");
		licenses.setValueThird(0L);

		dashboard.setCardDetailLicenses(licenses);

		DetailObjectCard users = new DetailObjectCard();

		users.setColor("#808080");

		users.setTitleMain("Usuários");
		users.setValueMain(500L);

		users.setTitleFirst("Ativos");
		users.setValueFirst(450L);

		users.setTitleSecond("Desativados");
		users.setValueSecond(50L);

		dashboard.setCardDetailUsers(users);
	}
	
	public void setDataCardsForProject(DashboardForProject dashboard) {
		DetailObjectCard computers = new DetailObjectCard();

		computers.setColor("#228B22");

		computers.setTitleMain("Computadores");
		computers.setValueMain(500L);

		dashboard.setCardDetailComputers(computers);

		DetailObjectCard monitors = new DetailObjectCard();

		monitors.setColor("#B22222");

		monitors.setTitleMain("Monitores");
		monitors.setValueMain(300L);

		dashboard.setCardDetailMonitors(monitors);

		DetailObjectCard peripherals = new DetailObjectCard();

		peripherals.setColor("#FFA500");

		peripherals.setTitleMain("Periféricos");
		peripherals.setValueMain(200L);

		dashboard.setCardDetailPeripherals(peripherals);

		DetailObjectCard licenses = new DetailObjectCard();

		licenses.setColor("#0000CD");

		licenses.setTitleMain("Licenças");
		licenses.setValueMain(50L);

		dashboard.setCardDetailLicenses(licenses);

		DetailObjectCard users = new DetailObjectCard();

		users.setColor("#808080");

		users.setTitleMain("Usuários");
		users.setValueMain(500L);

		dashboard.setCardDetailUsers(users);
	}

	public void setLogisticsBarChartModel(DashboardGeneral dashboard) {
		BarChartModel barModel = new BarChartModel();

		ChartData data = new ChartData();

		data.addChartDataSet(obterDadosEntregas());
		data.addChartDataSet(obterDadosTrocas());
		data.addChartDataSet(obterDadosDevolucoes());

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

	private BarChartDataSet obterDadosEntregas() {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Entregas");
		dataSet.setBackgroundColor("rgba(163, 157, 212, 0.7)");
		dataSet.setBorderColor("rgb(163, 157, 212)");
		dataSet.setBorderWidth(1);

		List<Number> values = new ArrayList<>();
		values.add(65);
		values.add(59);
		values.add(80);
		values.add(81);
		values.add(56);
		values.add(55);
		values.add(40);
		values.add(40);
		values.add(30);
		values.add(30);
		values.add(40);
		values.add(10);
		dataSet.setData(values);

		return dataSet;
	}

	private BarChartDataSet obterDadosTrocas() {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Trocas");
		dataSet.setBackgroundColor("rgba(236, 47, 111, 0.7)");
		dataSet.setBorderColor("rgb(236, 47, 111)");
		dataSet.setBorderWidth(1);

		List<Number> values = new ArrayList<>();
		values.add(15);
		values.add(20);
		values.add(10);
		values.add(5);
		values.add(5);
		values.add(10);
		values.add(5);
		values.add(20);
		values.add(10);
		values.add(80);
		values.add(60);
		values.add(5);
		dataSet.setData(values);

		return dataSet;
	}

	private BarChartDataSet obterDadosDevolucoes() {
		BarChartDataSet dataSet = new BarChartDataSet();
		dataSet.setLabel("Devoluções");
		dataSet.setBackgroundColor("rgba(161, 171, 122, 0.7)");
		dataSet.setBorderColor("rgb(161, 171, 122)");
		dataSet.setBorderWidth(1);

		List<Number> values = new ArrayList<>();
		values.add(15);
		values.add(19);
		values.add(20);
		values.add(1);
		values.add(56);
		values.add(45);
		values.add(10);
		values.add(20);
		values.add(7);
		values.add(80);
		values.add(30);
		values.add(4);
		dataSet.setData(values);

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
	
//	public PieChartModel obterDadosPercentageComputers() {
//		PieChartModel pieModel = new PieChartModel();
//
//        pieModel.set("Disponivel", 200);
//        pieModel.set("Em Uso", 80);
//        pieModel.set("Desativados", 10);
//
//        pieModel.setTitle("Computadores");
//        pieModel.setLegendPosition(null);
//        pieModel.setFill(false);
//        pieModel.setShowDataLabels(true);
//        pieModel.setDiameter(100);
//        
//        return pieModel;
//	}
//	
//	public PieChartModel obterDadosPercentageMonitors() {
//		PieChartModel pieModel = new PieChartModel();
//
//        pieModel.set("Disponivel", 500);
//        pieModel.set("Em Uso", 150);
//        pieModel.set("Desativados", 30);
//        pieModel.setSeriesColors(null);
//
//        pieModel.setTitle("Monitores");
//        pieModel.setLegendPosition(null);
//        pieModel.setFill(false);
//        pieModel.setShowDataLabels(true);
//        pieModel.setDiameter(100);
//        
//        return pieModel;
//	}
//	
//	public PieChartModel obterDadosPercentagePeripherals() {
//		PieChartModel pieModel = new PieChartModel();
//
//        pieModel.set("Disponivel", 400);
//        pieModel.set("Em Uso", 50);
//        pieModel.set("Desativados", 5);
//        pieModel.setSeriesColors(null);
//
//        pieModel.setTitle("Periféricos");
//        pieModel.setLegendPosition(null);
//        pieModel.setFill(false);
//        pieModel.setShowDataLabels(true);
//        pieModel.setDiameter(100);
//        
//        return pieModel;
//	}
//	
//	public PieChartModel obterDadosPercentageLicenses() {
//		PieChartModel pieModel = new PieChartModel();
//
//        pieModel.set("Disponivel", 400);
//        pieModel.set("Em Uso", 50);
//        pieModel.set("Desativados", 5);
//        pieModel.setSeriesColors(null);
//
//        pieModel.setTitle("Licenças");
//        pieModel.setLegendPosition(null);
//        pieModel.setFill(false);
//        pieModel.setShowDataLabels(true);
//        pieModel.setDiameter(100);
//        
//        return pieModel;
//	}
}
