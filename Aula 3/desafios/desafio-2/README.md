# Desafio 2 - Melhorando a Validação dos Dados

## Descrição
Atualmente, nossa API aceita qualquer valor ao cadastrar contatos. Precisamos garantir que os dados sejam válidos antes de inserir no banco de dados.

## Requisitos

### 1. Adicionar validações à entidade `Contact`, usando a anotação `@Valid`

### 2. Implementar regras como:
- O campo `nome` não pode estar vazio
- O campo `email` deve ter um formato válido (`@Email`)
- O campo `telefone` deve ter entre 8 e 15 caracteres

### 3. Exemplo de resposta para entrada inválida:
Se tentarmos criar um contato com um telefone inválido:
```json
{
  "nome": "Maria",
  "telefone": "123",
  "email": "maria@email.com"
}
```

A API deve retornar HTTP 400 e uma mensagem de erro:
```json
{
  "erro": "O telefone deve ter entre 8 e 15 caracteres"
}
```

## Como testar
Use Postman, Insomnia ou cURL para testar as validações com dados inválidos
