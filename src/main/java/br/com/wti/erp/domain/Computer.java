package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wti.erp.domain.enums.StatusEquipmentEnum;
import br.com.wti.erp.domain.enums.TypeComputerEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_computers")
public class Computer extends AbstractEquipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private TypeComputerEnum type;

	@Column(name = "host_name", unique = true, length = 30)
	private String hostName;

	@Column(name = "address_mac", length = 30)
	private String addressMAC;

	@Column(name = "memory_ram", length = 10)
	private String memoryRam;

	@Column(name = "hard_disk", length = 10)
	private String hardDisk;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString() {
		return "Computer " + super.toString();
	}
}
