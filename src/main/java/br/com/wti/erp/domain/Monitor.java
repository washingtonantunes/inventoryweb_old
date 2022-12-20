package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.wti.erp.domain.changes.ChangeMonitor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_monitors")
public class Monitor extends AbstractEquipment implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "monitor", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@Getter
	@Setter(value = AccessLevel.PRIVATE)
	private List<ChangeMonitor> changes;

	public void addChange(ChangeMonitor change) {
		if (change != null) {
			this.changes.add(change);
		}
	}

	public void removeChange(ChangeMonitor change) {
		if (change != null) {
			this.changes.remove(change);
		}
	}

	@Override
	public String toString() {
		return "Monitor " + super.toString();
	}
}
