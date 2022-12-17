package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.UserService;
import br.com.wti.erp.util.FacesMessages;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ManagerUserMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesMessages messages = new FacesMessages();

	private UserService userService = new UserService();

	@Getter
	@Setter
	private User user;

	@Getter
	private List<User> listUsers;

	@Getter
	@Setter
	private Filter filter = new Filter();

	public void search() {
		listUsers = userService.findAllByParam(this.filter);

		if (listUsers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
}
