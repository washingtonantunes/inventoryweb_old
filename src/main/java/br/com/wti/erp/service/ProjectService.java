package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.wti.erp.domain.Project;
import br.com.wti.erp.repository.Filter;
import br.com.wti.erp.repository.ProjectRepository;
import br.com.wti.erp.util.annotations.Transactional;

public class ProjectService implements IService<Project>, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProjectRepository projectRepository;

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public List<Project> findAllByParam(Filter filter) {
		return projectRepository.findAllByParams(filter);
	}

	@Override
	public Project findById(Integer id) {
		return projectRepository.findById(id);
	}

	@Override
	@Transactional
	public void save(Project project) {
		projectRepository.save(project);
	}

	public Long allComputers(Project project) {
		return projectRepository.allComputers(project);
	}

	public Long allUsers(Project project) {
		return projectRepository.allUsers(project);
	}
	
	public Long allMonitors(Project project) {
		return projectRepository.allMonitors(project);
	}
}
