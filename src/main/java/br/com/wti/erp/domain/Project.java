package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.wti.erp.domain.changes.ChangeProject;
import br.com.wti.erp.domain.enums.StatusProjectEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_projects")
public class Project extends AbstractEntity implements Serializable {

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

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private List<ChangeProject> changes;

	public void addChange(ChangeProject change) {
		if (change != null) {
			this.changes.add(change);
		}
	}

	public void removeChange(ChangeProject change) {
		if (change != null) {
			this.changes.remove(change);
		}
	}
	//TODO Alterar pelo metodo do grafico
	public Integer allMonitors() {
		return 0;
	}

	@Override
	public String toString() {
		return "Project " + super.toString();
	}
}
