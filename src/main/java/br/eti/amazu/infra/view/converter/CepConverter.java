package br.eti.amazu.infra.view.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("cepConverter")
public class CepConverter implements Converter<Object> {

	//Converte o objeto da view para o backEnd.
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)  {
		
		if ( value == null || value.equals("")){				
			return null; //isto devolve ao jsf o controle de campos em branco		
		}
				
		//Devolve a string sem formato
		return value.replace("-", "");			
	}  
	   
	//Converte o objeto do backEnd para a view.
    @Override
	public String getAsString(FacesContext context, UIComponent component, Object value)  {
    	    	
    	//montando e devolvendo o cep formatado.
    	if (value == null || value.equals("")){
    		return null;
    	}
    	return value.toString().substring(0, 5) + "-" + value.toString().substring(5);
    } 	    
}