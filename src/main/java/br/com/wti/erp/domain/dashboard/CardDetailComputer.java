package br.com.wti.erp.domain.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDetailComputer {

	private Long valueTotal = 0L;
	private Long valueStandBy = 0L;
	private Long valueInUse = 0L;
	private Long valueDisabled = 0L;

	public CardDetailComputer() {
	}

	public CardDetailComputer(Long valueTotal, Long valueStandBy, Long valueInUse, Long valueDisabled) {
		this.valueTotal = valueTotal;
		this.valueStandBy = valueStandBy;
		this.valueInUse = valueInUse;
		this.valueDisabled = valueDisabled;
	}
}
