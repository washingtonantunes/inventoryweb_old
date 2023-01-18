package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.entity.Filter;
import br.com.wti.erp.domain.entity.Monitor;

public class MonitorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public MonitorRepository() {
	}

	public List<Monitor> findAllByParams(Filter filter) {
		try {
			String jpql = "SELECT m "
					+ "FROM Monitor m " 
					+ "WHERE m.serialNumber like :serialNumber OR m.patrimonyNumber like :patrimonyNumber";

			TypedQuery<Monitor> query = manager.createQuery(jpql, Monitor.class);
			query.setParameter("serialNumber", filter.getParamSearch().toUpperCase() + "%");
			query.setParameter("patrimonyNumber", filter.getParamSearch().toUpperCase() + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Long getQuantityForProject(Long project) {
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
