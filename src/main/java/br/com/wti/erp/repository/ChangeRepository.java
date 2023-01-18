package br.com.wti.erp.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.vo.QuantityChangeForMonth;

public class ChangeRepository {

	@Inject
	private EntityManager manager;

	public List<QuantityChangeForMonth> getListChangesForYear(Integer year) {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.vo.QuantityChangeForMonth(cc.type, COUNT(cc), MONTH(cc.date)) "
					+ "FROM Change cc "
					+ "WHERE (cc.type = 'DELIVERY_TO_USER' OR cc.type = 'EXCHANGE_TO_USER' OR cc.type = 'DEVOLUTION_TO_USER') AND year(cc.date)= :year "
					+ "GROUP BY cc.type, MONTH(cc.date)";

			TypedQuery<QuantityChangeForMonth> query = manager.createQuery(jpql, QuantityChangeForMonth.class);
			query.setParameter("year", year);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
