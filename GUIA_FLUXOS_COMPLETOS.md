# 🎓 Guia Completo: Fluxos de Uso em Conjunto

## 🎯 Índice
1. [Fluxo 1: Criar Grupo + Adicionar Membros](#fluxo-1-criar-grupo--adicionar-membros)
2. [Fluxo 2: Criar Acordo com Membros](#fluxo-2-criar-acordo-com-membros)
3. [Fluxo 3: Dividir Pagamento entre Membros](#fluxo-3-dividir-pagamento-entre-membros)
4. [Fluxo Completo Real](#fluxo-completo-real)
5. [Dicas e Troubleshooting](#dicas-e-troubleshooting)

---

## Fluxo 1: Criar Grupo + Adicionar Membros

### 📋 Passo 1: Criar 2 usuários

```bash
# Usuário 1
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@tripshare.com",
    "password": "senha123"
  }'
```

**Resposta:**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "João Silva",
  "email": "joao@tripshare.com",
  "createdAt": "2025-11-22T10:30:00"
}
```

```bash
# Usuário 2
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Maria Santos",
    "email": "maria@tripshare.com",
    "password": "senha456"
  }'
```

**Resposta:**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440001",
  "name": "Maria Santos",
  "email": "maria@tripshare.com",
  "createdAt": "2025-11-22T10:35:00"
}
```

### 📋 Passo 2: Criar Grupo

```bash
curl -X POST http://localhost:8080/api/groups \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Viagem Paris 2025",
    "description": "Viagem em grupo para Paris",
    "currencyCode": "EUR",
    "createdById": "550e8400-e29b-41d4-a716-446655440000"
  }'
```

**Resposta:**
```json
{
  "id": "660f8400-e29b-41d4-a716-446655440000",
  "name": "Viagem Paris 2025",
  "description": "Viagem em grupo para Paris",
  "currencyCode": "EUR",
  "isActive": true,
  "creatorName": "João Silva",
  "createdAt": "2025-11-22T10:40:00"
}
```

**⚠️ Guarde o ID do grupo:** `660f8400-e29b-41d4-a716-446655440000`

### 📋 Passo 3: Adicionar João ao Grupo

```bash
curl -X POST http://localhost:8080/api/group-members \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "550e8400-e29b-41d4-a716-446655440000",
    "groupId": "660f8400-e29b-41d4-a716-446655440000"
  }'
```

**Resposta:**
```json
{
  "id": "770e8400-e29b-41d4-a716-446655440000",
  "userId": {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "João Silva",
    "email": "joao@tripshare.com"
  },
  "groupId": {
    "id": "660f8400-e29b-41d4-a716-446655440000",
    "name": "Viagem Paris 2025"
  },
  "isAdmin": false,
  "inGroup": true
}
```

**⚠️ Guarde o ID do membro:** `770e8400-e29b-41d4-a716-446655440000`

### 📋 Passo 4: Adicionar Maria ao Grupo

```bash
curl -X POST http://localhost:8080/api/group-members \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "550e8400-e29b-41d4-a716-446655440001",
    "groupId": "660f8400-e29b-41d4-a716-446655440000"
  }'
```

**⚠️ Guarde o ID do membro:** `770e8400-e29b-41d4-a716-446655440001`

### ✅ Passo 5: Verificar Membros do Grupo

```bash
curl -X GET http://localhost:8080/api/group-members?page=0&size=10
```

**Resposta:**
```json
{
  "content": [
    {
      "id": "770e8400-e29b-41d4-a716-446655440000",
      "userId": {"id": "550e8400-e29b-41d4-a716-446655440000", "name": "João Silva"},
      "groupId": {"id": "660f8400-e29b-41d4-a716-446655440000", "name": "Viagem Paris 2025"},
      "isAdmin": false,
      "inGroup": true
    },
    {
      "id": "770e8400-e29b-41d4-a716-446655440001",
      "userId": {"id": "550e8400-e29b-41d4-a716-446655440001", "name": "Maria Santos"},
      "groupId": {"id": "660f8400-e29b-41d4-a716-446655440000", "name": "Viagem Paris 2025"},
      "isAdmin": false,
      "inGroup": true
    }
  ]
}
```

---

## Fluxo 2: Criar Acordo com Membros

### 📋 Passo 1: Criar Category

```bash
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Hospedagem",
    "description": "Gastos com hotel"
  }'
```

**Resposta:**
```json
{
  "id": "880e8400-e29b-41d4-a716-446655440000",
  "title": "Hospedagem",
  "description": "Gastos com hotel"
}
```

**⚠️ Guarde o ID:** `880e8400-e29b-41d4-a716-446655440000`

### 📋 Passo 2: Criar Payment Split

```bash
curl -X POST http://localhost:8080/api/payment-splits \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Split Igualitário",
    "description": "Dividir em partes iguais"
  }'
```

**Resposta:**
```json
{
  "id": "990e8400-e29b-41d4-a716-446655440000",
  "title": "Split Igualitário",
  "description": "Dividir em partes iguais"
}
```

**⚠️ Guarde o ID:** `990e8400-e29b-41d4-a716-446655440000`

### 📋 Passo 3: Criar Acordo

```bash
curl -X POST http://localhost:8080/api/agreements \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Hotel Versailles",
    "description": "Hospedagem em Paris - €500",
    "currencyCode": "EUR",
    "paymentSplit": "990e8400-e29b-41d4-a716-446655440000",
    "category": "880e8400-e29b-41d4-a716-446655440000",
    "createdById": "770e8400-e29b-41d4-a716-446655440000"
  }'
```

**Resposta:**
```json
{
  "id": "aa0e8400-e29b-41d4-a716-446655440000",
  "title": "Hotel Versailles",
  "description": "Hospedagem em Paris - €500",
  "currencyCode": "EUR",
  "paymentSplit": {...},
  "category": {...},
  "exchangeRate": 1.00,
  "isPaid": false,
  "createdAt": "2025-11-22T11:00:00"
}
```

**⚠️ Guarde o ID do acordo:** `aa0e8400-e29b-41d4-a716-446655440000`

### 📋 Passo 4: Associar Membros ao Acordo

#### João paga €250 (credor)
```bash
curl -X POST http://localhost:8080/api/agreement-members \
  -H "Content-Type: application/json" \
  -d '{
    "memberId": "770e8400-e29b-41d4-a716-446655440000",
    "agreementId": "aa0e8400-e29b-41d4-a716-446655440000",
    "isCreditor": true,
    "amount": 250.00
  }'
```

**Resposta:**
```json
{
  "id": "bb0e8400-e29b-41d4-a716-446655440000",
  "memberName": "João Silva",
  "groupName": "Viagem Paris 2025",
  "isCreditor": true,
  "amount": 250.00
}
```

#### Maria paga €250 (credor)
```bash
curl -X POST http://localhost:8080/api/agreement-members \
  -H "Content-Type: application/json" \
  -d '{
    "memberId": "770e8400-e29b-41d4-a716-446655440001",
    "agreementId": "aa0e8400-e29b-41d4-a716-446655440000",
    "isCreditor": true,
    "amount": 250.00
  }'
```

### ✅ Passo 5: Verificar Acordo

```bash
curl -X GET http://localhost:8080/api/agreements/aa0e8400-e29b-41d4-a716-446655440000
```

### ✅ Passo 6: Listar Membros do Acordo

```bash
curl -X GET http://localhost:8080/api/agreement-members
```

---

## Fluxo 3: Dividir Pagamento entre Membros

### 📋 Cenário: João gastou €300 no restaurante (3 pessoas)

**IDs já temos:**
- João (membro): `770e8400-e29b-41d4-a716-446655440000`
- Maria (membro): `770e8400-e29b-41d4-a716-446655440001`
- Grupo: `660f8400-e29b-41d4-a716-446655440000`

### 📋 Passo 1: Criar Category Comida

```bash
curl -X POST http://localhost:8080/api/categories \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Alimentação",
    "description": "Gastos com comida"
  }'
```

ID: `cc0e8400-e29b-41d4-a716-446655440000`

### 📋 Passo 2: Criar Payment Split (dividir por 3)

```bash
curl -X POST http://localhost:8080/api/payment-splits \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Split 3 Pessoas",
    "description": "Dividir por 3 (€100 cada)"
  }'
```

ID: `dd0e8400-e29b-41d4-a716-446655440000`

### 📋 Passo 3: Criar Acordo

```bash
curl -X POST http://localhost:8080/api/agreements \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Restaurante Tour Eiffel",
    "description": "€300 total (€100 cada)",
    "currencyCode": "EUR",
    "paymentSplit": "dd0e8400-e29b-41d4-a716-446655440000",
    "category": "cc0e8400-e29b-41d4-a716-446655440000",
    "createdById": "770e8400-e29b-41d4-a716-446655440000"
  }'
```

### 📋 Passo 4: João é o credor (pagou €300)

```bash
curl -X POST http://localhost:8080/api/agreement-members \
  -H "Content-Type: application/json" \
  -d '{
    "memberId": "770e8400-e29b-41d4-a716-446655440000",
    "agreementId": "ee0e8400-e29b-41d4-a716-446655440000",
    "isCreditor": true,
    "amount": 300.00
  }'
```

### 📋 Passo 5: Maria deve €100 (é devedor)

```bash
curl -X POST http://localhost:8080/api/agreement-members \
  -H "Content-Type: application/json" \
  -d '{
    "memberId": "770e8400-e29b-41d4-a716-446655440001",
    "agreementId": "ee0e8400-e29b-41d4-a716-446655440000",
    "isCreditor": false,
    "amount": 100.00
  }'
```

### ✅ Resultado:
- **João**: Credor de €300 (pagou tudo)
- **Maria**: Devedor de €100 (deve para João)

---

## Fluxo Completo Real

### 🎬 Cenário: Viagem a Barcelona com 4 Amigos

```
Participantes:
- Ana (id: 1)
- Bruno (id: 2)
- Carlos (id: 3)
- Diana (id: 4)

Despesas:
- Voo: €800 (Ana pagou) → dividir por 4
- Hotel: €600 (Bruno pagou) → dividir por 4
- Comida: €400 (Carlos pagou) → dividir por 4
```

### 📋 Passo 1: Criar Usuários

```bash
# Ana
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Ana","email":"ana@email.com","password":"123"}'
# ID: ana-id

# Bruno
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Bruno","email":"bruno@email.com","password":"123"}'
# ID: bruno-id

# Carlos
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Carlos","email":"carlos@email.com","password":"123"}'
# ID: carlos-id

# Diana
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Diana","email":"diana@email.com","password":"123"}'
# ID: diana-id
```

### 📋 Passo 2: Criar Grupo

```bash
curl -X POST http://localhost:8080/api/groups \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Barcelona 2025",
    "description": "Viagem para Barcelona com os amigos",
    "currencyCode": "EUR",
    "createdById": "ana-id"
  }'
# ID: barcelona-group-id
```

### 📋 Passo 3: Adicionar Membros ao Grupo

```bash
# Adicionar Ana
curl -X POST http://localhost:8080/api/group-members \
  -d '{"userId":"ana-id","groupId":"barcelona-group-id"}'

# Adicionar Bruno
curl -X POST http://localhost:8080/api/group-members \
  -d '{"userId":"bruno-id","groupId":"barcelona-group-id"}'

# Adicionar Carlos
curl -X POST http://localhost:8080/api/group-members \
  -d '{"userId":"carlos-id","groupId":"barcelona-group-id"}'

# Adicionar Diana
curl -X POST http://localhost:8080/api/group-members \
  -d '{"userId":"diana-id","groupId":"barcelona-group-id"}'
```

### 📋 Passo 4: Criar Categories

```bash
# Transportes
curl -X POST http://localhost:8080/api/categories \
  -d '{"title":"Transportes","description":"Voos e transportes"}'
# ID: transport-cat-id

# Hospedagem
curl -X POST http://localhost:8080/api/categories \
  -d '{"title":"Hospedagem","description":"Hotel"}'
# ID: hotel-cat-id

# Alimentação
curl -X POST http://localhost:8080/api/categories \
  -d '{"title":"Alimentação","description":"Comidas"}'
# ID: food-cat-id
```

### 📋 Passo 5: Criar Payment Split

```bash
curl -X POST http://localhost:8080/api/payment-splits \
  -d '{"title":"Split 4 Pessoas","description":"Dividir igualmente por 4"}'
# ID: split-4-id
```

### 📋 Passo 6: Despesa 1 - VOO (Ana pagou €800)

```bash
# Criar acordo
curl -X POST http://localhost:8080/api/agreements \
  -d '{
    "title":"Voo Lisbon → Barcelona",
    "description":"€800 total",
    "currencyCode":"EUR",
    "paymentSplit":"split-4-id",
    "category":"transport-cat-id",
    "createdById":"ana-member-id"
  }'
# ID: flight-agreement-id

# Ana é credor (pagou tudo: €800)
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{
    "memberId":"ana-member-id",
    "agreementId":"flight-agreement-id",
    "isCreditor":true,
    "amount":800
  }'

# Bruno deve €200
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{
    "memberId":"bruno-member-id",
    "agreementId":"flight-agreement-id",
    "isCreditor":false,
    "amount":200
  }'

# Carlos deve €200
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{
    "memberId":"carlos-member-id",
    "agreementId":"flight-agreement-id",
    "isCreditor":false,
    "amount":200
  }'

# Diana deve €200
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{
    "memberId":"diana-member-id",
    "agreementId":"flight-agreement-id",
    "isCreditor":false,
    "amount":200
  }'
```

### 📋 Passo 7: Despesa 2 - HOTEL (Bruno pagou €600)

```bash
curl -X POST http://localhost:8080/api/agreements \
  -d '{
    "title":"Hotel Gran Via",
    "description":"€600 total (3 noites)",
    "currencyCode":"EUR",
    "paymentSplit":"split-4-id",
    "category":"hotel-cat-id",
    "createdById":"bruno-member-id"
  }'
# ID: hotel-agreement-id

# Bruno é credor (€600)
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"bruno-member-id","agreementId":"hotel-agreement-id","isCreditor":true,"amount":600}'

# Ana deve €150
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"ana-member-id","agreementId":"hotel-agreement-id","isCreditor":false,"amount":150}'

# Carlos deve €150
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"carlos-member-id","agreementId":"hotel-agreement-id","isCreditor":false,"amount":150}'

# Diana deve €150
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"diana-member-id","agreementId":"hotel-agreement-id","isCreditor":false,"amount":150}'
```

### 📋 Passo 8: Despesa 3 - COMIDA (Carlos pagou €400)

```bash
curl -X POST http://localhost:8080/api/agreements \
  -d '{
    "title":"Refeições em Barcelona",
    "description":"€400 total",
    "currencyCode":"EUR",
    "paymentSplit":"split-4-id",
    "category":"food-cat-id",
    "createdById":"carlos-member-id"
  }'
# ID: food-agreement-id

# Carlos é credor (€400)
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"carlos-member-id","agreementId":"food-agreement-id","isCreditor":true,"amount":400}'

# Ana deve €100
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"ana-member-id","agreementId":"food-agreement-id","isCreditor":false,"amount":100}'

# Bruno deve €100
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"bruno-member-id","agreementId":"food-agreement-id","isCreditor":false,"amount":100}'

# Diana deve €100
curl -X POST http://localhost:8080/api/agreement-members \
  -d '{"memberId":"diana-member-id","agreementId":"food-agreement-id","isCreditor":false,"amount":100}'
```

### ✅ Passo 9: Verificar Balanço

```bash
# Ver todos os acordos
curl -X GET http://localhost:8080/api/agreements

# Ver todos os membros dos acordos
curl -X GET http://localhost:8080/api/agreement-members

# Ver grupo
curl -X GET http://localhost:8080/api/groups/barcelona-group-id

# Ver membros do grupo
curl -X GET http://localhost:8080/api/group-members
```

### 💰 Resultado Final:
```
Ana:
  - Gastou: €800 (voo)
  - Deve: €250 (€200 hotel + €100 comida)
  - Saldo: €550 (CRÉDITO)

Bruno:
  - Gastou: €600 (hotel)
  - Deve: €300 (€200 voo + €100 comida)
  - Saldo: €300 (CRÉDITO)

Carlos:
  - Gastou: €400 (comida)
  - Deve: €400 (€200 voo + €150 hotel + €50 que falta)
  - Saldo: 0 (QUASE EMPATE)

Diana:
  - Gastou: €0
  - Deve: €450 (€200 voo + €150 hotel + €100 comida)
  - Saldo: -€450 (DEVEDOR)
```

---

## Dicas e Troubleshooting

### ✅ Boas Práticas

1. **Sempre guarde os IDs**
   ```
   Usuário: para adicionar ao grupo
   Grupo: para associar membros
   Member: para criar acordos
   Category: para criar acordos
   PaymentSplit: para criar acordos
   Acordo: para adicionar membros
   ```

2. **Ordem correta:**
   ```
   1. Criar Usuários
   2. Criar Grupo
   3. Adicionar Usuários ao Grupo (gera IDs de membro)
   4. Criar Categories e PaymentSplits
   5. Criar Acordos
   6. Adicionar Membros aos Acordos
   ```

3. **Validações importantes:**
   - Email único (não repetir usuários)
   - UUID válido em todas as associações
   - Amount deve ser positivo
   - Mínimo 1 pessoa no grupo

### ❌ Erros Comuns

| Erro | Causa | Solução |
|------|-------|---------|
| `404 não encontrado` | ID inválido | Verifique se copiou o UUID correto |
| `400 Bad Request` | Email duplicado | Use email diferente |
| `500 erro genérico` | Dados faltando | Verifique todos os campos obrigatórios |
| `Membro não encontrado` | ID do membro errado | Use o ID do group-members, não do usuário |

### 🔧 Comandos Úteis

```bash
# Ver todos os usuários
curl http://localhost:8080/api/users

# Ver todos os grupos
curl http://localhost:8080/api/groups

# Ver todos os membros
curl http://localhost:8080/api/group-members

# Ver todos os acordos
curl http://localhost:8080/api/agreements

# Ver todos os membros de acordos
curl http://localhost:8080/api/agreement-members

# Ver categorias
curl http://localhost:8080/api/categories

# Ver payment splits
curl http://localhost:8080/api/payment-splits
```

### 💡 Pro Tips

1. **Salve num arquivo .json:**
   ```json
   {
     "users": {
       "ana": "ana-uuid",
       "bruno": "bruno-uuid"
     },
     "groups": {
       "barcelona": "barcelona-uuid"
     },
     "members": {
       "ana_barcelona": "ana-member-uuid"
     }
   }
   ```

2. **Use variáveis no Postman:**
   - Click na engrenagem (Settings)
   - Crie um "Environment"
   - Defina variáveis: `{{groupId}}`, `{{userId}}`

3. **Importe no Postman:**
   - Vá em Collections → Import
   - Cole os exemplos acima

---

## 🚀 Resumo de URLs

```
USERS:         POST/GET   /api/users/{id}
GROUPS:        POST/GET   /api/groups/{id}
CATEGORIES:    POST/GET   /api/categories/{id}
PAYMENTS:      POST/GET   /api/payment-splits/{id}
GROUP-MEMBERS: POST/GET   /api/group-members/{id}
AGREEMENTS:    POST/GET   /api/agreements/{id}
AGRE-MEMBERS:  POST/GET   /api/agreement-members/{id}
```


