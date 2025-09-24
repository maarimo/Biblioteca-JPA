package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String autor;
	private boolean disponivel;
	
	public Livro() {
	}

	public Livro(String titulo, String autor, boolean disponivel) {
		this.titulo = titulo;
		this.autor = autor;
		this.disponivel = disponivel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public String toString() {
		return "livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", disponivel=" + disponivel + "]";
	}	
}
