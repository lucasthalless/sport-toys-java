# Projeto MVC de Brinquedos Esportivos - FIAP TDS

## Descrição do Projeto

Este projeto é uma aplicação web MVC desenvolvida com o framework **Spring Boot** para gerenciamento de brinquedos esportivos infantis (até 12 anos), como bolas, raquetes, tênis e roupas esportivas. A aplicação implementa operações CRUD (Create, Read, Update, Delete) com uma interface web utilizando **Thymeleaf** para renderização de templates HTML, persistência em um banco de dados **Oracle**, e validações. O layout front-end foi projetado com **Bootstrap** para responsividade e usabilidade. Os endpoints MVC permitem interações via links e botões na interface, com redirecionamentos para a lista após operações.

O tema foca em brinquedos esportivos, com colunas personalizadas na tabela do banco: Id, Nome, Tipo, Classificação, Tamanho, Preço (ex: Nome: "Bola de Futebol", Tipo: "Bola", Classificação: "3+", Tamanho: "Pequeno", Preço: 29.99).

### Tecnologias Utilizadas
- **Spring Boot**: Framework principal para MVC.
- **Maven**: Gerenciamento de dependências.
- **Java 17**: Linguagem de programação.
- **Spring Data JPA**: Persistência com Oracle.
- **Thymeleaf**: Renderização de templates HTML (obrigatório).
- **Lombok**: Simplificação de código na entidade.
- **Bootstrap**: Layout front-end responsivo.
- **Oracle SQL Developer**: Banco de dados.
- **IntelliJ IDEA**: IDE utilizada.

### Configuração Inicial
O projeto foi inicializado via **Spring Initializr** com as dependências: Spring Web, Spring Data JPA, Thymeleaf, Lombok. O driver Oracle foi adicionado manualmente no `pom.xml`.

**Evidência**:
![Print do Spring Initializr com dependências](https://github.com/lucasthalless/sport-toys-java/blob/main/src/assets/spring-initializr.png)

A configuração do banco foi feita em `application.properties`.

## Estrutura do Projeto
- **Model**: Classe `Brinquedo` com anotações JPA e validações.
- **Repository**: Interface `BrinquedoRepository` estendendo `JpaRepository`.
- **Controller**: `BrinquedoMvcController` com endpoints para CRUD via web.
- **Templates**: Pasta `templates` com `list.html` (lista) e `form.html` (criação/edição).

## Funcionalidades e Endpoints

A aplicação opera em `/brinquedos`. Abaixo, cada operação CRUD é descrita com exemplos e prints.

### 1. READ (Listar Todos)
- **Descrição**: Exibe uma tabela com todos os brinquedos, incluindo links para editar/excluir e botão para novo.
- **Endpoint**: GET `/brinquedos`.
- **Exemplo**: A tabela mostra colunas personalizadas e ações.
- **Evidência**:
  ![Lista de Brinquedos](https://github.com/lucasthalless/sport-toys-java/blob/main/src/assets/list-brinquedos.png)


### 2. CREATE (Criar)
- **Descrição**: Formulário para inserir novo brinquedo, com validações (ex: campos obrigatórios).
- **Endpoint**: GET `/brinquedos/new` (form) e POST `/brinquedos` (salvar).
- **Exemplo**: Preencha os campos e clique em "Salvar"; redireciona para lista.
- **Evidência**:
  ![Formulário de Criação](https://github.com/lucasthalless/sport-toys-java/blob/main/src/assets/form-create.png)
  

### 3. UPDATE (Atualizar)
- **Descrição**: Formulário preenchido para editar brinquedo existente, com validações.
- **Endpoint**: GET `/brinquedos/edit/{id}` (form) e POST `/brinquedos/{id}` (salvar).
- **Exemplo**: Clique em "Editar" na lista, altere campos e salve.
- **Evidência**:
  ![Formulário de Edição](https://github.com/lucasthalless/sport-toys-java/blob/main/src/assets/form-edit.png)
  
  
### 4. DELETE (Excluir)
- **Descrição**: Exclui brinquedo por ID via link.
- **Endpoint**: GET `/brinquedos/delete/{id}`.
- **Exemplo**: Clique em "Excluir" na lista; redireciona para lista atualizada.


## Uso de Thymeleaf e Layout
- Thymeleaf foi usado para vinculação dinâmica de dados (`th:each`, `th:field`) e ações (`th:action`, `th:href`).
- Layout com Bootstrap garante responsividade e botões intuitivos (ex: "Novo", "Editar", "Excluir").

## Persistência no Banco Oracle
- Persistência via JPA com commit no Oracle para todas as operações.

## Deploy
O projeto foi implantado na plataforma **Render**. A URL de produção é:
- **[Link do Deploy](https://sport-toys-java.onrender.com/brinquedos)**

## Vídeo de Demonstração
Vídeo mostrando as funcionalidades CRUD na interface web, endpoints e deploy:
- **[Link do Vídeo](#)**

## Instruções de Uso
1. Clone o repositório: `git clone https://github.com/lucasthalless/sport-toys-java`.
2. Configure o Oracle com a tabela `TDS_MVC_TB_Brinquedos`.
3. Rode o projeto: `./mvnw spring-boot:run`.
4. Acesse `http://localhost:8081/brinquedos` no navegador.