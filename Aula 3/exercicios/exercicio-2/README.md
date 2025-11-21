# Exercício 2 - Implementando um Método PATCH

## Descrição
Adicione um novo método PATCH à API, permitindo que o usuário atualize apenas um ou mais campos de um contato, sem precisar enviar todos os dados.

## Requisitos
- O método deve permitir alterar apenas os campos enviados na requisição
- Se o campo não for enviado, o valor original deve ser mantido
- Retorne o contato atualizado após a alteração
- Caso o ID fornecido não exista, retorne um erro 404

## Exemplo de chamada
```
PATCH /api/contacts/1
{
  "email": "novoemail@email.com"
}
```

## Saída esperada (JSON)
```json
{
  "id": 1,
  "nome": "João Silva",
  "telefone": "9999-9999",
  "email": "novoemail@email.com"
}
```

## Como testar
Use Postman, Insomnia ou cURL para testar o endpoint PATCH
