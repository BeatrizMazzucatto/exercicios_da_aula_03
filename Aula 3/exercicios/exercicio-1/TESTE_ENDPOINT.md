# Como Testar o Exercício 1

## Endpoint Criado
```
GET /api/contacts/search?name={nome}
```

## Exemplos de Teste

### 1. Buscar por "João"
```bash
curl -X GET "http://localhost:8080/api/contacts/search?name=João"
```

**Resultado esperado:**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "telefone": "9999-9999",
    "email": "joao@email.com"
  },
  {
    "id": 3,
    "nome": "João Pedro",
    "telefone": "7777-7777",
    "email": "joao.pedro@email.com"
  },
  {
    "id": 5,
    "nome": "Carlos João",
    "telefone": "5555-5555",
    "email": "carlos@email.com"
  }
]
```

### 2. Buscar por "Maria"
```bash
curl -X GET "http://localhost:8080/api/contacts/search?name=Maria"
```

**Resultado esperado:**
```json
[
  {
    "id": 2,
    "nome": "Maria Santos",
    "telefone": "8888-8888",
    "email": "maria@email.com"
  }
]
```

### 3. Buscar por nome inexistente
```bash
curl -X GET "http://localhost:8080/api/contacts/search?name=Pedro"
```

**Resultado esperado:**
```json
[]
```

## Testando no Postman

1. **Método:** GET
2. **URL:** `http://localhost:8080/api/contacts/search`
3. **Parâmetros:** 
   - Key: `name`
   - Value: `João` (ou qualquer nome para testar)

## Como Executar a Aplicação

1. Navegue até a pasta do exercício:
   ```bash
   cd exercicio-1
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
