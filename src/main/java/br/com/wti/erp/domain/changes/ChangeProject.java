package br.com.wti.erp.domain.changes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wti.erp.domain.Project;

@Entity
@Table(name = "tb_changes_project")
public class ChangeProject extends Change {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@Override
	public String toString() {
		return "ChangeProject " + super.toString();
	}
}
