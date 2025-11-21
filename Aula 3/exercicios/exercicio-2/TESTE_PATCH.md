# Como Testar o Exercício 2 - Método PATCH

## Endpoint Criado
```
PATCH /api/contacts/{id}
```

## Exemplos de Teste

### 1. Atualizar apenas o email do contato ID 1
```bash
curl -X PATCH "http://localhost:8080/api/contacts/1" \
  -H "Content-Type: application/json" \
  -d '{"email": "novoemail@email.com"}'
```

**Resultado esperado:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "telefone": "9999-9999",
  "email": "novoemail@email.com"
}
```

### 2. Atualizar apenas o telefone do contato ID 2
```bash
curl -X PATCH "http://localhost:8080/api/contacts/2" \
  -H "Content-Type: application/json" \
  -d '{"telefone": "1111-2222"}'
```

**Resultado esperado:**
```json
{
  "id": 2,
  "nome": "Maria Santos",
  "telefone": "1111-2222",
  "email": "maria@email.com"
}
```

### 3. Atualizar nome e telefone do contato ID 3
```bash
curl -X PATCH "http://localhost:8080/api/contacts/3" \
  -H "Content-Type: application/json" \
  -d '{"nome": "Pedro Silva", "telefone": "3333-4444"}'
```

**Resultado esperado:**
```json
{
  "id": 3,
  "nome": "Pedro Silva",
  "telefone": "3333-4444",
  "email": "pedro@email.com"
}
```

### 4. Tentar atualizar contato inexistente (ID 999)
```bash
curl -X PATCH "http://localhost:8080/api/contacts/999" \
  -H "Content-Type: application/json" \
  -d '{"email": "teste@email.com"}'
```

**Resultado esperado:**
```
HTTP 404 Not Found
```

### 5. Tentar usar email já existente
```bash
curl -X PATCH "http://localhost:8080/api/contacts/1" \
  -H "Content-Type: application/json" \
  -d '{"email": "maria@email.com"}'
```

**Resultado esperado:**
```
HTTP 409 Conflict
```

## Testando no Postman

1. **Método:** PATCH
2. **URL:** `http://localhost:8080/api/contacts/1`
3. **Headers:**
   - Key: `Content-Type`
   - Value: `application/json`
4. **Body (raw JSON):**
   ```json
   {
     "email": "novoemail@email.com"
   }
   ```

## Como Executar a Aplicação

1. Navegue até a pasta do exercício:
   ```bash
   cd exercicio-2
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

Após executar os testes PATCH, você pode verificar as alterações:

1. **Listar todos os contatos:**
   ```bash
   curl -X GET "http://localhost:8080/api/contacts"
   ```

2. **Buscar contato específico:**
   ```bash
   curl -X GET "http://localhost:8080/api/contacts/1"
   ```
