package br.eti.amazu.infra.view.validator;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;

import br.eti.amazu.infra.util.FacesUtil;

@FacesValidator("phoneValidator")
public class PhoneValidator implements Validator<Object> {	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value) {
		
		if(value != null  && !value.equals("") && value.toString().length() < 13){
											
			/* pegar o label do componente 
			 * Eh necessario setar no componente o atributo label na view). */
			Map<String, Object> map = component.getAttributes();

			log.info( map.get("label").toString() );
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,null,null);
			msg.setSummary(map.get("label") + ": " + new FacesUtil().getMessage("CGL164"));				
		}
				
	}	

}