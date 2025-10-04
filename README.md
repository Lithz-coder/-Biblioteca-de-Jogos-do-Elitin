# Biblioteca de Jogos - Spring Boot

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

Um projeto de um sistema de gerenciamento para uma biblioteca de jogos, desenvolvido com Java e Spring Boot. Permite cadastrar, listar, editar, excluir e pesquisar jogos.

## 🚀 Sobre o Projeto

Esta aplicação foi criada como um projeto prático para demonstrar habilidades em desenvolvimento back-end com o ecossistema Spring. O sistema gerencia uma coleção de jogos, oferecendo funcionalidades CRUD completas através de uma interface web simples construída com Thymeleaf.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web:** Para a criação de endpoints REST e controllers web.
- **Spring Data JPA:** Para persistência de dados de forma simplificada.
- **Thymeleaf:** Para a construção das páginas web dinâmicas.
- **Hibernate:** Implementação padrão do JPA.
- **Maven:** Para gerenciamento de dependências e build do projeto.
- **H2 Database:** Banco de dados em memória para execução e testes locais.
- **PostgreSQL:** Banco de dados utilizado no ambiente de produção (Render).

---

## ⚙️ Como Executar Localmente

Siga os passos abaixo para rodar o projeto em sua máquina.

### Pré-requisitos

- **JDK 17** ou superior.
- **Apache Maven** instalado e configurado no PATH do sistema.
- Um cliente Git para clonar o repositório.

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/](https://github.com/)<SEU-USUARIO-GITHUB>/<NOME-DO-REPOSITORIO>.git
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd <NOME-DO-REPOSITORIO>
    ```

3.  **Execute o projeto com o Maven:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a aplicação:**
    Abra seu navegador e acesse `http://localhost:8080/jogos`.

---

## ☁️ Como Fazer o Deploy no Render

O deploy contínuo será feito a partir do GitHub. Siga as instruções para configurar o ambiente no [Render.com](https://render.com/).

### 1. Crie um Banco de Dados PostgreSQL

- No dashboard do Render, clique em **New > PostgreSQL**.
- Dê um nome ao banco (ex: `biblioteca-jogos-db`), escolha a região e clique em **Create Database**.
- Após a criação, copie a **URL de Conexão Interna** (`Internal Connection String`). Você precisará dela em breve.

### 2. Crie o Serviço Web (Web Service)

- No dashboard, clique em **New > Web Service**.
- Conecte sua conta do GitHub e autorize o Render a acessar o repositório deste projeto.
- Selecione o repositório.
- Preencha as configurações do serviço:
  - **Name:** Dê um nome único (ex: `biblioteca-jogos-api`).
  - **Region:** Escolha a mesma região do banco de dados.
  - **Build Command:** `mvn clean install`
  - **Start Command:** `java -jar target/bibliotecajogos-0.0.1-SNAPSHOT.jar`
    *(**Atenção:** Verifique o nome exato do arquivo `.jar` gerado na pasta `target` após o build).*

### 3. Configure as Variáveis de Ambiente

- Role a página de configuração do Web Service até a seção **Environment Variables**.
- Clique em **Add Environment Variable** e adicione as seguintes variáveis para conectar a aplicação ao banco de dados:
  - **`SPRING_DATASOURCE_URL`**: Cole a **URL de Conexão Interna** do seu banco de dados PostgreSQL que você copiou anteriormente.
  - **`SPRING_DATASOURCE_USERNAME`**: Cole o `username` fornecido nos detalhes do seu banco de dados no Render.
  - **`SPRING_DATASOURCE_PASSWORD`**: Cole a `password` fornecida nos detalhes do seu banco de dados no Render.
  - **`SPRING_JPA_HIBERNATE_DDL_AUTO`**: `update` (Isso permite que o Hibernate crie/atualize as tabelas no primeiro deploy).

### 4. Finalize e Faça o Deploy

- Clique em **Create Web Service**.
- O Render irá buscar o código do seu GitHub, executar o `Build Command` e, se tudo ocorrer bem, o `Start Command`.
- Você poderá acompanhar o log do deploy em tempo real. Ao final, sua aplicação estará disponível na URL fornecida pelo Render.

## 👨‍💻 Autor

Eliton Carvalho

- GitHub: `[@Lithz-coder](https://github
