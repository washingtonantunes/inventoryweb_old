package br.com.wti.erp.repository;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String paramSearch;
}
