package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.service.UserService;

@ManagedBean
@ViewScoped
public class ManagerUserMB implements Serializable {

	private static final long serialVersionUID = 1L;

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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sua consulta não retornou registros.", null));
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
