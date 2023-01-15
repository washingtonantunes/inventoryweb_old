package br.com.wti.erp.domain.vo;

import br.com.wti.erp.domain.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuantityForStatus {

	private StatusEnum status;
	private long quantity;

	public QuantityForStatus() {
	}

	public QuantityForStatus(StatusEnum status, long quantity) {
		this.status = status;
		this.quantity = quantity;
	}
}
