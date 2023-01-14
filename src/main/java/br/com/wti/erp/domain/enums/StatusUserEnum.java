package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusUserEnum implements StatusEnum {

	ACTIVE("ATIVO"), 
	DISABLED("DESATIVADO"),
	UNDEFINED("NÃO DEFINIDO");

	private String descricao;

	StatusUserEnum(String descricao) {
		this.descricao = descricao;
	}
}
