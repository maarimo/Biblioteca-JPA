package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	private EntityManager em = emf.createEntityManager();

	@Override
	public void cadastrar(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch(Exception e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			throw new RuntimeException("ERRO AO SALVAR.", e);
		}
		
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> listarTodos() {
		return em.createQuery("FROM Usuario", Usuario.class).getResultList();
	}

	@Override
	public void atualizar(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch(Exception e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			throw new RuntimeException("ERRO AO ATUALIZAR.", e);			
		}		
	}

	@Override
	public void deletar(Long id) {
		try {
			em.getTransaction().begin();
			Usuario u = em.find(Usuario.class, id);
			if(u != null) em.remove(u);
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
