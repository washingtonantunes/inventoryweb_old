package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum StatusProjectEnum implements StatusEnum {

	ACTIVE("ATIVO"), 
	DISABLED("DESATIVADO");

	private String descricao;

	StatusProjectEnum(String descricao) {
		this.descricao = descricao;
	}
}
