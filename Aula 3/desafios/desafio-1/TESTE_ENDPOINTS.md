# Como Testar o Desafio 1 - Endpoints de Endereços

## Endpoints Criados

### 1. AddressController - Endpoints Gerais
- `GET /api/addresses` - Listar todos os endereços
- `GET /api/addresses/{id}` - Buscar endereço por ID
- `POST /api/addresses` - Criar novo endereço
- `PUT /api/addresses/{id}` - Atualizar endereço
- `DELETE /api/addresses/{id}` - Deletar endereço

### 2. ContactController - Endpoint Específico
- `GET /api/contacts/{id}/addresses` - Listar endereços de um contato

## Exemplos de Teste

### 1. Listar todos os endereços
```bash
curl -X GET "http://localhost:8080/api/addresses"
```

### 2. Listar endereços de um contato específico
```bash
curl -X GET "http://localhost:8080/api/contacts/1/addresses"
```

**Resultado esperado:**
```json
[
  {
    "id": 1,
    "rua": "Rua das Flores, 123",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01234-567",
    "contact": {
      "id": 1,
      "nome": "João Silva",
      "telefone": "9999-9999",
      "email": "joao@email.com"
    }
  },
  {
    "id": 2,
    "rua": "Avenida Paulista, 1000",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01310-100",
    "contact": {
      "id": 1,
      "nome": "João Silva",
      "telefone": "9999-9999",
      "email": "joao@email.com"
    }
  }
]
```

### 3. Criar um novo endereço
```bash
curl -X POST "http://localhost:8080/api/addresses" \
  -H "Content-Type: application/json" \
  -d '{
    "rua": "Rua Nova, 999",
    "cidade": "Brasília",
    "estado": "DF",
    "cep": "70000-000",
    "contact": {"id": 1}
  }'
```

### 4. Buscar endereços por cidade
```bash
curl -X GET "http://localhost:8080/api/addresses/search/city?cidade=São Paulo"
```

### 5. Buscar endereços por estado
```bash
curl -X GET "http://localhost:8080/api/addresses/search/state?estado=SP"
```

### 6. Buscar endereços por CEP
```bash
curl -X GET "http://localhost:8080/api/addresses/search/zipcode?cep=01234-567"
```

## Testando no Postman

### Exemplo: Criar novo endereço

1. **Método:** POST
2. **URL:** `http://localhost:8080/api/addresses`
3. **Headers:**
   - Key: `Content-Type`
   - Value: `application/json`
4. **Body (raw JSON):**
   ```json
   {
     "rua": "Rua Teste, 123",
     "cidade": "São Paulo",
     "estado": "SP",
     "cep": "01234-567",
     "contact": {"id": 1}
   }
   ```

### Exemplo: Listar endereços de um contato

1. **Método:** GET
2. **URL:** `http://localhost:8080/api/contacts/1/addresses`

## Como Executar a Aplicação

1. Navegue até a pasta do desafio:
   ```bash
   cd desafio-1
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

## Verificando os Resultados

### Listar todos os contatos com seus endereços:
```bash
curl -X GET "http://localhost:8080/api/contacts"
```

### Listar todos os endereços:
```bash
curl -X GET "http://localhost:8080/api/addresses"
```

### Testar relacionamento bidirecional:
1. Crie um novo endereço para um contato existente
2. Verifique se o endereço aparece na lista de endereços do contato
3. Delete um endereço e verifique se foi removido da lista do contato
