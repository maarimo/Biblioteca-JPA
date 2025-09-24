## Biblioteca-JPA

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
