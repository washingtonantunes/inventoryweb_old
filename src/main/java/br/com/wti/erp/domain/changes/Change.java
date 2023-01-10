package br.com.wti.erp.domain.changes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.wti.erp.domain.enums.TypeChangeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode(of = { "id" })
public abstract class Change implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_change", nullable = false)
	private TypeChangeEnum type;

	@Column(nullable = false, length = 200)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_change", nullable = false)
	private Date dateChange;

	@Column(nullable = false, length = 50)
	private String author;

	@Override
	public String toString() {
		return "[id=" + id + "]";
	}
}