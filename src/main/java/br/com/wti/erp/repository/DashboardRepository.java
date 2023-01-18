package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.wti.erp.domain.vo.QuantityForStatus;

public class DashboardRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<QuantityForStatus> getQuantityForStatus(Class<?> entity) {
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<QuantityForStatus> query = builder.createQuery(QuantityForStatus.class);
			Root<?> from = query.from(entity);

			query.multiselect(from.get("status"), builder.count(from.get("status"))).groupBy(from.get("status"));

			return manager.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
