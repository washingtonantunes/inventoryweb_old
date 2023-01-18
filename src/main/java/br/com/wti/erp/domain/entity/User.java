package br.com.wti.erp.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.wti.erp.domain.enums.StatusUserEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "registration"})
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	private Set<Item> itens;

	@ManyToOne(optional = true)
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;
	
	@Override
	public String toString() {
		return "User " + super.toString();
	}
}