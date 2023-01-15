package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.wti.erp.domain.Filter;
import br.com.wti.erp.domain.Project;
import br.com.wti.erp.domain.vo.QuantityObjectForProject;
import br.com.wti.erp.repository.ComputerRepository;
import br.com.wti.erp.repository.MonitorRepository;
import br.com.wti.erp.repository.ProjectRepository;
import br.com.wti.erp.repository.UserRepository;

public class ProjectService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjectRepository projectRepository;
	
	@Inject
	private ComputerRepository computerRepository;
	
	@Inject
	private MonitorRepository monitorRepository;
	
	@Inject
	private UserRepository userRepository;

	public List<Project> findAllActive() {
		return projectRepository.findAllActive();
	}

	public List<Project> findAllByParam(Filter filter) {
		return projectRepository.findAllByParams(filter);
	}

	public Project findById(Integer id) {
		return projectRepository.findById(id);
	}
	
	public QuantityObjectForProject getQuantityObjectForProject(Integer project) {
		//TODO melhorar
		final QuantityObjectForProject quantity = new QuantityObjectForProject();
		
		quantity.setComputers(computerRepository.getQuantityForProject(project));
		quantity.setMonitors(monitorRepository.getQuantityForProject(project));
		quantity.setUsers(userRepository.getQuantityForProject(project));
		
		return quantity;
	}
}
