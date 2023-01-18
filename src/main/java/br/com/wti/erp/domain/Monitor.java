package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wti.erp.domain.enums.StatusEquipmentEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_monitors")
public class Monitor extends AbstractEquipment implements Serializable {

	private static final long serialVersionUID = 1L;

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
