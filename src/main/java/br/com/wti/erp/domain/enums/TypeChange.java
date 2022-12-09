package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum TypeChange {

	ENTRY("ENTRADA"), 
	WITHDRAWN("WITHDRAWN");

	private String descricao;
	
	private TypeChange(String descricao) {
		this.descricao = descricao;
	}
}
