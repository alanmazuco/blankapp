package br.eti.amazu.infra.view.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.eti.amazu.component.pworld.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theme extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	//possui um id? eh bom estender AbstractEntity
	private Long id;
	
	private String value;

	private List<Theme> themes;

	public Theme(Long id, String value) {
		this.id = id;
		this.value = value;
	}

	public List<Theme> getThemes() {
		themes = new ArrayList<>();
		themes.add(new Theme(0L, "arya"));
		themes.add(new Theme(1L, "nova-light"));
		themes.add(new Theme(2L, "nova-dark"));
		themes.add(new Theme(3L, "nova-colored"));
		themes.add(new Theme(4L, "luna-blue"));
		themes.add(new Theme(5L, "luna-amber"));
		themes.add(new Theme(6L, "luna-green"));
		themes.add(new Theme(7L, "luna-pink"));
		themes.add(new Theme(8L, "saga"));
		themes.add(new Theme(9L, "vela"));
		return themes;
	}
	
	
	@Override
	public Long getId() {
		return id;
	}
	
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
    	
//	    return (o == this) && !(o instanceof Theme) && new EqualsBuilder()
//        .append(this.id, ((Theme) o).id)
//        .isEquals();
    	
        return (o instanceof Theme) && new EqualsBuilder()
                .append(getId(), ((Theme) o).getId())
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