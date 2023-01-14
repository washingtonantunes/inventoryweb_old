package br.com.wti.erp.domain.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDetailLicense {

	private Long valueTotal = 0L;
	private Long valueStandBy = 0L;
	private Long valueInUse = 0L;
	private Long valueExpired = 0L;

	public CardDetailLicense() {
	}

	public CardDetailLicense(Long valueTotal, Long valueStandBy, Long valueInUse, Long valueExpired) {
		this.valueTotal = valueTotal;
		this.valueStandBy = valueStandBy;
		this.valueInUse = valueInUse;
		this.valueExpired = valueExpired;
	}
}
