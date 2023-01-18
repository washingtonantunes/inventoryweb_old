package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.entity.Filter;
import br.com.wti.erp.domain.entity.Project;
import br.com.wti.erp.domain.vo.QuantityForMonth;

public class ProjectRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public ProjectRepository() {
	}

	public ProjectRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Project> findAllActive() {
		return manager.createQuery("SELECT p FROM Project p WHERE p.status = 'ACTIVE'", Project.class).getResultList();
	}

	public List<Project> findAllByParams(Filter filter) {
		try {
			String jpql = "SELECT p "
					+ "FROM Project p " 
					+ "WHERE p.name like :name";

			TypedQuery<Project> query = manager.createQuery(jpql, Project.class);
			query.setParameter("name", filter.getParamSearch().toUpperCase() + "%");

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Project findById(Long id) {
		return manager.find(Project.class, id);
	}

	public List<QuantityForMonth> getListCostForYear(Long project) {
		//TODO melhorar apos criar tarifa
		List<QuantityForMonth> values = new ArrayList<>();
		values.add(new QuantityForMonth(1, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(2, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(3, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(4, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(5, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(6, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(7, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(8, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(9, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(10, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(11, Math.round(Math.random() * 1000)));
		values.add(new QuantityForMonth(12, Math.round(Math.random() * 1000)));
		
		return values;
	}
}
