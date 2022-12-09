package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusUser {

	ACTIVE("ATIVO"), 
	DISABLED("DESATIVADO");

	private String descricao;

	StatusUser(String descricao) {
		this.descricao = descricao;
	}
}
