package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.repository.ComputerRepository;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.util.annotations.Transactional;

public class ComputerService implements IService<Computer>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ComputerRepository computerRepository;

	@Override
	public List<Computer> findAll() {
		return computerRepository.findAll();
	}

	@Override
	public List<Computer> findAllByParam(Filter filter) {
		return computerRepository.findAllByParams(filter);
	}

	@Override
	public Computer findById(Integer id) {
		return computerRepository.findById(id);
	}

	@Override
	@Transactional
	public void save(Computer computer) {
		computerRepository.save(computer);
	}
}
