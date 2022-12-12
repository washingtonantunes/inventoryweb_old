package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusComputerEnum {

	STAND_BY("ESPERA"), 
	IN_USE("EM USO"), 
	DISABLED("DESATIVADO"), 
	DISCARDED("DESCARTADO");

	private String descricao;

	StatusComputerEnum(String descricao) {
		this.descricao = descricao;
	}
}
