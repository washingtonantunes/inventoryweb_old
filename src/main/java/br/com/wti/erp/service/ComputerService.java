package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.repository.ComputerRepository;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.util.EntityManagerProducer;

public class ComputerService implements IService<Computer>, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager = EntityManagerProducer.getEntityManager();

	private ComputerRepository computerRepository = new ComputerRepository(manager);

	public List<Computer> findAll() {
		return computerRepository.findAll();
	}

	public List<Computer> findAllByParam(Filter filter) {
		return computerRepository.findAllByParams(filter);
	}

	public Computer findById(Integer id) {
		return computerRepository.findById(id);
	}

	@Transactional
	public void save(Computer computer) {
		computerRepository.save(computer);
	}
}
