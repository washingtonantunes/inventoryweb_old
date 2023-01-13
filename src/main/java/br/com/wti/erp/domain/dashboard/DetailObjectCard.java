package br.com.wti.erp.domain.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailObjectCard {

	private Long valueTotal = 0L;

	private Long valueStandBy = 0L;

	private Long valueInUse = 0L;

	private Long valueDisabled = 0L;
	
	private Long valueActive = 0L;
	
	private Long valueExpired = 0L;
	
	public DetailObjectCard() {
	}

	public DetailObjectCard(Long valueTotal, Long valueStandBy, Long valueInUse, Long valueDisabled) {
		this.valueTotal = valueTotal;
		this.valueStandBy = valueStandBy;
		this.valueInUse = valueInUse;
		this.valueDisabled = valueDisabled;
	}

	public DetailObjectCard(Long valueActive, Long valueExpired) {
		this.valueActive = valueActive;
		this.valueExpired = valueExpired;
	}
}
