package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.User;

public class UserRepository implements Repository<User>, Serializable {

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
	public List<User> findAllByParam(String paramSearch) {
		String jpql = "from User where registration like :paramSearch or cpf like :paramSearch";

		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("paramSearch", paramSearch.toUpperCase() + "%");

		return query.getResultList();
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
