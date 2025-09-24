## Biblioteca-JPA

## Descrição
Projeto em **Java** utilizando **JPA** para gerenciar uma biblioteca simplificada.  
Permite cadastrar usuários, livros, registrar empréstimos e devoluções, e consultar dados da biblioteca.

O projeto foi desenvolvido seguindo o padrão **DAO** (Data Access Object) e usando **Hibernate** como provedor JPA.

---

## Funcionalidades

### Usuários
- Cadastrar novos usuários
- Listar todos os usuários
- Buscar usuário por ID
- Atualizar dados do usuário
- Deletar usuário

### Livros
- Cadastrar livros
- Listar todos os livros
- Buscar livro por ID
- Atualizar informações do livro
- Deletar livro

### Empréstimos
- Registrar empréstimos de livros para usuários
- Registrar devolução de livros
- Listar empréstimos de um usuário específico

---

## Tecnologias
- Java 11+
- JPA (Hibernate)
- MySQL
- Maven (ou Gradle)
- Persistência em banco relacional

---

 ## Observações

- O projeto é didático, focado em prática de JPA e padrão DAO.
- Transações são tratadas corretamente, com rollback em caso de erros.
- EntityManagerFactory e EntityManager são fechados ao final da execução para evitar vazamento de recursos.
