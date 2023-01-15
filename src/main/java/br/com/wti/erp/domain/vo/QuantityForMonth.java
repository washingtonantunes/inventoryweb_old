package br.com.wti.erp.domain.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityForMonth implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int date;
	private long quantity;
	
	public QuantityForMonth(int date, long quantity) {
		this.date = date;
		this.quantity = quantity;
	}
}
