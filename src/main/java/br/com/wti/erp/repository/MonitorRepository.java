package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.wti.erp.domain.Monitor;
import br.com.wti.erp.domain.dto.QuantityForStatus;

public class MonitorRepository implements IRepository<Monitor>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public MonitorRepository() {
	}

	public MonitorRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Monitor> findAll() {
		return manager.createQuery("from Monitor", Monitor.class).getResultList();
	}

	@Override
	public List<Monitor> findAllByParams(Filter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Monitor> query = builder.createQuery(Monitor.class);
		Root<Monitor> root = query.from(Monitor.class);

		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(
			builder.or(
				builder.like(root.get("serialNumber"), filter.getParamSearch().toUpperCase() + "%"),
				builder.like(root.get("patrimonyNumber"), filter.getParamSearch().toUpperCase() + "%")));

		query.where(predicates.toArray(new Predicate[0]));

		return manager.createQuery(query).getResultList();
	}

	@Override
	public Monitor findById(Integer id) {
		return manager.find(Monitor.class, id);
	}

	@Override
	public Monitor save(Monitor monitor) {
		return manager.merge(monitor);
	}
	
	public List<QuantityForStatus> getQuantityForStatusMonitor() {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityForStatus(m.status, COUNT(*)) "
					+ "FROM Monitor m " 
					+ "WHERE m.status != 'DISCARDED' " 
					+ "GROUP BY m.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Long getQuantityForProject(Integer project) {
		try {
			String jpql = "SELECT COUNT(m) "
					+ "FROM Monitor m "
					+ "WHERE m.project.id = :project";

			TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
			query.setParameter("project", project);
			
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
