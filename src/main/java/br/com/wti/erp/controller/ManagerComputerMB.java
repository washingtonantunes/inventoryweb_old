package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.ComputerService;
import br.com.wti.erp.util.FacesMessages;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ManagerComputerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesMessages messages = new FacesMessages();

	private ComputerService computerService = new ComputerService();

	@Getter
	@Setter
	private Computer computer;

	@Getter
	private List<Computer> listComputers;

	@Getter
	@Setter
	private Filter filter = new Filter();

	public void search() {
		listComputers = computerService.findAllByParam(this.filter);

		if (listComputers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
}
