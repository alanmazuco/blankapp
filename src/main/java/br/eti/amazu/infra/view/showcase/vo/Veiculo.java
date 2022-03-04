package br.eti.amazu.infra.view.showcase.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Veiculo implements Serializable {

	private static final long serialVersionUID = -458523415696072003L;
	
	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
	private String ano;
	
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {    	    	
        return (o instanceof ValueTest) && new EqualsBuilder()
                .append(getId(), ((ValueTest) o).getId())
                .isEquals(); 
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {    	
        return new HashCodeBuilder()
                .append(getId())
                .toHashCode();
    } 
}

