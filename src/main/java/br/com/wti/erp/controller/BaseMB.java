package br.com.wti.erp.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private void add(String msg, FacesMessage.Severity severity) {
		FacesMessage facesMessage = new FacesMessage(msg);
		facesMessage.setSeverity(severity);

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public void messageInfo(String msg) {
		add(msg, FacesMessage.SEVERITY_INFO);
	}

	public void messageWarn(String msg) {
		add(msg, FacesMessage.SEVERITY_WARN);
	}

	public void messageError(String msg) {
		add(msg, FacesMessage.SEVERITY_ERROR);
	}
}
