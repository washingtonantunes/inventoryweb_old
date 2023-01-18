package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.entity.Filter;
import br.com.wti.erp.domain.entity.User;
import br.com.wti.erp.service.UserService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManagerUserMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;
	
	@Getter
	@Setter
	private User entity;
	
	@Inject
	@Getter
	@Setter
	private Filter filter;

	@Getter
	private List<User> searchResult;
	
	@PostConstruct
	public void init() {
	}
	
	public void search() {
		searchResult = userService.findAllByParam(filter);

		if (searchResult.isEmpty()) {
			messageInfo("Sua consulta não retornou registros.");
		}
	}
}
