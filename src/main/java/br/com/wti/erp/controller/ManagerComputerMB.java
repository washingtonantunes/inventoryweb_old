package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.ComputerService;
import br.com.wti.erp.util.FacesMessages;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManagerComputerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages messages;

	@Inject
	private ComputerService computerService;

	@Getter
	@Setter
	private Computer computer;

	@Getter
	private List<Computer> listComputers;

	@Inject
	@Getter
	@Setter
	private Filter filter;

	public void search() {
		listComputers = computerService.findAllByParam(this.filter);

		if (listComputers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
}
