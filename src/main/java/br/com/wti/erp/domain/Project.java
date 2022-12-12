package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.wti.erp.domain.enums.StatusProjectEnum;
import br.com.wti.erp.service.ProjectService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_projects")
public class Project extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true, nullable = false)
	private String name;

	@NotEmpty
	@Column(nullable = false)
	private String city;

	@NotEmpty
	@Column(name = "cost_center", unique = true, nullable = false)
	private String costCenter;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private StatusProjectEnum status;

	@NotNull
	@Column(name = "date_entry", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateEntry;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "tb_changes_projects", 
			joinColumns = { @JoinColumn(name = "project_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "change_id") }
			)

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private List<Change> changes;

	public void addChange(Change change) {
		if (change != null) {
			this.changes.add(change);
		}
	}

	public void removeChange(Change change) {
		if (change != null) {
			this.changes.remove(change);
		}
	}
	
	public Long allComputers() {
		return ProjectService.allComputers(this);
	}
	
	public Long allUsers() {
		return ProjectService.allUsers(this);
	}
	
	public Integer allMonitors() {
		return 0;
	}

	public Project() {
	}

	@Override
	public String toString() {
		return "Project " + super.toString();
	}
}
