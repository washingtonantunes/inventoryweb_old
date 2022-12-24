package br.com.wti.erp.domain.dashboard;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Dashboard {

	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private List<DetailObject> cardsDetail = new ArrayList<>();

	public void addDetailObject(DetailObject detailObject) {
		if (detailObject != null) {
			cardsDetail.add(detailObject);
		}
	}
}
