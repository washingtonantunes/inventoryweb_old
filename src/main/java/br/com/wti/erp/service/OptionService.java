package br.com.wti.erp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.wti.erp.domain.entity.ComboBoxOption;
import br.com.wti.erp.domain.enums.TypeComboBoxEnum;
import br.com.wti.erp.domain.enums.TypeStatausEnum;
import br.com.wti.erp.util.annotations.Transactional;

public class OptionService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OptionRepository optionRepository;

	public List<ComboBoxOption> findOptionForType(TypeComboBoxEnum typeSelected) {
		return optionRepository.findOptionForType(typeSelected);
	}

	@Transactional
	public Status save(ComboBoxOption combo) {
		// TODO criar change
		final Status status = new Status();
		try {
			optionRepository.save(combo);
			status.setStatus(TypeStatausEnum.SUCESS);
			status.setMessage("Opção salva com sucesso!");
		} catch (PersistenceException ex) {
			status.setStatus(TypeStatausEnum.ERROR);
			status.setMessage("Opção já existe!");
		} 
		return status;
	}
}
