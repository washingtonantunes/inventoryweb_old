package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.dto.QuantityForStatus;

public class DashboardRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<QuantityForStatus> getQuantityForStatusMonitor() {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityForStatus(m.status, COUNT(m)) "
					+ "FROM Monitor m " 
					+ "WHERE m.status != 'DISCARDED' " 
					+ "GROUP BY m.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<QuantityForStatus> getQuantityForStatusPeripheral() {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityForStatus(p.status, COUNT(p)) "
					+ "FROM Peripheral p " 
					+ "WHERE p.status != 'DISCARDED' " 
					+ "GROUP BY p.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<QuantityForStatus> getQuantityForStatusLicense() {
		try {
			String jpql = "SELECT new br.com.wti.erp.domain.dto.QuantityForStatus(l.status, COUNT(l)) "
					+ "FROM License l " 
					+ "WHERE c.status != 'DISCARDED' " 
					+ "GROUP BY l.status";

			TypedQuery<QuantityForStatus> query = manager.createQuery(jpql, QuantityForStatus.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
