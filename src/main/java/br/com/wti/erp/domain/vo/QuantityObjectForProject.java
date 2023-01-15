package br.com.wti.erp.domain.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityObjectForProject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long computers;
	private long monitors;
	private long peripherals;
	private long licenses;
	private long users;
	
	public QuantityObjectForProject() {
	}
	
	public QuantityObjectForProject(long computers, long monitors, long peripherals, long licenses, long users) {
		this.computers = computers;
		this.monitors = monitors;
		this.peripherals = peripherals;
		this.licenses = licenses;
		this.users = users;
	}
}
