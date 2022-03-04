package br.eti.amazu.infra.view.vo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Config {
	
	/* Nao eh uma entidade persistente. 
	 * Um Value Object serve apenas para
	 * transportar dados entre as camadas. */

	/*--------------
	 * Dados de Menu
	 -------------*/
	private String menuType;
	
	/*--------------
	 * Dados de skin
	 -------------*/
	private String skinFooter;
	private String skinBackground;
	private String skinImageLogo;
	private String skinLogo;
	private String skinTextLogo;
	private String skinColorTextLogo;
	private String skinTheme;
	private String skinAnimatedTop;
	private String skinAnimatedHtml;
	
	public Config() {
		//do not compliance
	}
	
    /**
     * {@inheritDoc}
     */
    @Override    
    public boolean equals(Object o) {
    	return EqualsBuilder.reflectionEquals(this, o);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
    	return HashCodeBuilder.reflectionHashCode(this);
    }
	
}
