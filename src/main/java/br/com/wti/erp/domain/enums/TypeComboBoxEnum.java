package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum TypeComboBoxEnum {

	BRAND_COMPUTER("MARCA"), 
	MODEL_COMPUTER("MODELO"),
	COST_TYPE("TIPO DE CUSTO"),
	MEMORY_RAM("MEMÓRIA RAM"),
	HARD_DISK("DISCO RÍGIDO");

	private String description;

	TypeComboBoxEnum(String description) {
		this.description = description;
	}
}
