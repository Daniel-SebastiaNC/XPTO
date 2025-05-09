# API Documentation

## ClientController

### Description

O `ClientController` é responsável por gerenciar as operações relacionadas a clientes, como a criação de novos clientes, a atualização de seus endereços e a geração de relatórios por cliente.

### Endpoints

#### 1. **Create Client**
- **Método**: `POST`
- **URL**: `/v1/client/create`
- **Descrição**: Cria um novo cliente na aplicação.
- **Request Body**:
    ```json
    {
      "name": "João Silva",
      "cpfCnpj": "12345678900",
      "address": {
        "street": "Rua Exemplo",
        "number": 123,
        "complement": "Apto 101",
        "district": "Centro",
        "city": "Cidade Exemplo",
        "state": "SP",
        "cep": "12345678"
      },
      "accounts": [1, 2],
      "taxIdentifiers": "PF",
      "telephone": "12345678900"
    }
    ```
- **Validações**:
    - `name`: Não pode ser nulo.
    - `cpfCnpj`: Deve ter entre 11 e 14 caracteres, não pode ser nulo.
    - `address`: Não pode ser nulo e deve conter todos os campos obrigatórios (rua, número, complemento, bairro, cidade, estado, CEP).
    - `accounts`: Não pode ser nulo ou vazio.
    - `taxIdentifiers`: Deve ser "PJ" ou "PF", não pode ser nulo.
    - `telephone`: Deve ter entre 16 e 17 caracteres, não pode ser nulo.
- **Response**:
    ```json
    {
      "id": 1,
      "name": "João Silva",
      "cpfCnpj": "12345678900",
      "address": {
        "street": "Rua Exemplo",
        "number": 123,
        "complement": "Apto 101",
        "district": "Centro",
        "city": "Cidade Exemplo",
        "state": "SP",
        "cep": "12345678"
      },
      "taxIdentifiers": "PF",
      "telephone": "12345678900",
      "createdAt": "2025-05-09",
      "balanceTotal": 0.00
    }
    ```

#### 2. **Update Address**
- **Método**: `PATCH`
- **URL**: `/v1/client/update-address/{id}`
- **Descrição**: Atualiza o endereço de um cliente existente.
- **Request Body**:
    ```json
    {
      "street": "Nova Rua Exemplo",
      "number": 456,
      "complement": "Apto 102",
      "district": "Centro",
      "city": "Nova Cidade Exemplo",
      "state": "RJ",
      "cep": "87654321"
    }
    ```
- **Response**:
    ```json
    {
      "street": "Nova Rua Exemplo",
      "number": 456,
      "complement": "Apto 102",
      "district": "Centro",
      "city": "Nova Cidade Exemplo",
      "state": "RJ",
      "cep": "87654321"
    }
    ```

#### 3. **Get Client Report**
- **Método**: `GET`
- **URL**: `/v1/client/report/{id}`
- **Descrição**: Gera um relatório das movimentações financeiras de um cliente específico.
- **Response**:
    ```json
    {
      "clientId": 1,
      "movements": [
        {
          "id": 1,
          "value": 100.00,
          "createdAt": "2025-05-09",
          "creditDebitIndicator": "DEBIT"
        },
        {
          "id": 2,
          "value": 200.00,
          "createdAt": "2025-05-10",
          "creditDebitIndicator": "CREDIT"
        }
      ],
      "total": 300.00
    }
    ```

---

## AccountController

### Description

O `AccountController` é responsável por gerenciar as operações relacionadas a contas bancárias, como a criação de contas e a realização de movimentações bancárias.

### Endpoints

#### 1. **Create Bank Account**
- **Método**: `POST`
- **URL**: `/v1/account/create`
- **Descrição**: Cria uma nova conta bancária para o cliente.
- **Response**:
    ```json
    {
      "id": 1,
      "balance": 0.00,
      "client": {
        "id": 1,
        "name": "João Silva",
        "cpfCnpj": "12345678900"
      }
    }
    ```

#### 2. **Make Bank Movement**
- **Método**: `POST`
- **URL**: `/v1/account/movement/{id}`
- **Descrição**: Realiza uma movimentação bancária (crédito ou débito) na conta do cliente.
- **Request Body**:
    ```json
    {
      "value": 150.00,
      "creditDebitIndicator": "CREDIT"
    }
    ```
- **Validações**:
    - `value`: O valor da movimentação deve ser positivo e não pode ser nulo.
    - `creditDebitIndicator`: Deve ser "CREDIT" ou "DEBIT" e não pode ser nulo.
- **Response**:
    ```json
    {
      "id": 1,
      "value": 150.00,
      "createdAt": "2025-05-09",
      "creditDebitIndicator": "CREDIT",
      "account": {
        "id": 1,
        "balance": 150.00
      }
    }
    ```

---

## Considerações

- **Validations**: Todos os endpoints que aceitam dados de entrada possuem validações de campo para garantir que as informações fornecidas estejam no formato correto.
- **Security**: Os endpoints podem estar protegidos por mecanismos de segurança, como autenticação e autorização, dependendo da configuração da aplicação.
- **Error Handling**: Em caso de erro, a API retorna respostas de erro com códigos HTTP apropriados (por exemplo, 400 para erro de validação, 404 para recurso não encontrado, etc.).
