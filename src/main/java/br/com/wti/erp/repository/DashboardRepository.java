package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.dto.QuantityChangesForMonth;
import br.com.wti.erp.domain.dto.QuantityForStatus;
import br.com.wti.erp.domain.enums.TypeChangeEnum;

public class DashboardRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<QuantityForStatus> getQuantityForStatus(){
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityForStatus(c.status, COUNT(c)) "
					+ "FROM Computer c " 
					+ "WHERE c.status != 'DISCARDED' "
					+ "GROUP BY c.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public List<QuantityChangesForMonth> getListChangesForYearAndType(Integer year, TypeChangeEnum type) {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityChangesForMonth(MONTH(cc.dateChange), COUNT(cc)) "
					+ "FROM ChangeComputer cc " 
					+ "WHERE type= :type AND year(dateChange)= :year "
					+ "GROUP BY month(cc.dateChange)";

			TypedQuery<QuantityChangesForMonth> query = manager.createQuery(jpql, QuantityChangesForMonth.class);
			query.setParameter("year", year);
			query.setParameter("type", type);

			return query.getResultList();
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
}
