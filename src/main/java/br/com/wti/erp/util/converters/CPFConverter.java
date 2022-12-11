package br.com.wti.erp.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "CPFConverter")
public class CPFConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		/*
		 * Irá converter CPF formatado para um sem pontos e traço. Ex.: 355.245.198-87
		 * torna-se 35524519887.
		 */
		if (value != null && !value.equals("")) {
			return value.replaceAll("\\.", "").replaceAll("\\-", "");
		}

		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		/*
		 * Irá converter CPF não formatado para um com pontos e traço. Ex.: 35524519887
		 * torna-se 355.245.198-87.
		 */
		String cpf = (String) value;
		if (cpf != null && cpf.length() == 11)
			return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
					+ cpf.substring(9, 11);

		return "";
	}

}
