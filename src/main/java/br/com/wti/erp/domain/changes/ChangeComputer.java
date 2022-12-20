package br.com.wti.erp.domain.changes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wti.erp.domain.Computer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_changes_computer")
public class ChangeComputer extends Change {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "computer_id")
	private Computer computer;

	@Override
	public String toString() {
		return "ChangeComputer " + super.toString();
	}
}
