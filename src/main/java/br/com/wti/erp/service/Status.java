package br.com.wti.erp.service;

import java.util.List;

import br.com.wti.erp.domain.enums.TypeStatausEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {

	private TypeStatausEnum status;
	private String message;
	private Object object;
	private List<Object> listObject;
}