package br.com.wti.erp.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.wti.erp.domain.Project;

@FacesConverter(value = "ProjectConverter")
public class ProjectConverter implements Converter<Project> {
	
	@Override
	public Project getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.trim().isEmpty()) {
			return new Project(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Project value) {
		if (value == null) {
			return null;
		}

		Project project = (Project) value;

		return project.getId().toString();
	}

}
