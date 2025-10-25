# 🔧 Projeto Final de Backend - API REST

## Membros:
- [Leonardo Da Cruz Ramos][leoleojogos]
- [Lucas Pizoni Flôres][LuxLucas]
- [Gabriel Mensor Da Rosa][GabrielMensor]

## 🎯 Objetivos

- Processar requisições JSON em rotas GET, POST, PUT e DELETE;
- Estruturar rotas e modelos com documentação adequada;
- Aplicar boas práticas de organização e codificação backend.
- Implementar requisitos específicos do tema escolhido.

## Tema:
O tema selecionado, dentre as possíveis escolhas, foi a área de **"Hábitos e Organização Pessoal"**.

## ✔️ Requisitos Obrigatórios do Projeto
Os requisitos obrigatórios do projeto descrevem os requisitos mínimos que o nosso projeto deve atender. Não atender quaisquer um dos requisitos abaixo resulta em perda de pontos, o que inclui a anulação completa do projeto.

- [ ] Implementa um serviço backend que atenda clientes HTTP;
- [ ] Estruturado em camadas (separação entre Controller e Service);
- [ ] Documentado usando o arquivo README.md na raiz do projeto;
- [ ] Contém um arquivo .env com as variáveis de ambiente necessárias para o funcionamento do projeto;
- [ ] Realiza a persistência de dados usando um sistema de gerenciamento de banco de dados;
- [ ] Deve possuir pelo menos três entidades, sendo duas delas com relação entre si (1:N, N:N);
- [ ] Cada entidade deve possuir um service para manipulação com métodos CRUD (getOne, getAll, create, update, delete);
- [ ] Todas as rotas devem retornar respostas apropriadas de sucesso e erro, utilizando códigos HTTP corretos (200, 201, 400, 404, 500, etc.);
- [ ] Implementa paginação e ordenação para o endpoint de listagem (GET ALL);
- [ ] Implementa filtros de busca para o endpoint de listagem (GET ALL);
- [ ] Utiliza DTOs (Data Transfer Objects) para entrada e saída de dados nas rotas;
- [ ] Validar os dados de entrada nas rotas, retornando erros apropriados para dados inválidos;

## 👍 Requisitos Extras do Projeto
Os requisitos extras do projeto descrevem requisitos opcionais que podem ser implementados para melhorar o projeto e a avaliação final:

- [ ] Utiliza autenticação e autorização com JWT (ou outro método de autenticação seguro); (talvez)
- [x] Documenta as rotas do projeto usando documentação automatizada como o Swagger;
- [ ] Implementa testes automatizados para garantir a qualidade do código. (um grande "talvez")
- [ ] Realiza o deploy do projeto em um ambiente de produção. (talvez)
- [ ] Automatiza o processo de deploy usando ferramentas como Docker e Kubernetes. (mais um grande "talvez")
- [x] Usa um SGBD diferente do H2 (ex: MongoDB, MySQL, PostgreSQL); (talvez SQLite)
- [x] Integra dados de uma API externa relevante para o tema escolhido; (conversão monetária)
- [ ] ~Implementa WebSockets para comunicação em tempo real (se aplicável ao tema);~

## 👾 Cartas-Desafio
**Relatório Agregado** - Uma entidade deve permitir filtrar um relatório baseado em um período de tempo (ex.: vendas?periodo=30dias). O filtro deve retornar o número de registros encontrados e o total de registros no período;

## 📅 Cronograma
- **Semana 01** - Lançamento do desafio, formação dos grupos e Entrega 01.
- **Semana 02** - DTO e Mapping e Entrega 02.
- **Semana 03** - Paginação, Ordenação e Relacionamento e Entrega 03.
- **Semana 04** - Apresentação dos Pré-Projetos.
- **Semana 05** - Desenvolvimento do Projeto e Entrega 04.
- **Semana 06** - Avaliação Escrita II.
- **Semana 07** - Entrega Final e Apresentação Final.

## 🗂️ Entregas
- **Entrega 01:** Endereço do repositório git (Github, Gitlab...) com um README.md contendo tema e nome dos integrantes.
- **Entrega 02:** Documentação das principais funcionalidades da API e dos modelos (entidades).
- **Entrega 03:** Definição da arquitetura REST (rotas, verbos, códigos) e mapeamento das funcionalidades.
- **Entrega 04:** Documentação da implementação da Carta-Desafio.

## 📝 Documentação
A documentação ser apresentada por meio de um arquivo de texto na raiz do projeto, chamado README.md, escrito em markdown e deverá conter:

- Descrição do projeto e dos integrantes do grupo;
- Descrição do problema;
- Tecnologias utilizadas;
- Limitações do projeto;
- Descrição de cada uma das entidades;
- Descrição de cada uma das rotas, contendo exemplos de requisições e respostas;
- Exemplos de erros HTTP;
- Descrição de como executar o projeto localmente;
- Outros conteúdos relevantes implementados no projeto.

O arquivo pode ser sub-dividido se necessário, mas deve conter o conteúdo acima. Para facilitar a leitura, utilize cabeçalhos de nível 2 (##) para cada seção. As descrições de entidades, rotas e exemplos podem ser removidas caso a equipe utilize uma documentação automatizada como o Swagger ou o Postman.


## 💬 Apresentação

A apresentação será realizada em sala de aula, na data definida no cronograma. Todos os estudantes precisam estar presentes na apresentação para receberem nota. Em caso de falta, a nota será atribuída apenas aos presentes.

Cada equipe terá **no máximo 15 minutos** para apresentar seu projeto. Equipes que ultrapassarem esse tempo poderão ser penalizadas de acordo com o tempo excedido.

A apresentação deverá ser feita com o uso de um projetor e um computador do laboratório. É possível utilizar o próprio computador do estudante para apresentação.

Entre os pontos a serem abordados na apresentação, precisam estar inclusos:

* Apresentação dos integrantes do grupo;
* Descrição do projeto e do domínio do problema (contextualização da API);
* Demonstração do funcionamento do projeto (exemplos de requisições e respostas);
* Descrição breve da arquitetura do projeto (código-fonte);
* Apresentação breve da documentação do projeto (arquivo ``README.md``);


<!--
A considerar:
- Cospend
- IHateMoney
- Splitwise
-->

[leoleojogos]: https://github.com/leoleojogos
[LuxLucas]: https://github.com/LuxLucas
[GabrielMensor]: https://github.com/GabrielMensor
