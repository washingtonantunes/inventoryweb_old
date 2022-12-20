package br.com.wti.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.wti.erp.domain.changes.ChangeComputer;
import br.com.wti.erp.domain.enums.StatusComputerEnum;
import br.com.wti.erp.domain.enums.TypeComputerEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_computers")
public class Computer extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "serial_number", unique = true, nullable = false, length = 30)
	private String serialNumber;

	@NotNull
	@Column(nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private TypeComputerEnum type;

	@NotEmpty
	@Column(nullable = false, length = 10)
	private String brand;

	@NotEmpty
	@Column(nullable = false, length = 30)
	private String model;

	@NotNull
	@Column(name = "date_entry", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEntry;

	@NotEmpty
	@Column(name = "note_entry", nullable = false, length = 20)
	private String noteEntry;

	@NotEmpty
	@Column(nullable = false, length = 30)
	private String location;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private StatusComputerEnum status;

	private String note;

	@Column(precision = 10, scale = 2)
	private BigDecimal value;

	@Column(name = "host_name", unique = true, length = 30)
	private String hostName;

	@Column(name = "address_mac", length = 30)
	private String addressMAC;

	@Column(name = "patrimony_number", unique = true, length = 10)
	private String patrimonyNumber;

	@Column(name = "memory_ram", length = 10)
	private String memoryRam;

	@Column(name = "hard_disk", length = 10)
	private String hardDisk;

	@Column(name = "cost_type", length = 30)
	private String costType;

	@ManyToOne(optional = true)
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;

	@OneToOne(optional = true)
	@JoinColumn(name = "user_id", unique = true)
	private User user;

	@OneToMany(mappedBy = "computer", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private List<ChangeComputer> changes;

	public void addChange(ChangeComputer change) {
		if (change != null) {
			this.changes.add(change);
		}
	}

	public void removeChange(ChangeComputer change) {
		if (change != null) {
			this.changes.remove(change);
		}
	}

	@Override
	public String toString() {
		return "Computer " + super.toString();
	}
}
