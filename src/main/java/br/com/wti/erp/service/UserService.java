package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.repository.UserRepository;
import br.com.wti.erp.util.annotations.Transactional;

public class UserService implements IService<User>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findAllByParam(Filter filter) {
		return userRepository.findAllByParams(filter);
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
}
