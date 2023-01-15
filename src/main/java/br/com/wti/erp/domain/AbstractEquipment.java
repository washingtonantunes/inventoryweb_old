package br.com.wti.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.wti.erp.domain.enums.StatusEquipmentEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEquipment extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "serial_number", unique = true, nullable = false, length = 30)
	private String serialNumber;
	
	@Column(name = "patrimony_number", unique = true, length = 10)
	private String patrimonyNumber;
	
	@NotEmpty
	@Column(nullable = false, length = 10)
	private String brand;

	@NotEmpty
	@Column(nullable = false, length = 30)
	private String model;

	@NotNull
	@Column(name = "date_entry", nullable = false)
	private LocalDate dateEntry;

	@NotEmpty
	@Column(name = "note_entry", nullable = false, length = 20)
	private String noteEntry;
	
	@NotEmpty
	@Column(nullable = false, length = 30)
	private String location;

	private String note;

	@Column(precision = 10, scale = 2)
	private BigDecimal value;
	
	@Column(name = "cost_type", length = 30)
	private String costType;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private StatusEquipmentEnum status;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;

	@OneToOne(optional = true)
	@JoinColumn(name = "user_id", unique = true)
	private User user;
	
}
