package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.domain.Filter;
import br.com.wti.erp.service.ComputerService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManagerComputerMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ComputerService computerService;
	
	@Getter
	@Setter
	private Computer entity;
	
	@Inject
	@Getter
	@Setter
	private Filter filter;

	@Getter
	private List<Computer> searchResult;
	
	@PostConstruct
	public void init() {
	}
	
	public void search() {
		searchResult = computerService.findAllByParam(filter);

		if (searchResult.isEmpty()) {
			messageInfo("Sua consulta não retornou registros.");
		}
	}
}
