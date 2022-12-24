package br.com.wti.erp.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.wti.erp.domain.dashboard.Dashboard;
import br.com.wti.erp.domain.dashboard.DetailObject;
import lombok.Getter;

@Named
@ViewScoped
public class ManagerDashboardMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	private Dashboard dashboard = new Dashboard();

	@PostConstruct
	public void init() {
		DetailObject card1 = new DetailObject();

		card1.setColor("#228B22");

		card1.setTitle1("Computadores");
		card1.setValue1(500L);

		card1.setTitle2("Disponivel");
		card1.setValue2(300L);

		card1.setTitle3("Em Uso");
		card1.setValue3(200L);

		card1.setTitle4("Desativados");
		card1.setValue4(100L);

		dashboard.addDetailObject(card1);

		DetailObject card2 = new DetailObject();

		card2.setColor("#B22222");

		card2.setTitle1("Monitores");
		card2.setValue1(300L);

		card2.setTitle2("Disponivel");
		card2.setValue2(150L);

		card2.setTitle3("Em Uso");
		card2.setValue3(100L);

		card2.setTitle4("Desativados");
		card2.setValue4(50L);

		dashboard.addDetailObject(card2);

		DetailObject card3 = new DetailObject();

		card3.setColor("#FFA500");

		card3.setTitle1("Periféricos");
		card3.setValue1(200L);

		card3.setTitle2("Disponivel");
		card3.setValue2(150L);

		card3.setTitle3("Em Uso");
		card3.setValue3(30L);

		card3.setTitle4("Desativados");
		card3.setValue4(20L);

		dashboard.addDetailObject(card3);

		DetailObject card4 = new DetailObject();

		card4.setColor("#0000CD");

		card4.setTitle1("Licenças");
		card4.setValue1(50L);

		card4.setTitle2("Disponivel");
		card4.setValue2(30L);

		card4.setTitle3("Em Uso");
		card4.setValue3(20L);

		card4.setTitle4("Vencidas");
		card4.setValue4(0L);

		dashboard.addDetailObject(card4);

		DetailObject card5 = new DetailObject();

		card5.setColor("#808080");

		card5.setTitle1("Usuários");
		card5.setValue1(500L);

		card5.setTitle2("Ativos");
		card5.setValue2(450L);

		card5.setTitle3("Desativados");
		card5.setValue3(50L);

		dashboard.addDetailObject(card5);
	}

}
