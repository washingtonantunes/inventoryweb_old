package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.domain.Filter;
import br.com.wti.erp.repository.ComputerRepository;

public class ComputerService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ComputerRepository computerRepository;

	public List<Computer> findAllByParam(Filter filter) {
		return computerRepository.findAllByParams(filter);
	}
}
