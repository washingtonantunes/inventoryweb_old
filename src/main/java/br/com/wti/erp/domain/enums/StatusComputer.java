package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusComputer {

	STAND_BY("ESPERA"), 
	IN_USE("EM USO"), 
	DISABLED("DESATIVADO"), 
	DISCARDED("DESCARTADO");

	private String descricao;

	StatusComputer(String descricao) {
		this.descricao = descricao;
	}
}
