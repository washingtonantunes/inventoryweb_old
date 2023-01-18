package br.com.wti.erp.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.wti.erp.domain.enums.StatusEquipmentEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_monitors")
public class Monitor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString() {
		return "Monitor " + super.toString();
	}
}
