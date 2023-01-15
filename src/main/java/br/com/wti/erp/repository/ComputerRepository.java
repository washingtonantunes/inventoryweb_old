package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.Computer;
import br.com.wti.erp.domain.vo.QuantityForStatus;

public class ComputerRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public ComputerRepository() {
	}

	public List<Computer> findAllByParams(Filter filter) {
		try {
			String jpql = "SELECT c "
					+ "FROM Computer c " 
					+ "WHERE c.serialNumber like :serialNumber OR c.patrimonyNumber like :patrimonyNumber";

			TypedQuery<Computer> query = manager.createQuery(jpql, Computer.class);
			query.setParameter("serialNumber", filter.getParamSearch().toUpperCase() + "%");
			query.setParameter("patrimonyNumber", filter.getParamSearch().toUpperCase() + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<QuantityForStatus> getQuantityForStatusComputer() {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityForStatus(c.status, COUNT(c)) "
					+ "FROM Computer c " 
					+ "WHERE c.status != 'DISCARDED' " 
					+ "GROUP BY c.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Long getQuantityForProject(Integer project) {
		try {
			String jpql = "SELECT COUNT(c) "
					+ "FROM Computer c "
					+ "WHERE c.project.id = :project";

			TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
			query.setParameter("project", project);
			
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
