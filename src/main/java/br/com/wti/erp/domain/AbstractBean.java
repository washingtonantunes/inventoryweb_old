package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EqualsAndHashCode(of = { "id" })
public abstract class AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
            name = "tb_changes_beans",
            joinColumns = {@JoinColumn(name = "bean_id")},
            inverseJoinColumns = {@JoinColumn(name = "change_id")}
    )
	
	@Getter
	private List<Change> changes;
	
	public void addChange(Change change) {
		if (change != null) {
			this.changes.add(change);
		}
	}

	public void removeChange(Change change) {
		if (change != null) {
			this.changes.remove(change);
		}
	}

	@Override
	public String toString() {
		return "[id=" + id + "]";
	}
}
