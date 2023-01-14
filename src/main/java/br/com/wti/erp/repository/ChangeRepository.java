package br.com.wti.erp.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.dto.QuantityChangesForMonth;
import br.com.wti.erp.domain.enums.TypeChangeEnum;

public class ChangeRepository {

//	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public List<QuantityChangesForMonth> getListChangesForYearAndType(Integer year, TypeChangeEnum type) {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityChangesForMonth(MONTH(cc.date), COUNT(cc)) "
					+ "FROM ChangeComputer cc " 
					+ "WHERE type= :type AND year(date)= :year "
					+ "GROUP BY month(cc.date)";

			TypedQuery<QuantityChangesForMonth> query = manager.createQuery(jpql, QuantityChangesForMonth.class);
			query.setParameter("year", year);
			query.setParameter("type", type);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
