package br.com.wti.erp.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import br.com.wti.erp.domain.enums.TypeComputerEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "serialNumber"})
@NoArgsConstructor
@Entity
@Table(name = "tb_computers")
public class Computer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotEmpty
	@Column(name = "serial_number", unique = true, nullable = false)
	private String serialNumber;
	
	@Column(name = "patrimony_number", unique = true)
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

	@Column(name = "value_computer", precision = 10, scale = 2)
	private BigDecimal value;
	
	@Column(name = "cost_type", length = 30)
	private String costType;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status_computer", nullable = false)
	private StatusEquipmentEnum status;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "type_computer", nullable = false)
	private TypeComputerEnum type;

	@Column(name = "host_name", unique = true, length = 30)
	private String hostName;

	@Column(name = "address_mac", length = 30)
	private String addressMAC;

	@Column(name = "memory_ram", length = 10)
	private String memoryRam;

	@Column(name = "hard_disk", length = 10)
	private String hardDisk;
	
	@ManyToOne
	@JoinColumn(name = "id_project")
	private Project project;

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	@Override
	public String toString() {
		return "Computer " + super.toString();
	}
}
