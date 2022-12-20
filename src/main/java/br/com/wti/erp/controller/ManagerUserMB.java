package br.com.wti.erp.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wti.erp.domain.User;
import br.com.wti.erp.service.UserService;

@Named
@ViewScoped
public class ManagerUserMB extends BaseCrudMB<User> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService userService;
	
	@PostConstruct
	@Override
	public void init() {
		setService(userService);
	}

	@Override
	public void preNew(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posNew(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preUpdate(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posUpdate(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSave(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void posSave(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
