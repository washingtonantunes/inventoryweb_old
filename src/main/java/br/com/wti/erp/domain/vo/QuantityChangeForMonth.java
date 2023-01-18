package br.com.wti.erp.domain.vo;

import java.io.Serializable;

import br.com.wti.erp.domain.enums.TypeChangeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityChangeForMonth implements Serializable {

	private static final long serialVersionUID = 1L;

	private TypeChangeEnum type;
	private long quantity;
	private int month;

	public QuantityChangeForMonth(TypeChangeEnum type, long quantity, int month) {
		this.type = type;
		this.quantity = quantity;
		this.month = month;
	}
}
