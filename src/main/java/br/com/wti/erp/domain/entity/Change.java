package br.com.wti.erp.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wti.erp.domain.enums.TypeChangeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = { "id" })
@Table(name = "tb_changes")
public class Change implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String entity;

	@Enumerated(EnumType.STRING)
	@Column(name = "type_change", nullable = false)
	private TypeChangeEnum type;

	@Column(nullable = false, length = 200)
	private String description;

	@Column(name = "date_change", nullable = false)
	private LocalDate date;

	@Column(nullable = false, length = 50)
	private String author;

	@Override
	public String toString() {
		return "[id=" + id + "]";
	}
}