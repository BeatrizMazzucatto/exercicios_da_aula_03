# API REST para Gerenciar Contatos

Este projeto implementa uma API REST completa para gerenciar uma lista de contatos.

## 🎯 Objetivos

- Demonstrar os conceitos fundamentais de APIs REST
- Implementar operações CRUD (Create, Read, Update, Delete)
- Seguir as convenções REST para métodos HTTP
- Utilizar Spring Boot para simplificar o desenvolvimento

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA** - Para persistência de dados
- **H2 Database** - Banco de dados em memória (para desenvolvimento)
- **Jakarta Validation** - Para validação de dados (usado nos desafios)

## 📋 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── contactapi/
│   │               ├── ContactApiApplication.java    # Classe principal
│   │               ├── controller/
│   │               │   └── ContactController.java    # Controller REST
│   │               ├── model/
│   │               │   └── Contact.java              # Entidade JPA
│   │               ├── repository/
│   │               │   └── ContactRepository.java    # Interface Repository
│   │               └── service/
│   │                   └── ContactService.java       # Camada de serviço
│   └── resources/
│       └── application.properties                    # Configurações
```

## 🚀 Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

### Passos

1. **Clone ou baixe o projeto**

2. **Navegue até o diretório do projeto**
   ```bash
   cd "Aula 3"
   ```

3. **Compile o projeto**
   ```bash
   mvn clean compile
   ```

4. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```
   
   Ou use os scripts:
   - Linux/Mac: `./run.sh`
   - Windows: `run.bat`

5. **Acesse a aplicação**
   - API: http://localhost:8080
   - Console H2: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:contactdb`
     - Usuário: `sa`
     - Senha: (deixe em branco)

## 📡 Endpoints da API

### Base URL: `http://localhost:8080/api/contacts`

| Método | Endpoint | Descrição | Corpo da Requisição |
|--------|----------|-----------|---------------------|
| **GET** | `/api/contacts` | Lista todos os contatos | ❌ |
| **GET** | `/api/contacts/{id}` | Busca um contato pelo ID | ❌ |
| **GET** | `/api/contacts/search?name=João` | Busca contatos pelo nome | ❌ |
| **POST** | `/api/contacts` | Cria um novo contato | ✅ JSON |
| **PUT** | `/api/contacts/{id}` | Atualiza completamente um contato | ✅ JSON |
| **PATCH** | `/api/contacts/{id}` | Atualiza parcialmente um contato | ✅ JSON |
| **DELETE** | `/api/contacts/{id}` | Deleta um contato | ❌ |

## 📝 Exemplos de Uso

### 1. Criar um novo contato (POST)

**Requisição:**
```bash
curl -X POST http://localhost:8080/api/contacts \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "telefone": "9999-9999",
    "email": "joao@email.com"
  }'
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "telefone": "9999-9999",
  "email": "joao@email.com"
}
```

### 2. Listar todos os contatos (GET)

**Requisição:**
```bash
curl http://localhost:8080/api/contacts
```

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "telefone": "9999-9999",
    "email": "joao@email.com"
  },
  {
    "id": 2,
    "nome": "Maria Santos",
    "telefone": "8888-8888",
    "email": "maria@email.com"
  }
]
```

### 3. Buscar contato pelo ID (GET)

**Requisição:**
```bash
curl http://localhost:8080/api/contacts/1
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "telefone": "9999-9999",
  "email": "joao@email.com"
}
```

### 4. Buscar contatos pelo nome (GET)

**Requisição:**
```bash
curl http://localhost:8080/api/contacts/search?name=João
```

**Resposta (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "telefone": "9999-9999",
    "email": "joao@email.com"
  }
]
```

### 5. Atualizar completamente um contato (PUT)

**Requisição:**
```bash
curl -X PUT http://localhost:8080/api/contacts/1 \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "nome": "João Silva Atualizado",
    "telefone": "7777-7777",
    "email": "joao.novo@email.com"
  }'
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva Atualizado",
  "telefone": "7777-7777",
  "email": "joao.novo@email.com"
}
```

### 6. Atualizar parcialmente um contato (PATCH)

**Requisição:**
```bash
curl -X PATCH http://localhost:8080/api/contacts/1 \
  -H "Content-Type: application/json" \
  -d '{
    "email": "novoemail@email.com"
  }'
```

**Resposta (200 OK):**
```json
{
  "id": 1,
  "nome": "João Silva",
  "telefone": "9999-9999",
  "email": "novoemail@email.com"
}
```

### 7. Deletar um contato (DELETE)

**Requisição:**
```bash
curl -X DELETE http://localhost:8080/api/contacts/1
```

**Resposta (204 No Content):**
```
(sem corpo)
```

## 🔍 Convenções REST Implementadas

### Modelo de Maturidade de Richardson

Este projeto implementa **Nível 2** do modelo de maturidade:

- ✅ **Recursos**: URLs representam recursos (`/api/contacts`)
- ✅ **Métodos HTTP**: Uso correto dos verbos HTTP (GET, POST, PUT, PATCH, DELETE)
- ✅ **Códigos de Status HTTP**: Respostas apropriadas (200, 201, 204, 404)

### Diferença entre PUT e PATCH

- **PUT**: Atualiza **completamente** o recurso. Todos os campos devem ser enviados.
- **PATCH**: Atualiza **parcialmente** o recurso. Apenas os campos desejados são enviados.

## 📚 Exercícios e Desafios

Este projeto contém a implementação completa dos exercícios e desafios:

### 📂 Estrutura de Exercícios

```
exercicios/
├── exercicio-1/              # ✅ Endpoint GET para buscar por nome
├── exercicio-2/              # ✅ Método PATCH para atualização parcial
└── exercicio-3/              # ✅ Respostas teóricas REST vs SOAP

desafios/
├── desafio-1/                # ✅ Entidade Address e relacionamento
└── desafio-2/                # ✅ Melhorias de validação e tratamento de erros
```

Para mais detalhes, consulte o arquivo `README_EXERCICIOS.md`.

## 🧪 Testando a API

### Usando cURL

Todos os exemplos acima podem ser testados com cURL.

### Usando Postman ou Insomnia

1. Importe a coleção de requisições
2. Configure a URL base: `http://localhost:8080`
3. Teste cada endpoint

### Usando o Console H2

1. Acesse: http://localhost:8080/h2-console
2. JDBC URL: `jdbc:h2:mem:contactdb`
3. Usuário: `sa`
4. Senha: (deixe em branco)
5. Execute queries SQL para verificar os dados

## 📚 Conceitos Aprendidos

- ✅ O que é uma API REST
- ✅ Convenções REST e métodos HTTP
- ✅ Diferença entre PUT e PATCH
- ✅ Estrutura de um projeto Spring Boot
- ✅ Entidades JPA e Repositories
- ✅ Controllers REST
- ✅ Tratamento de erros HTTP

## 🎓 Próximos Passos

Os próximos tópicos incluem:

- 🔹 Validações e Tratamento de Erros mais robustos (Desafio 2)
- 🔹 Persistência com banco de dados real (MySQL, PostgreSQL)
- 🔹 Autenticação e Segurança (OAuth, JWT)
- 🔹 Documentação da API (Swagger/OpenAPI)
- 🔹 Testes automatizados

## 📖 Referências

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [REST API Tutorial](https://restfulapi.net/)

---

**Bons estudos! 🛠🔥**
