package dao;

import java.util.List;

import model.Emprestimo;
import model.Usuario;

public interface EmprestimoDAO {
	void registrarEmprestimo (Emprestimo emprestimo);
	void registrarDevolucao (Integer emprestimoId);
	List<Emprestimo> listarPorUsuario(Usuario usuario);
}
