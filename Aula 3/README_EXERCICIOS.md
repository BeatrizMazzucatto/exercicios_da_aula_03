# 📚 Exercícios e Desafios

Este documento organiza todos os exercícios e desafios em pastas separadas.

## 📂 Estrutura

```
Aula 3/
├── src/                          # Projeto base completo
├── exercicios/
│   ├── exercicio-1/              # ✅ Endpoint GET para buscar por nome
│   ├── exercicio-2/              # ✅ Método PATCH para atualização parcial
│   └── exercicio-3/              # ✅ Respostas teóricas REST vs SOAP
└── desafios/
    ├── desafio-1/                # ✅ Entidade Address e relacionamento
    └── desafio-2/                # ✅ Melhorias de validação e tratamento de erros
```

## ✅ Status dos Exercícios

### Exercícios Práticos

#### 1️⃣ Exercício 1 - Endpoint GET para Buscar por Nome
- **Status:** ✅ Implementado
- **Localização:** `exercicios/exercicio-1/`
- **Descrição:** Endpoint GET `/api/contacts/search?name=João` que busca contatos pelo nome
- **Documentação:** Veja `exercicios/exercicio-1/README.md`

#### 2️⃣ Exercício 2 - Método PATCH
- **Status:** ✅ Implementado
- **Localização:** `exercicios/exercicio-2/`
- **Descrição:** Método PATCH para atualização parcial de contatos
- **Documentação:** Veja `exercicios/exercicio-2/README.md`

### Exercício Teórico

#### 3️⃣ Exercício 3 - REST vs SOAP
- **Status:** ✅ Completo
- **Localização:** `exercicios/exercicio-3/RESPOSTAS.md`
- **Conteúdo:**
  - Diferenças entre REST e SOAP
  - Cenários de uso do SOAP
  - Vantagens e desvantagens
  - WS-Security vs Segurança REST
  - Modelo de Maturidade de Richardson
  - GraphQL e relação com REST

## 🎯 Desafios

### 1️⃣ Desafio 1 - Entidade Address e Relacionamento
- **Status:** ✅ Implementado
- **Localização:** `desafios/desafio-1/`
- **Funcionalidades:**
  - ✅ Entidade `Address` criada
  - ✅ Relação bidirecional com `Contact`
  - ✅ `AddressRepository` criado
  - ✅ `AddressService` criado
  - ✅ `AddressController` criado
  - ✅ Endpoint `GET /api/contacts/{id}/addresses`
  - ✅ CRUD completo de endereços
- **Documentação:** Veja `desafios/desafio-1/README.md`

### 2️⃣ Desafio 2 - Melhorias de Validação
- **Status:** ✅ Implementado
- **Localização:** `desafios/desafio-2/`
- **Funcionalidades:**
  - ✅ Validações na entidade `Contact`
  - ✅ `GlobalExceptionHandler` para tratamento de erros
  - ✅ `ValidationErrorResponse` para respostas estruturadas
  - ✅ Mensagens de erro em JSON
  - ✅ HTTP 400 para erros de validação
- **Documentação:** Veja `desafios/desafio-2/README.md`

## 🚀 Como Usar

### Executar o Projeto Base

```bash
cd "Aula 3"
mvn spring-boot:run
```

### Executar Exercícios e Desafios

Cada pasta (`exercicios/` e `desafios/`) contém versões incrementais do projeto com as funcionalidades específicas implementadas.

Para testar um exercício ou desafio específico:

1. Navegue até a pasta desejada:
   ```bash
   cd desafios/desafio-1
   ```

2. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

3. Teste os endpoints conforme documentado no README de cada exercício/desafio.

## 📝 Notas Importantes

### Projeto Base vs Exercícios/Desafios

- **Projeto Base** (`src/`): Contém a implementação completa com todos os exercícios e desafios já integrados.
- **Pastas Separadas**: Cada exercício/desafio tem sua própria pasta com o código específico implementado.

### Documentação

Cada exercício e desafio possui seu próprio README com:
- ✅ Requisitos
- ✅ Implementação detalhada
- ✅ Exemplos de uso
- ✅ Testes com cURL
- ✅ Observações importantes

## 🧪 Testando

### Ferramentas Recomendadas

- **Postman**: Para testar endpoints REST
- **Insomnia**: Alternativa ao Postman
- **cURL**: Para testes via linha de comando
- **H2 Console**: Para verificar dados no banco (`http://localhost:8080/h2-console`)

### Endpoints Base

- `GET /api/contacts` - Lista todos os contatos
- `GET /api/contacts/{id}` - Busca contato pelo ID
- `GET /api/contacts/search?name=João` - Busca contatos pelo nome
- `POST /api/contacts` - Cria novo contato
- `PUT /api/contacts/{id}` - Atualiza contato completamente
- `PATCH /api/contacts/{id}` - Atualiza contato parcialmente
- `DELETE /api/contacts/{id}` - Deleta contato

### Endpoints do Desafio 1 (Address)

- `GET /api/contacts/{id}/addresses` - Lista endereços de um contato
- `GET /api/addresses/{id}` - Busca endereço pelo ID
- `POST /api/contacts/{id}/addresses` - Cria novo endereço
- `PUT /api/addresses/{id}` - Atualiza endereço
- `DELETE /api/addresses/{id}` - Deleta endereço

## ✅ Checklist de Entrega

### Exercícios Práticos (1 e 2)
- [x] Código implementado
- [x] Endpoints funcionando
- [x] Documentação completa
- [x] Exemplos de uso
- [x] Testes documentados

### Exercício Teórico (3)
- [x] Respostas completas
- [x] Formato .md (pode ser convertido para .txt ou .pdf)

### Desafios (1 e 2)
- [x] Funcionalidades implementadas
- [x] Código funcionando
- [x] Documentação completa
- [x] Testes documentados

## 📚 Referências

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [REST API Tutorial](https://restfulapi.net/)
- [Jakarta Bean Validation](https://beanvalidation.org/)

---

**Bons estudos! 🛠🔥**

