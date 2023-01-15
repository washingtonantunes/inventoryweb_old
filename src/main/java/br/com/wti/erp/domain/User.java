package br.com.wti.erp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.wti.erp.domain.changes.ChangeUser;
import br.com.wti.erp.domain.enums.StatusUserEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class User extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true, nullable = false, length = 10)
	private String registration;

	@NotEmpty
	@Column(nullable = false, length = 100)
	private String name;

	@CPF
	@NotEmpty
	@Column(unique = true, nullable = false, length = 100)
	private String cpf;

	@Column(unique = true)
	private String phone;

	@Column(unique = true)
	private String email;

	private String department;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private StatusUserEnum status;

	@NotNull
	@Column(name = "date_entry", nullable = false)
	private LocalDate dateEntry;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Item> itens;

	@ManyToOne(optional = true)
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private List<ChangeUser> changes;

	public void addChange(ChangeUser change) {
		if (change != null) {
			this.changes.add(change);
		}
	}

	public void removeChange(ChangeUser change) {
		if (change != null) {
			this.changes.remove(change);
		}
	}

	@Override
	public String toString() {
		return "User " + super.toString();
	}
}