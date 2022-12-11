package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.service.UserService;
import br.com.wti.erp.util.FacesMessages;

@ManagedBean
@ViewScoped
public class ManagerUserMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private FacesMessages messages = new FacesMessages();

	private UserService userService = new UserService();

	private User user;

	private List<User> listUsers;

	private String paramSearch;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void search() {
		listUsers = userService.findAllByParam(this.paramSearch);

		if (listUsers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public String getParamSearch() {
		return paramSearch;
	}

	public void setParamSearch(String paramSearch) {
		this.paramSearch = paramSearch;
	}
}
