package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusEquipmentEnum implements StatusEnum {

	STAND_BY("DISPONIVEL"), 
	IN_USE("EM USO"), 
	DISABLED("DESATIVADO"), 
	DISCARDED("DESCARTADO");

	private String descricao;

	StatusEquipmentEnum(String descricao) {
		this.descricao = descricao;
	}
}
