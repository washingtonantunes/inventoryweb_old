package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.repository.UserRepository;

public class UserService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserRepository userRepository;

	public List<User> findAllByParam(Filter filter) {
		return userRepository.findAllByParams(filter);
	}
}
