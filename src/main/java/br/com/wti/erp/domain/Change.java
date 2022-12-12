package br.com.wti.erp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.wti.erp.domain.enums.TypeChangeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_changes")
public class Change implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private TypeChangeEnum type;

	@Column(nullable = false, length = 200)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;

	@Column(nullable = false, length = 50)
	private String author;

	public Change() {
	}

	@Override
	public String toString() {
		return "Change " + super.toString();
	}
}