# Exercício 1 - Criando um Novo Endpoint GET

## Descrição
Crie um novo endpoint GET em **ContactController** que permita buscar contatos pelo nome.

## Requisitos
- O método deve receber o nome como um **parâmetro de URL** (`/api/contacts/search?name=João`)
- O método deve retornar uma lista de contatos que correspondam ao nome fornecido
- Caso nenhum contato seja encontrado, retorne uma **lista vazia**

## Dicas
- Você pode precisar modificar a interface **ContactRepository** para adicionar um método de busca personalizada

## Como testar
Use Postman, Insomnia ou cURL para testar o endpoint:
```
GET /api/contacts/search?name=João
```
