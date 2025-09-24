package application;

import dao.impl.LivroDAOImpl;
import dao.impl.UsuarioDAOImpl;
import dao.impl.EmprestimoDAOImpl;
import model.Livro;
import model.Usuario;
import model.Emprestimo;

import java.time.LocalDate;
import java.util.List;

public class Programa {

    public static void main(String[] args) {

        // Instanciando DAOs
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        LivroDAOImpl livroDAO = new LivroDAOImpl();
        EmprestimoDAOImpl emprestimoDAO = new EmprestimoDAOImpl();

        // 1️ Cadastrar Usuários
        Usuario u1 = new Usuario("Alice", "alice@gmail.com");
        Usuario u2 = new Usuario("Bob", "bob@gmail.com");
        usuarioDAO.cadastrar(u1);
        usuarioDAO.cadastrar(u2);

        // 2️ Cadastrar Livros
        Livro l1 = new Livro("Dom Casmurro", "Machado de Assis", true);
        Livro l2 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", true);
        Livro l3 = new Livro("Java: Como Programar", "Deitel", true);
        livroDAO.cadastrar(l1);
        livroDAO.cadastrar(l2);
        livroDAO.cadastrar(l3);

        // 3️ Registrar Empréstimos
        Emprestimo e1 = new Emprestimo(u1, l1, LocalDate.now(), null);
        Emprestimo e2 = new Emprestimo(u2, l2, LocalDate.now(), null);
        emprestimoDAO.registrarEmprestimo(e1);
        emprestimoDAO.registrarEmprestimo(e2);

        // 4️ Listar todos os empréstimos de Alice
        System.out.println("Empréstimos de Alice:");
        List<Emprestimo> emprestimosAlice = emprestimoDAO.listarPorUsuario(u1);
        emprestimosAlice.forEach(System.out::println);

        // 5️ Devolver um livro
        System.out.println("\nDevolvendo livro 'Dom Casmurro'...");
        emprestimoDAO.registrarDevolucao(e1.getId());

        // 6️ Listar novamente os empréstimos de Alice
        System.out.println("\nEmpréstimos de Alice após devolução:");
        emprestimosAlice = emprestimoDAO.listarPorUsuario(u1);
        emprestimosAlice.forEach(System.out::println);

        // 7️ Listar todos os livros e suas disponibilidades
        System.out.println("\nTodos os livros:");
        livroDAO.listarTodos().forEach(System.out::println);

        // Fechar DAOs
        usuarioDAO.fechar();
        livroDAO.fechar();
        emprestimoDAO.fechar();
    }
}