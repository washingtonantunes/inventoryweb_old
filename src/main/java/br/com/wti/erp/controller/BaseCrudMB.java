package br.com.wti.erp.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.service.IService;
import lombok.Getter;
import lombok.Setter;

public abstract class BaseCrudMB<Bean> extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Bean entity;

	@Getter
	private List<Bean> searchResult;

	@Inject
	@Getter
	@Setter
	private Filter filter;

	private List<String> componentesUpdateOnSave;

	private IService<Bean> service;
	
	public void setService(IService<?> service) {
		this.service = (IService<Bean>) service;
	}

	public void search() {
		searchResult = service.findAllByParam(filter);

		if (searchResult.isEmpty()) {
			messageInfo("Sua consulta não retornou registros.");
		}
	}

	public void newEntity(ActionEvent event) {

		preNew(event);

		// Cria o novo objeto de acordo com o tipo
		// "Bean" passado pelo Generics
		entity = getNewInstanceOfBean();

		/*
		 * Recebemos através de um <f:attribute> a lista de componentes que devem ser
		 * atualizados quando toda a operação terminar.
		 */
		componentesUpdateOnSave = (List<String>) event.getComponent().getAttributes().get("componentesParaAtualizar");

		posNew(event);
	}

	public void updateEntity(ActionEvent event) {

		preUpdate(event);

		componentesUpdateOnSave = (List<String>) event.getComponent().getAttributes().get("componentesParaAtualizar");

		posUpdate(event);
	}

	private Bean getNewInstanceOfBean() {
		try {
			ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
			Class<Bean> type = (Class<Bean>) superClass.getActualTypeArguments()[0];
			return type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveEntity(ActionEvent event) {
//		try {
//
//			preSave(event);
//			if (((AbstractBean) bean).getId() == null) {
//				bean = (Bean) getBoPadrao().save((AbstractBean) bean);
//				messageInfo("Registro salvo com sucesso");
//
//			} else {
//				getBoPadrao().update((AbstractBean) bean);
//				messageInfo("Registro atualizado com sucesso");
//			}
//
//			bean = null;
//
//			atualizarComponentes(componentesUpdateOnSave);
//
//			proSave(event);
//		} catch (BOException e) {
//			FacesContext.getCurrentInstance().validationFailed();
//			messageError(e.getMessage());
//		} catch (Exception e) {
//			FacesContext.getCurrentInstance().validationFailed();
//			messageError("Erro ao salvar. " + e.getMessage());
//		}
	}

	/*
	 * Método responsável por atualizar nossos componentes
	 */
	private void atualizarComponentes(List<String> componentes) {
		for (String compId : componentes) {
			PrimeFaces.current().ajax().update(compId);
		}
	}

	public abstract void preNew(ActionEvent event);

	public abstract void posNew(ActionEvent event);

	public abstract void preUpdate(ActionEvent event);

	public abstract void posUpdate(ActionEvent event);

	public abstract void preSave(ActionEvent event);

	public abstract void posSave(ActionEvent event);

	public abstract void init();
}
