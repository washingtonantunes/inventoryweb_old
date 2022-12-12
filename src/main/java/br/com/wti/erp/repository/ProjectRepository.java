package br.com.wti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wti.erp.domain.Project;

public class ProjectRepository implements Repository<Project>, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public ProjectRepository(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Project> findAll() {
		return manager.createQuery("from Project", Project.class).getResultList();
	}

	@Override
	public List<Project> findAllByParam(String paramSearch) {
		String jpql = "from Project where name like :paramSearch";

		TypedQuery<Project> query = manager.createQuery(jpql, Project.class);
		query.setParameter("paramSearch", paramSearch.toUpperCase() + "%");

		return query.getResultList();
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
		String jpql = "select count(*) from Computer where project_id = :project_id";
		
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		query.setParameter("project_id", project.getId());
		
		return query.getSingleResult();
	}
	
	public Long allUsers(Project project) {
		String jpql = "select count(*) from User where project_id = :project_id";
		
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		query.setParameter("project_id", project.getId());
		
		return query.getSingleResult();
	}
}
