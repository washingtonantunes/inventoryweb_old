package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusProjectEnum {

	ACTIVE("ATIVO"), 
	DISABLED("DESATIVADO");

	private String descricao;

	StatusProjectEnum(String descricao) {
		this.descricao = descricao;
	}
}
