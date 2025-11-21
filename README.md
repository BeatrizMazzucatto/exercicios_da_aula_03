# Exercícios da Aula 03 - API REST com Spring Boot

Este projeto contém exercícios práticos e desafios sobre desenvolvimento de APIs REST com Spring Boot, demonstrando operações CRUD, validações, relacionamentos e boas práticas.

## 📋 Descrição

O projeto implementa uma API REST completa para gerenciamento de contatos, explorando conceitos fundamentais de REST, Spring Boot, JPA, validações e tratamento de exceções.

## 🗂️ Estrutura do Projeto

```
exercicios_da_aula_03/
├── Aula 3/                          # Projeto principal completo
│   ├── src/main/java/com/example/contactapi/
│   │   ├── ContactApiApplication.java     # Classe principal
│   │   ├── controller/
│   │   │   └── ContactController.java     # Controller REST
│   │   ├── model/
│   │   │   └── Contact.java               # Entidade JPA
│   │   ├── repository/
│   │   │   └── ContactRepository.java     # Interface Repository
│   │   └── service/
│   │       └── ContactService.java        # Camada de serviço
│   ├── src/main/resources/
│   │   └── application.properties         # Configurações
│   ├── pom.xml                            # Dependências Maven
│   ├── README.md                          # Documentação principal
│   └── README_EXERCICIOS.md               # Guia dos exercícios
│
├── exercicios/                      # Exercícios práticos
│   ├── exercicio-1/                 # Busca por nome
│   ├── exercicio-2/                 # Método PATCH
│   └── exercicio-3/                 # Questões teóricas
│
└── desafios/                        # Desafios avançados
    ├── desafio-1/                   # Relacionamento Address
    └── desafio-2/                   # Validações e erros
```

## 🎯 Exercícios Implementados

### Exercício 1) Endpoint GET para Buscar por Nome
* **Abordagem**: Criar endpoint com parâmetros de busca
* **Método**: `GET /api/contacts/search?name=João`
* **Repository**: `findByNomeContainingIgnoreCase(String nome)`
* **Objetivo**: Buscar contatos cujo nome contenha o termo pesquisado

### Exercício 2) Implementar Método PATCH
* **Abordagem**: Atualização parcial de recursos
* **Método**: `PATCH /api/contacts/{id}`
* **Diferencial**: Atualiza apenas campos enviados, mantém os demais
* **Validação**: Verifica email único ao atualizar
* **Objetivo**: Demonstrar diferença entre PUT (completo) e PATCH (parcial)

### Exercício 3) Questões Teóricas
* **Tópico 1**: Diferenças entre REST e SOAP
* **Tópico 2**: Cenários de uso do SOAP
* **Tópico 3**: Vantagens e desvantagens do REST
* **Tópico 4**: WS-Security vs Segurança REST
* **Tópico 5**: Modelo de Maturidade de Richardson
* **Tópico 6**: GraphQL e sua relação com REST
* **Formato**: Respostas dissertativas em arquivo de texto

## 🏆 Desafios Implementados

### Desafio 1) Entidade Address e Relacionamento
* **Entidade**: `Address` com campos rua, cidade, estado, cep
* **Relacionamento**: `@OneToMany` em Contact, `@ManyToOne` em Address
* **Controller**: `AddressController` com CRUD completo
* **Endpoints Adicionais**:
  - `GET /api/contacts/{id}/addresses` - Lista endereços do contato
  - `GET /api/addresses/search/city?cidade=São Paulo` - Busca por cidade
  - `GET /api/addresses/search/state?estado=SP` - Busca por estado
  - `GET /api/addresses/search/zipcode?cep=01234-567` - Busca por CEP
* **Repository**: Métodos de busca customizados com JPQL

### Desafio 2) Validações e Tratamento de Erros
* **Bean Validation**: Anotações `@NotBlank`, `@Email`, `@Size`, `@Pattern`
* **Validações Implementadas**:
  - Nome: entre 2 e 100 caracteres
  - Telefone: entre 8 e 15 caracteres
  - Email: formato válido
* **GlobalExceptionHandler**: Centraliza tratamento de exceções
* **ValidationErrorResponse**: Resposta padronizada de erro
* **HTTP Status**: 400 para validação, 404 para não encontrado, 409 para conflito
* **Exemplo de Resposta de Erro**:
  ```json
  {
    "erro": "O telefone deve ter entre 8 e 15 caracteres"
  }
  ```

## 🚀 Como Executar

### Pré-requisitos
* Java JDK 17 ou superior
* Maven 3.6 ou superior

### Compilação e Execução

```bash
# Projeto principal
cd "Aula 3"
mvn spring-boot:run

# Ou use os scripts:
# Linux/Mac:
./run.sh

# Windows:
run.bat
```

### Executar Exercícios/Desafios Individuais

```bash
# Exemplo: Desafio 1
cd "Aula 3/desafios/desafio-1"
mvn spring-boot:run
```

### Acessos

* **API**: http://localhost:8080
* **Console H2**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:contactdb`
  - Username: `sa`
  - Password: (vazio)

## 📊 Exemplo de Uso

### Criar um Contato (POST)

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

### Buscar por Nome (GET)

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

### Atualizar Parcialmente (PATCH)

```bash
curl -X PATCH http://localhost:8080/api/contacts/1 \
  -H "Content-Type: application/json" \
  -d '{"email": "novoemail@email.com"}'
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

### Criar Endereço (Desafio 1)

```bash
curl -X POST http://localhost:8080/api/addresses \
  -H "Content-Type: application/json" \
  -d '{
    "rua": "Rua das Flores, 123",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01234-567",
    "contact": {"id": 1}
  }'
```

### Validação com Erro (Desafio 2)

```bash
curl -X POST http://localhost:8080/api/contacts \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria",
    "telefone": "123",
    "email": "maria@email.com"
  }'
```

**Resposta (400 Bad Request):**
```json
{
  "erro": "O telefone deve ter entre 8 e 15 caracteres"
}
```

## 🔍 Conceitos Abordados

* **REST API**: Arquitetura RESTful, recursos, URIs
* **HTTP Methods**: GET, POST, PUT, PATCH, DELETE
* **HTTP Status Codes**: 200, 201, 204, 400, 404, 409
* **Spring Boot**: @RestController, @RequestMapping, @Autowired
* **JPA/Hibernate**: @Entity, @OneToMany, @ManyToOne, relacionamentos bidirecionais
* **Spring Data JPA**: JpaRepository, métodos de consulta derivados
* **Bean Validation**: @Valid, @NotBlank, @Email, @Size
* **Exception Handling**: @RestControllerAdvice, @ExceptionHandler
* **Service Layer**: Separação de responsabilidades
* **Repository Pattern**: Abstração de acesso a dados

## 📚 Aprendizados

Este projeto demonstra como:
* Construir APIs REST seguindo convenções e boas práticas
* Utilizar o modelo de maturidade de Richardson (Nível 2)
* Implementar operações CRUD completas
* Diferenciar PUT (atualização completa) de PATCH (atualização parcial)
* Criar relacionamentos bidirecionais entre entidades
* Validar dados de entrada com Bean Validation
* Tratar exceções de forma centralizada e consistente
* Estruturar aplicações em camadas (Controller, Service, Repository)
* Retornar códigos HTTP apropriados para cada operação

## 📋 Endpoints da API

### Contatos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/contacts` | Lista todos os contatos |
| GET | `/api/contacts/{id}` | Busca contato por ID |
| GET | `/api/contacts/search?name=João` | Busca contatos por nome |
| POST | `/api/contacts` | Cria novo contato |
| PUT | `/api/contacts/{id}` | Atualiza completamente |
| PATCH | `/api/contacts/{id}` | Atualiza parcialmente |
| DELETE | `/api/contacts/{id}` | Remove contato |

### Endereços (Desafio 1)
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/contacts/{id}/addresses` | Lista endereços do contato |
| GET | `/api/addresses` | Lista todos os endereços |
| GET | `/api/addresses/{id}` | Busca endereço por ID |
| GET | `/api/addresses/search/city?cidade=SP` | Busca por cidade |
| GET | `/api/addresses/search/state?estado=SP` | Busca por estado |
| GET | `/api/addresses/search/zipcode?cep=01234-567` | Busca por CEP |
| POST | `/api/addresses` | Cria novo endereço |
| PUT | `/api/addresses/{id}` | Atualiza endereço |
| DELETE | `/api/addresses/{id}` | Remove endereço |

## 👨‍💻 Tecnologias

* **Java 17**
* **Spring Boot 3.2.0**
* **Spring Data JPA**
* **H2 Database** (in-memory)
* **Jakarta Validation**
* **Maven**

## 📖 Documentação Adicional

* **README Principal**: Documentação completa do projeto base
* **README Exercícios**: Guia detalhado de todos os exercícios
* **Arquivos de Teste**: Cada exercício/desafio possui instruções de teste
  - `TESTE_ENDPOINT.md` (Exercício 1)
  - `TESTE_PATCH.md` (Exercício 2)
  - `TESTE_ENDPOINTS.md` (Desafio 1)
  - `TESTE_VALIDACOES.md` (Desafio 2)

---

**Nota**: O projeto utiliza H2 Database em memória, portanto os dados são perdidos ao reiniciar a aplicação. Para persistência, configure MySQL ou PostgreSQL no `application.properties`.
