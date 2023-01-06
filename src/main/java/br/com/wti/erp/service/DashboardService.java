package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.donut.DonutChartOptions;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

import br.com.wti.erp.domain.dashboard.Dashboard;
import br.com.wti.erp.domain.dashboard.DetailObjectCard;

public class DashboardService implements Serializable {

	private static final long serialVersionUID = 1L;

	public void setDataCards(Dashboard dashboard) {

		DetailObjectCard card1 = new DetailObjectCard();

		card1.setColor("#228B22");

		card1.setTitleMain("Computadores");
		card1.setValueMain(500L);

		card1.setTitleFirst("Disponivel");
		card1.setValueFirst(300L);

		card1.setTitleSecond("Em Uso");
		card1.setValueSecond(200L);

		card1.setTitleThird("Desativados");
		card1.setValueThird(100L);

		dashboard.setCardDetailComputers(card1);

		DetailObjectCard card2 = new DetailObjectCard();

		card2.setColor("#B22222");

		card2.setTitleMain("Monitores");
		card2.setValueMain(300L);

		card2.setTitleFirst("Disponivel");
		card2.setValueFirst(150L);

		card2.setTitleSecond("Em Uso");
		card2.setValueSecond(100L);

		card2.setTitleThird("Desativados");
		card2.setValueThird(50L);

		dashboard.setCardDetailMonitors(card2);

		DetailObjectCard card3 = new DetailObjectCard();

		card3.setColor("#FFA500");

		card3.setTitleMain("Periféricos");
		card3.setValueMain(200L);

		card3.setTitleFirst("Disponivel");
		card3.setValueFirst(150L);

		card3.setTitleSecond("Em Uso");
		card3.setValueSecond(30L);

		card3.setTitleThird("Desativados");
		card3.setValueThird(20L);

		dashboard.setCardDetailPeripherals(card3);

		DetailObjectCard card4 = new DetailObjectCard();

		card4.setColor("#0000CD");

		card4.setTitleMain("Licenças");
		card4.setValueMain(50L);

		card4.setTitleFirst("Disponivel");
		card4.setValueFirst(30L);

		card4.setTitleSecond("Em Uso");
		card4.setValueSecond(20L);

		card4.setTitleThird("Vencidas");
		card4.setValueThird(0L);

		dashboard.setCardDetailLicenses(card4);

		DetailObjectCard card5 = new DetailObjectCard();

		card5.setColor("#808080");

		card5.setTitleMain("Usuários");
		card5.setValueMain(500L);

		card5.setTitleFirst("Ativos");
		card5.setValueFirst(450L);

		card5.setTitleSecond("Desativados");
		card5.setValueSecond(50L);

		dashboard.setCardDetailUsers(card5);
	}

	public void setConsumptionDonutChartModel(Dashboard dashboard) {
		DonutChartModel donutModel = new DonutChartModel();

		ChartData data = new ChartData();

		data.addChartDataSet(obterDadosConsumo());

		List<String> labels = new ArrayList<>();
		labels.add("Ifood");
		labels.add("Sinqia");
		labels.add("Nubank");
		data.setLabels(labels);

		donutModel.setData(data);

		DonutChartOptions options = new DonutChartOptions();

		Title title = new Title();
		title.setDisplay(true);
		title.setText("Consumo");
		title.setFontSize(20);
		options.setTitle(title);

		Legend legend = new Legend();
		legend.setDisplay(true);
		legend.setPosition("left");
		LegendLabel legendLabels = new LegendLabel();
		legendLabels.setBoxWidth(20);
		legend.setLabels(legendLabels);
		options.setLegend(legend);

		donutModel.setOptions(options);

		dashboard.setConsumptionDonutChartModel(donutModel);
	}

	public void setLogisticsBarChartModel(Dashboard dashboard) {
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

	public void setCostLineChartModel(Dashboard dashboard) {
		LineChartModel lineModel = new LineChartModel();

		ChartData data = new ChartData();

		data.addChartDataSet(obterDadosCusto1());
		data.addChartDataSet(obterDadosCusto2());

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

	private DonutChartDataSet obterDadosConsumo() {
		DonutChartDataSet dataSet = new DonutChartDataSet();
		List<Number> values = new ArrayList<>();
		values.add(100);
		values.add(200);
		values.add(50);
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		bgColors.add("rgb(255, 99, 132)");
		bgColors.add("rgb(54, 162, 235)");
		bgColors.add("rgb(255, 205, 86)");
		dataSet.setBackgroundColor(bgColors);

		return dataSet;
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

	private LineChartDataSet obterDadosCusto1() {
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

	private LineChartDataSet obterDadosCusto2() {
		LineChartDataSet dataSet = new LineChartDataSet();
		dataSet.setLabel("IFOOD");
		dataSet.setBackgroundColor("rgba(217, 4, 93, 0.7)");
		dataSet.setBorderColor("rgb(217, 4, 93)");
		dataSet.setTension(0.1);
		dataSet.setFill(false);

		List<Object> values = new ArrayList<>();
		values.add(4500);
		values.add(1900);
		values.add(8005);
		values.add(1000);
		values.add(15600);
		values.add(4500);
		values.add(1000);
		values.add(2000);
		values.add(6000);
		values.add(8000);
		values.add(3000);
		values.add(7000);
		dataSet.setData(values);

		return dataSet;
	}

}
