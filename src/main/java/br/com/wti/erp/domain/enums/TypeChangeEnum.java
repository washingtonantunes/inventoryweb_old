package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum TypeChangeEnum {

	ENTRY("ENTRADA"), 
	WITHDRAWN("WITHDRAWN"),
	DELIVERY_TO_USER("ENTREGA PARA USUÁRIO");

	private String descricao;
	
	private TypeChangeEnum(String descricao) {
		this.descricao = descricao;
	}
}
