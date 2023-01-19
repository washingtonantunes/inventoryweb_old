package br.com.wti.erp.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.wti.erp.domain.enums.StatusProjectEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})
@NoArgsConstructor
@Entity
@Table(name = "tb_projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotEmpty
	@Column(name = "name_project", unique = true, nullable = false)
	private String name;

	@NotEmpty
	@Column(nullable = false)
	private String city;

	@NotEmpty
	@Column(name = "cost_center", unique = true, nullable = false)
	private String costCenter;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status_project", nullable = false)
	private StatusProjectEnum status;

	@NotNull
	@Column(name = "date_entry", nullable = false)
	private LocalDate dateEntry;

	private Long quantityComputers;
	
	private Long quantityUsers;
	
	private Long quantityMonitors;
	
	public Project(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Project " + super.toString();
	}
}
