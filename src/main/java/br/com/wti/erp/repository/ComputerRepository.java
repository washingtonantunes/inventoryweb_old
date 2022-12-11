package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.Computer;

public class ComputerRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public ComputerRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Computer> findAll() {
		return manager.createQuery("from Computer", Computer.class).getResultList();
	}

	public List<Computer> findAllByParam(String paramSearch) {
		String jpql = "from Computer where serial_number like :paramSearch or patrimony_number like :paramSearch";

		TypedQuery<Computer> query = manager.createQuery(jpql, Computer.class);
		query.setParameter("paramSearch", paramSearch.toUpperCase() + "%");

		return query.getResultList();
	}

	public Computer findById(Integer id) {
		return manager.find(Computer.class, id);
	}

	public Computer save(Computer computer) {
		return manager.merge(computer);
	}
}
