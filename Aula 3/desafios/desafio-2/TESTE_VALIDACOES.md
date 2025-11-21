# Como Testar o Desafio 2 - Validações de Dados

## Validações Implementadas

### 1. Campo `nome`
- **Não pode estar vazio** (`@NotBlank`)
- **Deve ter entre 2 e 100 caracteres** (`@Size`)

### 2. Campo `telefone`
- **Não pode estar vazio** (`@NotBlank`)
- **Deve ter entre 8 e 15 caracteres** (`@Size`)
- **Deve conter apenas números, hífens, parênteses, espaços ou símbolo +** (`@Pattern`)

### 3. Campo `email`
- **Não pode estar vazio** (`@NotBlank`)
- **Deve ter formato válido** (`@Email`)

## Exemplos de Teste com Dados Inválidos

### 1. Teste com nome vazio
```bash
curl -X POST "http://localhost:8080/api/contacts" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "",
    "telefone": "9999-9999",
    "email": "teste@email.com"
  }'
```

**Resultado esperado (HTTP 400):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Dados de entrada inválidos",
  "fieldErrors": [
    {
      "field": "nome",
      "rejectedValue": "",
      "message": "O nome não pode estar vazio"
    }
  ],
  "path": "/api/contacts"
}
```

### 2. Teste com telefone muito curto (exemplo do desafio)
```bash
curl -X POST "http://localhost:8080/api/contacts" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria",
    "telefone": "123",
    "email": "maria@email.com"
  }'
```

**Resultado esperado (HTTP 400):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Dados de entrada inválidos",
  "fieldErrors": [
    {
      "field": "telefone",
      "rejectedValue": "123",
      "message": "O telefone deve ter entre 8 e 15 caracteres"
    }
  ],
  "path": "/api/contacts"
}
```

### 3. Teste com email inválido
```bash
curl -X POST "http://localhost:8080/api/contacts" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Pedro",
    "telefone": "9999-9999",
    "email": "email-invalido"
  }'
```

**Resultado esperado (HTTP 400):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Dados de entrada inválidos",
  "fieldErrors": [
    {
      "field": "email",
      "rejectedValue": "email-invalido",
      "message": "O email deve ter um formato válido"
    }
  ],
  "path": "/api/contacts"
}
```

### 4. Teste com múltiplos erros
```bash
curl -X POST "http://localhost:8080/api/contacts" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "A",
    "telefone": "123",
    "email": "email-invalido"
  }'
```

**Resultado esperado (HTTP 400):**
```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Dados de entrada inválidos",
  "fieldErrors": [
    {
      "field": "nome",
      "rejectedValue": "A",
      "message": "O nome deve ter entre 2 e 100 caracteres"
    },
    {
      "field": "telefone",
      "rejectedValue": "123",
      "message": "O telefone deve ter entre 8 e 15 caracteres"
    },
    {
      "field": "email",
      "rejectedValue": "email-invalido",
      "message": "O email deve ter um formato válido"
    }
  ],
  "path": "/api/contacts"
}
```

### 5. Teste com dados válidos
```bash
curl -X POST "http://localhost:8080/api/contacts" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Silva",
    "telefone": "9999-9999",
    "email": "maria@email.com"
  }'
```

**Resultado esperado (HTTP 201):**
```json
{
  "id": 6,
  "nome": "Maria Silva",
  "telefone": "9999-9999",
  "email": "maria@email.com"
}
```

## Testando no Postman

### Exemplo: Criar contato com dados inválidos

1. **Método:** POST
2. **URL:** `http://localhost:8080/api/contacts`
3. **Headers:**
   - Key: `Content-Type`
   - Value: `application/json`
4. **Body (raw JSON):**
   ```json
   {
     "nome": "",
     "telefone": "123",
     "email": "email-invalido"
   }
   ```

## Testando Validações no PUT

```bash
curl -X PUT "http://localhost:8080/api/contacts/1" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João",
    "telefone": "123",
    "email": "joao@email.com"
  }'
```

## Como Executar a Aplicação

1. Navegue até a pasta do desafio:
   ```bash
   cd desafio-2
   ```

2. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

3. A aplicação estará disponível em: `http://localhost:8080`

4. Console H2 (para ver os dados): `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: `password`

## Validações Implementadas

### Anotações de Validação Utilizadas:
- `@NotBlank`: Campo não pode ser null, vazio ou apenas espaços
- `@Size`: Define tamanho mínimo e máximo
- `@Email`: Valida formato de email
- `@Pattern`: Valida formato usando regex
- `@Valid`: Ativa as validações no controller

### Tratamento de Exceções:
- `GlobalExceptionHandler`: Centraliza o tratamento de exceções
- `ValidationErrorResponse`: Padroniza respostas de erro
- Retorna HTTP 400 (Bad Request) para erros de validação
- Inclui detalhes específicos de cada campo com erro
