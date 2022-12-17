package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.repository.ProjectRepository;
import br.com.wti.erp.util.EntityManagerProducer;

public class ProjectService implements IService<Project>, Serializable {

	private static final long serialVersionUID = 1L;

	private static final EntityManager manager = EntityManagerProducer.getEntityManager();

	private static final ProjectRepository projectRepository = new ProjectRepository(manager);

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	public List<Project> findAllByParam(Filter filter) {
		return projectRepository.findAllByParams(filter);
	}

	public Project findById(Integer id) {
		return projectRepository.findById(id);
	}

	@Transactional
	public void save(Project project) {
		projectRepository.save(project);
	}

	public static Long allComputers(Project project) {
		return projectRepository.allComputers(project);
	}

	public static Long allUsers(Project project) {
		return projectRepository.allUsers(project);
	}
}
