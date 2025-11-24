# 📚 Guia Completo: Como Usar os Endpoints GET

## 🎯 Índice
1. [Conceitos Básicos](#conceitos-básicos)
2. [GET sem Parâmetros (Paginado)](#get-sem-parâmetros-paginado)
3. [GET por ID](#get-por-id)
4. [Exemplos Práticos com cURL](#exemplos-práticos-com-curl)
5. [Exemplos com Postman](#exemplos-com-postman)

---

## Conceitos Básicos

Existem **2 tipos de GET endpoints** implementados:

| Tipo | Descrição | Exemplo |
|------|-----------|---------|
| **GET (Listar)** | Retorna lista paginada de recursos | `GET /api/users?page=0&size=10` |
| **GET (Por ID)** | Retorna um recurso específico pelo ID | `GET /api/users/{id}` |

---

## GET sem Parâmetros (Paginado)

### 📌 Sintaxe Geral
```
GET /api/{recurso}?page={número}&size={quantidade}&sort={campo},{direção}
```

### 📊 Parâmetros de Paginação

| Parâmetro | Tipo | Descrição | Exemplo |
|-----------|------|-----------|---------|
| `page` | int | Número da página (começa em 0) | `page=0` |
| `size` | int | Quantidade de itens por página | `size=10` |
| `sort` | string | Ordenação: `{campo},{asc/desc}` | `sort=id,desc` |

### ✅ Exemplo 1: Listar Usuários (padrão)
```bash
GET http://localhost:8080/api/users
```
**Resposta padrão (página 0, 20 itens):**
```json
{
  "content": [
    {
      "id": "550e8400-e29b-41d4-a716-446655440000",
      "name": "João Silva",
      "email": "joao@example.com",
      "createdAt": "2025-11-22T10:30:00"
    },
    {
      "id": "550e8400-e29b-41d4-a716-446655440001",
      "name": "Maria Santos",
      "email": "maria@example.com",
      "createdAt": "2025-11-22T11:15:00"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": []
  },
  "totalElements": 45,
  "totalPages": 3,
  "first": true,
  "last": false
}
```

### ✅ Exemplo 2: Listar com Paginação Customizada
```bash
GET http://localhost:8080/api/users?page=1&size=5
```
**Resposta (página 1, 5 itens por página):**
```json
{
  "content": [
    // 5 usuários da página 1
  ],
  "pageable": {
    "pageNumber": 1,
    "pageSize": 5
  },
  "totalElements": 45,
  "totalPages": 9,
  "first": false,
  "last": false
}
```

### ✅ Exemplo 3: Listar Ordenado
```bash
GET http://localhost:8080/api/users?page=0&size=10&sort=name,asc
```
**Ordena pelo nome (A-Z)**

```bash
GET http://localhost:8080/api/users?page=0&size=10&sort=createdAt,desc
```
**Ordena pela data (mais recentes primeiro)**

---

## GET por ID

### 📌 Sintaxe Geral
```
GET /api/{recurso}/{id}
```

### ✅ Exemplo: Buscar Usuário por ID
```bash
GET http://localhost:8080/api/users/550e8400-e29b-41d4-a716-446655440000
```

**Resposta:**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "João Silva",
  "email": "joao@example.com",
  "createdAt": "2025-11-22T10:30:00"
}
```

### ❌ Quando o ID não existe
```bash
GET http://localhost:8080/api/users/999
```

**Resposta (500 erro):**
```json
{
  "error": "Usuário não encontrado com id: 999"
}
```

---

## Exemplos Práticos com cURL

### 🔹 **USERS**

```bash
# Listar todos os usuários
curl -X GET "http://localhost:8080/api/users"

# Listar com paginação
curl -X GET "http://localhost:8080/api/users?page=0&size=5"

# Buscar usuário específico
curl -X GET "http://localhost:8080/api/users/550e8400-e29b-41d4-a716-446655440000"
```

### 🔹 **GROUPS**

```bash
# Listar todos os grupos
curl -X GET "http://localhost:8080/api/groups"

# Listar com ordenação
curl -X GET "http://localhost:8080/api/groups?sort=name,asc"

# Buscar grupo específico
curl -X GET "http://localhost:8080/api/groups/{groupId}"
```

### 🔹 **CATEGORIES**

```bash
# Listar todas as categorias
curl -X GET "http://localhost:8080/api/categories"

# Buscar categoria específica
curl -X GET "http://localhost:8080/api/categories/{categoryId}"
```

### 🔹 **PAYMENT SPLITS**

```bash
# Listar todos os payment splits
curl -X GET "http://localhost:8080/api/payment-splits"

# Buscar payment split específico
curl -X GET "http://localhost:8080/api/payment-splits/{paymentSplitId}"
```

### 🔹 **GROUP MEMBERS**

```bash
# Listar todos os membros
curl -X GET "http://localhost:8080/api/group-members"

# Buscar membro específico
curl -X GET "http://localhost:8080/api/group-members/{memberId}"
```

### 🔹 **AGREEMENTS**

```bash
# Listar todos os acordos
curl -X GET "http://localhost:8080/api/agreements"

# Buscar acordo específico
curl -X GET "http://localhost:8080/api/agreements/{agreementId}"
```

### 🔹 **AGREEMENT MEMBERS**

```bash
# Listar todos os membros de acordos
curl -X GET "http://localhost:8080/api/agreement-members"

# Buscar membro de acordo específico
curl -X GET "http://localhost:8080/api/agreement-members/{agreementMemberId}"
```

---

## Exemplos com Postman

### 📱 Setup no Postman

1. **Abra o Postman**
2. **Clique em "New" → "Request"**
3. **Configure assim:**

| Campo | Valor |
|-------|-------|
| Method | **GET** |
| URL | `http://localhost:8080/api/users` |
| Headers | `Content-Type: application/json` (opcional) |

### 📋 Teste Completo com Postman

#### Teste 1: Listar Usuários
```
GET http://localhost:8080/api/users
```
- Clique em **Send**
- Veja a resposta em JSON na aba **Body**

#### Teste 2: Listar com Filtros
```
GET http://localhost:8080/api/users?page=0&size=5&sort=name,asc
```
- Click em **Params** (ao lado de Headers)
- Adicione:
  - Key: `page`, Value: `0`
  - Key: `size`, Value: `5`
  - Key: `sort`, Value: `name,asc`
- Clique em **Send**

#### Teste 3: Buscar por ID
```
GET http://localhost:8080/api/users/{{userId}}
```
- Clique em **Params**
- Substitua `{{userId}}` pelo UUID do usuário
- Clique em **Send**

---

## 🎨 Estrutura de Resposta por Endpoint

### Users
```json
{
  "id": "UUID",
  "name": "string",
  "email": "string",
  "createdAt": "ISO-8601 datetime"
}
```

### Groups
```json
{
  "id": "UUID",
  "name": "string",
  "description": "string",
  "currencyCode": "string (ex: USD)",
  "isActive": "boolean",
  "creatorName": "string",
  "createdAt": "ISO-8601 datetime"
}
```

### Categories
```json
{
  "id": "UUID",
  "title": "string",
  "description": "string"
}
```

### Payment Splits
```json
{
  "id": "UUID",
  "title": "string",
  "description": "string"
}
```

### Group Members
```json
{
  "id": "UUID",
  "userId": "User object",
  "groupId": "Group object",
  "isAdmin": "boolean",
  "inGroup": "boolean"
}
```

### Agreements
```json
{
  "id": "UUID",
  "title": "string",
  "description": "string",
  "currencyCode": "string",
  "paymentSplit": "PaymentSplit object",
  "category": "Category object",
  "exchangeRate": "BigDecimal",
  "isPaid": "boolean"
}
```

### Agreement Members
```json
{
  "id": "UUID",
  "memberName": "string",
  "groupName": "string",
  "isCreditor": "boolean",
  "amount": "BigDecimal"
}
```

---

## 💡 Dicas Importantes

### ✨ Para Paginação Eficiente
```
# Usar sort para ordenação
GET /api/users?sort=createdAt,desc&page=0&size=20

# Evitar páginas muito altas
GET /api/users?page=0&size=100  # ❌ Pesado
GET /api/users?page=0&size=20   # ✅ Ideal
```

### ✨ Tratamento de Erros
- **ID não encontrado**: Erro 500 com mensagem "não encontrado"
- **Página vazia**: Retorna `content: []` vazio, mas sucesso
- **Parâmetros inválidos**: Erro 400

### ✨ Performance
- Use `size` pequeno (10-20 itens)
- Use `sort` para ordenar no banco (não na aplicação)
- Cache resultados paginados se possível

---

## 🚀 Resumo Rápido

| O que fazer | Comando |
|-------------|---------|
| Listar recursos | `GET /api/{recurso}` |
| Listar com limite | `GET /api/{recurso}?size=5` |
| Listar página 2 | `GET /api/{recurso}?page=1&size=20` |
| Buscar um recurso | `GET /api/{recurso}/{id}` |
| Ordenar crescente | `GET /api/{recurso}?sort=campo,asc` |
| Ordenar decrescente | `GET /api/{recurso}?sort=campo,desc` |

Tá pronto! Teste no Postman e na linha de comando! 🎉
