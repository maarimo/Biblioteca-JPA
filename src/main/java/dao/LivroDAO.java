package dao;

import java.util.List;

import model.Livro;

public interface LivroDAO {
	void cadastrar(Livro livro);
	Livro buscarPorId(Long id);
	List<Livro> listarTodos();
	void atualizar(Livro livro);
	void deletar(Long id);
}
