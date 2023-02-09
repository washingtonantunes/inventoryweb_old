package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.entity.ComboBoxOption;
import br.com.wti.erp.domain.enums.TypeComboBoxEnum;

public class OptionRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<ComboBoxOption> findOptionForType(TypeComboBoxEnum typeSelected) {
		try {
			String jpql = "SELECT cb "
					+ "FROM ComboBoxOption cb " 
					+ "WHERE cb.type = :type "
					+ "ORDER BY cb.description";

			TypedQuery<ComboBoxOption> query = manager.createQuery(jpql, ComboBoxOption.class);
			query.setParameter("type", typeSelected);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void save(ComboBoxOption combo) {
			manager.persist(combo);
	}

}
