package br.eti.amazu.infra.view.converter;

import java.util.Map;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import br.eti.amazu.component.pworld.domain.AbstractEntity;
 
@FacesConverter(value = "objectConverter")
public class ObjectConverter implements Converter<Object> {
 
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        if (value != null && !value.equals("")) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }
 
	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
            Object value) { 
		

		if (value != null && !value.equals("")) {
			

			@SuppressWarnings("unchecked")
			AbstractEntity<Long> entity = (AbstractEntity<Long>) value;

			this.addAttribute(component, entity);
			return String.valueOf(entity.getId());
		}
        return "";
    }
 
    private void addAttribute(UIComponent component, AbstractEntity<Long> o) {
        this.getAttributesFrom(component).put(o.getId().toString(), o);
    }
 
    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
 
}
