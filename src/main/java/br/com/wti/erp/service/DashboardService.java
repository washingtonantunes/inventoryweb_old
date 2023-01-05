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
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.title.Title;

import br.com.wti.erp.domain.dashboard.Dashboard;
import br.com.wti.erp.domain.dashboard.DetailObjectCard;
import br.com.wti.erp.domain.enums.TypeConsumptionEnum;

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

		donutModel.setData(escolherDadosDonutChartModel(dashboard.getTypeConsumptionSelected()));

		donutModel.setOptions(configuraOptions());

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

	private DonutChartOptions configuraOptions() {
		DonutChartOptions options = new DonutChartOptions();

		Legend legend = new Legend();
		legend.setPosition("left");
		legend.setFullWidth(true);

		options.setLegend(legend);

		return options;
	}

	private ChartData escolherDadosDonutChartModel(TypeConsumptionEnum type) {
		ChartData data = new ChartData();

		if (type == TypeConsumptionEnum.COMPUTERS) {
			DonutChartDataSet dataSet = new DonutChartDataSet();
			List<Number> values = new ArrayList<>();
			values.add(100);
			values.add(100);
			values.add(100);
			dataSet.setData(values);

			List<String> bgColors = new ArrayList<>();
			bgColors.add("rgb(255, 99, 132)");
			bgColors.add("rgb(54, 162, 235)");
			bgColors.add("rgb(255, 205, 86)");
			dataSet.setBackgroundColor(bgColors);

			data.addChartDataSet(dataSet);
			List<String> labels = new ArrayList<>();
			labels.add("Ifood Computer");
			labels.add("Sinqia Computer");
			labels.add("Nubank Computer");
			data.setLabels(labels);
		} else if (type == TypeConsumptionEnum.MONITORS) {
			DonutChartDataSet dataSet = new DonutChartDataSet();
			List<Number> values = new ArrayList<>();
			values.add(100);
			values.add(100);
			values.add(500);
			dataSet.setData(values);

			List<String> bgColors = new ArrayList<>();
			bgColors.add("rgb(255, 99, 132)");
			bgColors.add("rgb(54, 162, 235)");
			bgColors.add("rgb(255, 205, 86)");
			dataSet.setBackgroundColor(bgColors);

			data.addChartDataSet(dataSet);
			List<String> labels = new ArrayList<>();
			labels.add("Ifood Monitor");
			labels.add("Sinqia Monitor");
			labels.add("Nubank Monitor");
			data.setLabels(labels);
		} else if (type == TypeConsumptionEnum.PERIPHERALS) {
			DonutChartDataSet dataSet = new DonutChartDataSet();
			List<Number> values = new ArrayList<>();
			values.add(300);
			values.add(700);
			values.add(800);
			dataSet.setData(values);

			List<String> bgColors = new ArrayList<>();
			bgColors.add("rgb(255, 99, 132)");
			bgColors.add("rgb(54, 162, 235)");
			bgColors.add("rgb(255, 205, 86)");
			dataSet.setBackgroundColor(bgColors);

			data.addChartDataSet(dataSet);
			List<String> labels = new ArrayList<>();
			labels.add("Ifood Periféricos");
			labels.add("Sinqia Periféricos");
			labels.add("Nubank Periféricos");
			data.setLabels(labels);
		} else {
			DonutChartDataSet dataSet = new DonutChartDataSet();
			List<Number> values = new ArrayList<>();
			values.add(100);
			values.add(200);
			values.add(300);
			dataSet.setData(values);

			List<String> bgColors = new ArrayList<>();
			bgColors.add("rgb(255, 99, 132)");
			bgColors.add("rgb(54, 162, 235)");
			bgColors.add("rgb(255, 205, 86)");
			dataSet.setBackgroundColor(bgColors);

			data.addChartDataSet(dataSet);
			List<String> labels = new ArrayList<>();
			labels.add("Ifood");
			labels.add("Sinqia");
			labels.add("Nubank");
			data.setLabels(labels);
		}

		return data;
	}

	private BarChartDataSet obterDadosEntregas() {
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Entregas");
		barDataSet.setBackgroundColor("rgba(163, 157, 212, 0.7)");
		barDataSet.setBorderColor("rgb(163, 157, 212)");
		barDataSet.setBorderWidth(1);

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
		barDataSet.setData(values);

		return barDataSet;
	}

	private BarChartDataSet obterDadosTrocas() {
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Trocas");
		barDataSet.setBackgroundColor("rgba(236, 47, 111, 0.7)");
		barDataSet.setBorderColor("rgb(236, 47, 111)");
		barDataSet.setBorderWidth(1);

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
		barDataSet.setData(values);

		return barDataSet;
	}

	private BarChartDataSet obterDadosDevolucoes() {
		BarChartDataSet barDataSet = new BarChartDataSet();
		barDataSet.setLabel("Devoluções");
		barDataSet.setBackgroundColor("rgba(161, 171, 122, 0.7)");
		barDataSet.setBorderColor("rgb(161, 171, 122)");
		barDataSet.setBorderWidth(1);

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
		barDataSet.setData(values);

		return barDataSet;
	}
}
