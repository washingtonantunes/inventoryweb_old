package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.wti.erp.domain.User;

public class UserRepository implements IRepository<User>, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public UserRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<User> findAll() {
		return manager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public List<User> findAllByParams(Filter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);

		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(
				builder.or(
					builder.like(root.get("registration"), filter.getParamSearch().toUpperCase() + "%"),
					builder.like(root.get("cpf"), filter.getParamSearch().toUpperCase() + "%")));

		query.where(predicates.toArray(new Predicate[0]));

		return manager.createQuery(query).getResultList();
	}

	@Override
	public User findById(Integer id) {
		return manager.find(User.class, id);
	}

	@Override
	public User save(User user) {
		return manager.merge(user);
	}
}
