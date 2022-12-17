package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.wti.erp.domain.Computer;

public class ComputerRepository implements IRepository<Computer>, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public ComputerRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Computer> findAll() {
		return manager.createQuery("from Computer", Computer.class).getResultList();
	}

	public List<Computer> findAllByParams(Filter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Computer> query = builder.createQuery(Computer.class);
		Root<Computer> root = query.from(Computer.class);

		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(
			builder.or(
				builder.like(root.get("serialNumber"), filter.getParamSearch().toUpperCase() + "%"),
				builder.like(root.get("patrimonyNumber"), filter.getParamSearch().toUpperCase() + "%")));

		query.where(predicates.toArray(new Predicate[0]));

		return manager.createQuery(query).getResultList();
	}

	@Override
	public Computer findById(Integer id) {
		return manager.find(Computer.class, id);
	}

	@Override
	public Computer save(Computer computer) {
		return manager.merge(computer);
	}
}
