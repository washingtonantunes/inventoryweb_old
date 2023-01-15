package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.Filter;
import br.com.wti.erp.domain.User;
import br.com.wti.erp.domain.vo.QuantityForStatus;

public class UserRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public UserRepository() {
	}

	public UserRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<User> findAllByParams(Filter filter) {
		try {
			String jpql = "SELECT u "
					+ "FROM User u " 
					+ "WHERE u.registration like :registration OR u.cpf like :cpf";

			TypedQuery<User> query = manager.createQuery(jpql, User.class);
			query.setParameter("registration", filter.getParamSearch().toUpperCase() + "%");
			query.setParameter("cpf", filter.getParamSearch().toUpperCase() + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<QuantityForStatus> getQuantityForStatusUser() {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.vo.QuantityForStatus(u.status, COUNT(*)) "
					+ "FROM User u " 
					+ "GROUP BY u.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Long getQuantityForProject(Integer project) {
		try {
			String jpql = "SELECT COUNT(u) "
					+ "FROM User u "
					+ "WHERE u.project.id = :project";

			TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
			query.setParameter("project", project);
			
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
