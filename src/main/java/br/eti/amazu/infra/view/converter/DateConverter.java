package br.eti.amazu.infra.view.converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import br.eti.amazu.infra.util.DateUtil;
import br.eti.amazu.infra.util.FacesUtil;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateConverter implements Converter<Object> {
	
	@Override //Converte o objeto da view para o backEnd.
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
				
		// Controle de campos em branco
		if (value == null || value.equals("")) return null;

		/*
		 * pegar o label do componente Eh necessario 
		 * setar no componente o atributo label na view.
		 */
		Map<String, Object> map = component.getAttributes();

		try {
			DateUtil.isValidDate(value); //apenas para provocar uma Exception, se houver...				
			return DateUtil.getLocalDate(value);
			
		}catch(Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, null);
			String label = map.get("label") != null ? map.get("label").toString() : "-";
			msg.setSummary(new FacesUtil().getMessage("MGL044", new String[] { label, value }));
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, msg);
			return null;
		}		
		
	}  
	   	
    @Override //Converte o objeto do backEnd para a view.
	public String getAsString(FacesContext context, UIComponent component, Object value) {    	    
    	
		//se value eh nulo devolve empty
		if (value == null) return "";
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime((java.util.Date) value);
		
		LocalDate localDate = calendar.getTime().toInstant()
			      .atZone(ZoneId.systemDefault())
				  .toLocalDate();			
		
		return DateUtil.getStringDate(localDate);
    } 
	    
}