package br.com.wti.erp.domain.changes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wti.erp.domain.Monitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_changes_monitor")
public class ChangeMonitor extends Change {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "monitor_id")
	private Monitor monitor;

	@Override
	public String toString() {
		return "ChangeMonitor " + super.toString();
	}
}
