package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.LivroDAO;
import model.Livro;

public class LivroDAOImpl implements LivroDAO{
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	private EntityManager em = emf.createEntityManager();

	@Override
	public void cadastrar(Livro livro) {
		try {
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			throw new RuntimeException("ERRO AO SALVAR.", e);
		}		
	}
	
	
	@Override
	public Livro buscarPorId(Long id) {
		return em.find(Livro.class, id);
	}

	@Override
	public List<Livro> listarTodos() {
		return em.createQuery("FROM Livro", Livro.class).getResultList();
	}

	@Override
	public void atualizar(Livro livro) {
		try {
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			throw new RuntimeException("ERRO AO ATUALIZAR.", e);
		}
		
	}

	@Override
	public void deletar(Long id) {
		try {
			em.getTransaction().begin();
			Livro l = em.find(Livro.class, id);
			if(l != null) em.remove(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			throw new RuntimeException("ERRO AO DELETAR.", e);
		}		
	}
	
	public void fechar() {
		if(em.isOpen()) em.close();
		if(emf.isOpen()) emf.close();
	}
}
