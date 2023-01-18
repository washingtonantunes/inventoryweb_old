package br.com.wti.erp.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.enums.TypeChangeEnum;
import br.com.wti.erp.domain.vo.QuantityForMonth;

public class ChangeRepository {

	@Inject
	private EntityManager manager;

	public List<QuantityForMonth> getListChangesForYearAndType(Integer year, TypeChangeEnum type) {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.vo.QuantityForMonth(MONTH(cc.date), COUNT(cc)) "
					+ "FROM Change cc " 
					+ "WHERE type= :type AND year(date)= :year "
					+ "GROUP BY month(cc.date)";

			TypedQuery<QuantityForMonth> query = manager.createQuery(jpql, QuantityForMonth.class);
			query.setParameter("year", year);
			query.setParameter("type", type);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
