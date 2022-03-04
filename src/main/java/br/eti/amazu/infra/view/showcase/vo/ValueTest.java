package br.eti.amazu.infra.view.showcase.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.eti.amazu.component.pworld.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValueTest extends AbstractEntity<Long> {	
	
	private static final long serialVersionUID = -2413164380798986122L;

	private Long id;
	
	private Integer intValue; //.............integer normal
	private Integer intValue4; //............integer com limitacao de 4 digitos
	private Long longValue; //...............long normal
	private Double doubleValue; //...........double normal contendo varias casas decimais
	private Double moeda; //.................double com apenas duas casas decimais (moeda)
	private Date dateValue; //...............campo data normal Date()
	private String strValue6; //.............String com limitacao de 6 caracteres
	private String strValue; //..............String sem limites
	private String strValueNoSpaceBlank; //..String nao admite espaco em branco
	
	@CPF
	private String cpf;
	
	@CNPJ
	private String cnpj;
	
	private String email;
	private String tel;
	private String cep;
	
	@Override
	public Long getId() {
		return id;
	}
			
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
