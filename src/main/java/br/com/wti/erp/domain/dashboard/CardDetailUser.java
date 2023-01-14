package br.com.wti.erp.domain.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDetailUser {

	private Long valueTotal = 0L;
	private Long valueActive = 0L;
	private Long valueDisabled = 0L;

	public CardDetailUser() {
	}

	public CardDetailUser(Long valueTotal, Long valueActive, Long valueDisabled) {
		this.valueTotal = valueTotal;
		this.valueActive = valueActive;
		this.valueDisabled = valueDisabled;
	}
}
