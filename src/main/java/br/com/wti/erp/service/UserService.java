package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.repository.UserRepository;
import br.com.wti.erp.util.EntityManagerProducer;

public class UserService implements IService<User>, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager = EntityManagerProducer.getEntityManager();

	private UserRepository userRepository = new UserRepository(manager);

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findAllByParam(Filter filter) {
		return userRepository.findAllByParams(filter);
	}

	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
}
