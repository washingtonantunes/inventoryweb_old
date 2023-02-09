package br.com.wti.erp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.wti.erp.domain.entity.ComboBoxOption;
import br.com.wti.erp.domain.enums.TypeComboBoxEnum;
import br.com.wti.erp.domain.enums.TypeStatausEnum;
import br.com.wti.erp.service.OptionService;
import br.com.wti.erp.service.Status;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class OptionMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OptionService optionService;

	@Getter
	@Setter
	private List<ComboBoxOption> options;

	@Getter
	@Setter
	private TypeComboBoxEnum typeSelected;
	
	@Getter
	@Setter
	private ComboBoxOption optionSelected;
	
	@Getter
	@Setter
	private String description;

	@PostConstruct
	public void init() {
		options = new ArrayList<>();
	}
	
	public TypeComboBoxEnum[] getType() {
		TypeComboBoxEnum[] valores = TypeComboBoxEnum.values();
		return valores;
	}
	
	public void changed() {
		options = optionService.findOptionForType(typeSelected);
	}
	
	public String save() {
		ComboBoxOption combo = new ComboBoxOption();
		combo.setDescription(description.trim().toUpperCase());
		combo.setType(typeSelected);
		Status status = optionService.save(combo);
		
		if(status.getStatus() == TypeStatausEnum.SUCESS) {
			description = null;
			changed();
			messageInfo(status.getMessage());
		} else {
			messageError(status.getMessage());
		}
		return null;
	}
}
