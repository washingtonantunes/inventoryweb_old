package br.com.wti.erp.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.wti.erp.domain.enums.TypeComboBoxEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "id", "description" })
@NoArgsConstructor
@Entity
@Table(name = "tb_combobox_options")
public class ComboBoxOption implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "description_option")
	private String description;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "type_option")
	private TypeComboBoxEnum type;

	@Override
	public String toString() {
		return "ComboBoxOption [description=" + description + "]";
	}
}
