package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.domain.dto.QuantityChangesForMonth;

public class ProjectRepository implements IRepository<Project>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public ProjectRepository() {
	}

	public ProjectRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Project> findAll() {
		return manager.createQuery("from Project", Project.class).getResultList();
	}
	
	public List<Project> findAllActive() {
		return manager.createQuery("SELECT p FROM Project p WHERE p.status = 'ACTIVE'", Project.class).getResultList();
	}

	@Override
	public List<Project> findAllByParams(Filter filter) {
		//TODO remover criteria
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Project> query = builder.createQuery(Project.class);
		Root<Project> root = query.from(Project.class);

		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(
				builder.or(
					builder.like(root.get("name"), filter.getParamSearch().toUpperCase() + "%")));

		query.where(predicates.toArray(new Predicate[0]));

		return manager.createQuery(query).getResultList();
	}

	@Override
	public Project findById(Integer id) {
		return manager.find(Project.class, id);
	}

	@Override
	public Project save(Project project) {
		return manager.merge(project);
	}

	public Long allComputers(Project project) {
		String jpql = "SELECT COUNT(*) from Computer where project_id = :project_id";

		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		query.setParameter("project_id", project.getId());

		return query.getSingleResult();
	}

	public Long allUsers(Project project) {
		String jpql = "SELECT COUNT(*) from User where project_id = :project_id";

		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		query.setParameter("project_id", project.getId());

		return query.getSingleResult();
	}
	
	public Long allMonitors(Project project) {
		String jpql = "SELECT COUNT(*) from Monitor where project_id = :project_id";

		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		query.setParameter("project_id", project.getId());

		return query.getSingleResult();
	}
	
	public List<String> findAllProjectString() {
		String jpql = "SELECT p.name FROM Project p";

		return manager.createQuery(jpql, String.class).getResultList();

	}
	
	public List<QuantityChangesForMonth> getListCostForYear(Integer project) {
		//TODO melhorar apos criar tarifa
		List<QuantityChangesForMonth> values = new ArrayList<>();
		values.add(new QuantityChangesForMonth(1, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(2, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(3, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(4, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(5, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(6, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(7, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(8, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(9, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(10, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(11, Math.round(Math.random() * 1000)));
		values.add(new QuantityChangesForMonth(12, Math.round(Math.random() * 1000)));
		
		return values;
	}
}
