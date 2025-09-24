package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//um emprestimo para um usuario
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	//um usuario para um livro
	@ManyToOne
	@JoinColumn(name = "livro_id", nullable = false)
	private Livro livro;
	
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	public Emprestimo() {
	}

	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", usuario=" + usuario + ", livro=" + livro + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "]";
	}
}
