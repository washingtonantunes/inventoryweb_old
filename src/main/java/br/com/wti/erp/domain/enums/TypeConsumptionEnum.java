package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum TypeConsumptionEnum {

	ALL("Todos"),
	COMPUTERS("Computador"),
	MONITORS("Monitor"),
	PERIPHERALS("Periféricos"),
	LICENSES("Licenças");

	private String descricao;
	
	private TypeConsumptionEnum(String descricao) {
		this.descricao = descricao;
	}
}
