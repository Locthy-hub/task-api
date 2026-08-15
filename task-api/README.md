# Task API

API REST simples para gerenciamento de tarefas, feita com Spring Boot para fins de estudo.

## Tecnologias
- Java 17
- Spring Boot 3.3.4
- Spring Web
- Spring Data JPA
- H2 Database (em memória)
- Maven

## Como executar

```bash
mvn spring-boot:run
```

A aplicação sobe em: `http://localhost:8080`

Console do banco H2 (opcional): `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:taskdb`
- User: `sa`
- Password: (em branco)

## Endpoints

| Método | URL          | Descrição               |
|--------|--------------|-------------------------|
| POST   | /tasks       | Cria uma nova tarefa    |
| GET    | /tasks       | Lista todas as tarefas  |
| GET    | /tasks/{id}  | Busca tarefa por id     |
| PUT    | /tasks/{id}  | Atualiza uma tarefa     |
| DELETE | /tasks/{id}  | Exclui uma tarefa       |
