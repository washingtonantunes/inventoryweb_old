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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.wti.erp.domain.enums.StatusUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class User extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true, nullable = false, length = 10)
	private String registration;

	@NotEmpty
	@Column(nullable = false, length = 100)
	private String name;

	@CPF
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
	private StatusUser status;

	@NotNull
	@Column(name = "date_entry", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateEntry;

	@NotEmpty
	@Column(nullable = false, length = 50)
	private String project;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Item> itens;

	public User() {
	}

	@Override
	public String toString() {
		return "User " + super.toString();
	}
}