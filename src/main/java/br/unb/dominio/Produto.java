package br.unb.dominio;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "produtos")
public class Produto {
    // campos e anotações de mapeamento
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
}
