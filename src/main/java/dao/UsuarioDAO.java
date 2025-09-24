package dao;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	void cadastrar(Usuario usuario);
	Usuario buscarPorId(Long id);
	List<Usuario> listarTodos();
	void atualizar(Usuario usuario);
	void deletar(Long id);

}
