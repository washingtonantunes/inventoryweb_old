package br.com.wti.erp.domain.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityChangesForMonth implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int date;
	private long quantity;
	
	public QuantityChangesForMonth(int date, long quantity) {
		this.date = date;
		this.quantity = quantity;
	}
}
