package br.com.wti.erp.domain.changes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wti.erp.domain.User;

@Entity
@Table(name = "tb_changes_user")
public class ChangeUser extends Change {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString() {
		return "ChangeUser " + super.toString();
	}
}
