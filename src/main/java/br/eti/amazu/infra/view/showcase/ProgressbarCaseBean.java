package br.eti.amazu.infra.view.showcase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import br.eti.amazu.component.progressbar.ProgressBean;
import br.eti.amazu.infra.util.FacesUtil;

@Named
@RequestScoped
public class ProgressbarCaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	ProgressBean progressBean;
	
	public void testarProgressbar(){		
		progressBean.init("progressbarCaseBean.iterar", null, null);
	}
	
	public void iterar(){		
		
		int i = 1; //pode aqui representar o index de uma linha da ArrayList
		int a = 500; //pode aqui representar o tamanho de uma ArrayList
		
		progressBean.setPSize(a);

		while (i<=a){ //enquanto o index for menor que o tamanho...		
			log.info("Interrompeu o processo!");
			if (progressBean.isCancelou()){ //enquanto o usuário não cancelar...
						
				List<String> resultado = new ArrayList<>();
				resultado.add(new FacesUtil().getMessage("MGL063"));
				progressBean.setResultado(resultado);				
				return;
			}

			progressBean.setValue(i);//atualiza	a progressbar	
			progressBean.setStatus("iteration: " + i);
			timeout(10);//tempo em milissegundos			
			i++;
		}				
	}	
			
	//Fornece um timer para o funcionamento correto da iteracao.
	public void timeout(long timeMilisseconds) {
		long t0 = System.currentTimeMillis();

		while (System.currentTimeMillis() - t0 < timeMilisseconds) {
			//do not compliance
		}

	}	
	
}