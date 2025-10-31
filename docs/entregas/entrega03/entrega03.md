# 📘 Documentação da API

Este documento descreve os endpoints, métodos, descrições e requisitos da API do sistema.

---

## 1. Usuários (`/api/usuarios`)

| **Método** | **Rota** | **Descrição** | **Requisitos Relacionados** |
|-------------|-----------|----------------|------------------------------|
| `POST` | `/api/usuarios` | Cadastrar novo usuário | RF01, RF18, RF19 |
| `GET` | `/api/usuarios/:id` | Obter dados de um usuário específico | RF24, RF29 |
| `PUT` | `/api/usuarios/:id` | Atualizar dados do usuário | RF02, RF18, RF19 |
| `DELETE` | `/api/usuarios/:id` | Desativar usuário *(opcional)* | — |
| `GET` | `/api/usuarios/:id/acordos` | Listar acordos do usuário (ainda não concluídos) | RF17 |
| `GET` | `/api/usuarios/:id/grupos` | Listar grupos dos quais o usuário participa | RF11 |

---

## 2. Grupos (`/api/grupos`)

| **Método** | **Rota** | **Descrição** | **Requisitos Relacionados** |
|-------------|-----------|----------------|------------------------------|
| `POST` | `/api/grupos` | Criar grupo | RF03, RF20, RF21 |
| `GET` | `/api/grupos/:id` | Obter informações de um grupo | RF25, RF30 |
| `PUT` | `/api/grupos/:id` | Editar dados do grupo *(apenas admin)* | RF05, RF20, RF21 |
| `DELETE` | `/api/grupos/:id` | Excluir grupo *(tornar inativo)* | RF04, RF30 |
| `PATCH` | `/api/grupos/:id/apagar` | Apagar grupo *(remover da lista do usuário)* | RF10 |
| `GET` | `/api/grupos` | Listar grupos do usuário logado | RF11 |

---

## 3. Membros de Grupo (`/api/grupos/:grupoId/membros`)

| **Método** | **Rota** | **Descrição** | **Requisitos Relacionados** |
|-------------|-----------|----------------|------------------------------|
| `POST` | `/api/grupos/:grupoId/membros` | Adicionar membro *(admin)* | RF06, RF32, RF33 |
| `DELETE` | `/api/grupos/:grupoId/membros/:usuarioId` | Remover membro *(admin)* | RF07, RF32, RF33 |
| `PATCH` | `/api/grupos/:grupoId/membros/:usuarioId/admin` | Tornar membro administrador | RF08 |
| `DELETE` | `/api/grupos/:grupoId/membros/sair` | Membro sair do grupo | RF09 |
| `GET` | `/api/grupos/:grupoId/membros` | Listar membros do grupo | RF12 |

---

## 4. Acordos (`/api/acordos`)

| **Método** | **Rota** | **Descrição** | **Requisitos Relacionados** |
|-------------|-----------|----------------|------------------------------|
| `POST` | `/api/grupos/:grupoId/acordos` | Registrar acordo no grupo | RF13, RF22, RF23 |
| `GET` | `/api/grupos/:grupoId/acordos` | Listar acordos do grupo | RF17 |
| `GET` | `/api/acordos/:id` | Consultar um acordo específico | RF26, RF31 |
| `PUT` | `/api/acordos/:id` | Editar acordo *(autor ou admin)* | RF27 |
| `DELETE` | `/api/acordos/:id` | Excluir acordo *(autor ou admin)* | RF28 |
| `GET` | `/api/grupos/:grupoId/saldos` | Calcular saldos dos membros do grupo | RF14, RF15 |
| `PATCH` | `/api/grupos/:grupoId/saldos/reiniciar` | Reiniciar saldos do grupo *(admin)* | RF16 |

---

## 5. Relatórios e Moedas (`/api/relatorios`, `/api/moedas`)

| **Método** | **Rota** | **Descrição** | **Requisitos Relacionados** |
|-------------|-----------|----------------|------------------------------|
| `GET` | `/api/relatorios/grupos/:grupoId/saldos` | Mostrar histórico de saldos por data/intervalo | RN03 |
| `GET` | `/api/moedas/conversao?de=USD&para=BRL` | Converter valor de moedas via API externa | RNF01, RN01 |

---

## 6. Validações e Erros *(tratados via middleware)*

| **Tipo de Validação** | **Descrição** | **Requisitos Relacionados** |
|------------------------|----------------|------------------------------|
| Validação de usuário | Campos obrigatórios, formato de e-mail, CPF, etc. | RF18, RF19 |
| Validação de grupo | Nome, membros, permissões | RF20, RF21 |
| Validação de acordo | Valores, divisões, moedas | RF22, RF23 |
| Verificação de existência | Usuário, grupo, acordo, membro | RF24, RF25, RF26, RF32 |
| Mensagens de erro | Retorno de mensagens específicas | RF29, RF30, RF31, RF33 |

---

## 7. Participantes (`/api/grupos/:grupoId/participantes`)

| **Método** | **Rota** | **Descrição** |
|-------------|-----------|----------------|
| `POST` | `/api/grupos/:grupoId/participantes` | Adicionar participante à viagem |
| `GET` | `/api/grupos/:grupoId/participantes` | Listar todos os participantes da viagem |
| `GET` | `/api/grupos/:grupoId/participantes/:id` | Detalhar participante específico |
| `PATCH` | `/api/grupos/:grupoId/participantes/:id` | Atualizar apelido ou saldo |
| `DELETE` | `/api/grupos/:grupoId/participantes/:id` | Remover participante da viagem |
| `PATCH` | `/api/grupos/:grupoId/participantes/:id/admin` | Tornar participante administrador |

---

## 8. Divisões de Despesa (`/api/acordos/:despesaId/divisoes`)

| **Método** | **Rota** | **Descrição** |
|-------------|-----------|----------------|
| `POST` | `/api/acordos/:despesaId/divisoes` | Registrar divisão de despesa |
| `GET` | `/api/acordos/:despesaId/divisoes` | Listar divisões da despesa |
| `PUT` | `/api/divisoes/:id` | Editar valor devido |
| `DELETE` | `/api/divisoes/:id` | Remover divisão |

---

## 9. Transações (`/api/grupos/:grupoId/transacoes`)

| **Método** | **Rota** | **Descrição** |
|-------------|-----------|----------------|
| `GET` | `/api/grupos/:grupoId/transacoes` | Listar transações sugeridas *(cálculo de saldos)* |
| `POST` | `/api/grupos/:grupoId/transacoes/recalcular` | Recalcular saldos e gerar novas sugestões |
| `DELETE` | `/api/grupos/:grupoId/transacoes` | Limpar transações sugeridas *(reiniciar)* |

---

## 10. Relatórios & Saldos (`/api/relatorios`)

| **Método** | **Rota** | **Descrição** |
|-------------|-----------|----------------|
| `GET` | `/api/relatorios/grupos/:grupoId/saldos` | Mostrar saldos atuais dos participantes |
| `GET` | `/api/relatorios/grupos/:grupoId/saldos/historico` | Relatório temporal dos saldos | RN03 |
| `GET` | `/api/relatorios/usuarios/:usuarioId` | Exibir acordos/pendências do usuário |

---