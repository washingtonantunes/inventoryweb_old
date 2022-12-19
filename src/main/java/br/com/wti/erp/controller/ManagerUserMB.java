package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.UserService;
import br.com.wti.erp.util.FacesMessages;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManagerUserMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesMessages messages;

	@Inject
	private UserService userService;

	@Getter
	@Setter
	private User user;

	@Getter
	private List<User> listUsers;

	@Inject
	@Getter
	@Setter
	private Filter filter;

	public void search() {
		listUsers = userService.findAllByParam(this.filter);

		if (listUsers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
}
