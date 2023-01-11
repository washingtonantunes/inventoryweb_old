package br.com.wti.erp.domain.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityObjectForProject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long computers;
	private Long monitors;
	private Long peripherals;
	private Long licenses;
	private Long users;
	
	public QuantityObjectForProject() {
	}
	
	public QuantityObjectForProject(Long computers, Long monitors, Long peripherals, Long licenses, Long users) {
		this.computers = computers;
		this.monitors = monitors;
		this.peripherals = peripherals;
		this.licenses = licenses;
		this.users = users;
	}
}
