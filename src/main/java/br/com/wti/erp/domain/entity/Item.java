package br.com.wti.erp.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_items")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_project", nullable = false)
	private Project project;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	@NotEmpty
	@Column(unique = true, nullable = false)
	private Long identification;

	@NotEmpty
	@Column(nullable = false, length = 30)
	private String type;

	@NotEmpty
	@Column(nullable = false, length = 20)
	private Double value;
	
	@NotNull
	@Column(name = "date_delivery", nullable = false)
	private LocalDate dateDelivery;
	
	@Column(name = "date_devolution", nullable = false)
	private LocalDate dateDevolution;

	@Override
	public String toString() {
		return "Item " + super.toString();
	}
}
