package br.com.wti.erp.domain.enums;

import lombok.Getter;

@Getter
public enum TypeChangeEnum {

	ENTRY("ENTRADA"), 
	WITHDRAWN("WITHDRAWN"),
	DELIVERY_TO_USER("ENTREGA PARA USUÁRIO"),
	EXCHANGE_TO_USER("TROCA DE EQUIPAMENTO"),
	DEVOLUTION_TO_USER("DEVOLUÇÃO POR USUÁRIO");

	private String description;
	
	private TypeChangeEnum(String description) {
		this.description = description;
	}
}
