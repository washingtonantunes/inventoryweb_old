package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusUserEnum {

	ACTIVE("ATIVO"), 
	DISABLED("DESATIVADO");

	private String descricao;

	StatusUserEnum(String descricao) {
		this.descricao = descricao;
	}
}
