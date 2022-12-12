package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.service.ComputerService;
import br.com.wti.erp.util.FacesMessages;

@ManagedBean
@ViewScoped
public class ManagerComputerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesMessages messages = new FacesMessages();

	private ComputerService computerService = new ComputerService();

	private Computer computer;

	private List<Computer> listComputers;

	private String paramSearch;

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void search() {
		listComputers = computerService.findAllByParam(this.paramSearch);

		if (listComputers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	public List<Computer> getListComputers() {
		return listComputers;
	}

	public String getParamSearch() {
		return paramSearch;
	}

	public void setParamSearch(String paramSearch) {
		this.paramSearch = paramSearch;
	}
}
