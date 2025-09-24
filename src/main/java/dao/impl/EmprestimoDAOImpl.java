package dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EmprestimoDAO;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class EmprestimoDAOImpl implements EmprestimoDAO {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	private EntityManager em = emf.createEntityManager();

	@Override
	public void registrarEmprestimo(Emprestimo emprestimo) {
		try {
			em.getTransaction().begin();

			Livro livro = emprestimo.getLivro();
			livro.setDisponivel(false); // marca como indisponivel
			em.merge(livro);

			em.persist(emprestimo);
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new RuntimeException("ERRO AO REGISTRAR.", e);
		}

	}

	@Override
	public void registrarDevolucao(Integer emprestimoId) {
		try {
			em.getTransaction().begin();
			Emprestimo emprestimo = em.find(Emprestimo.class, emprestimoId);
			
			if(emprestimo != null) {
				emprestimo.setDataDevolucao(LocalDate.now());
				
				Livro livro = emprestimo.getLivro();
				livro.setDisponivel(true); //marca disponivel
				em.merge(livro);
				
				em.merge(emprestimo);
			}
			
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			throw new RuntimeException("ERRO NA DEVOLUÇÂO", e);
		}
	}
	

	@Override
	public List<Emprestimo> listarPorUsuario(Usuario usuario) {
		List<Emprestimo> lista = em.createQuery("SELECT e FROM Emprestimo e WHERE e.usuario = :usuario", Emprestimo.class)
				.setParameter("usuario", usuario)
				.getResultList();
		
		return lista;
	}
	
	public void fechar() {
		if(em.isOpen()) em.close();
		if(emf.isOpen()) emf.close();
	}

}
