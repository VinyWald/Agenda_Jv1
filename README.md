# Agenda de Contatos em Java com MySQL

## Visão Geral

Este projeto consiste em uma aplicação de agenda de contatos desenvolvida em Java. A interface do usuário é baseada em linha de comando (CLI), permitindo a gestão completa de contatos, incluindo a criação, visualização, atualização e exclusão.

A aplicação utiliza o driver JDBC para a persistência de dados, conectando-se a um banco de dados MySQL para armazenar e recuperar as informações dos contatos. O projeto demonstra a implementação de operações CRUD (Create, Read, Update, Delete) e a separação de responsabilidades através de uma estrutura de pacotes simples, com `model` para as entidades de dados e `controller` para a lógica de acesso aos dados (DAO - Data Access Object).

## Funcionalidades

* **Adicionar Contatos**: Permite ao usuário inserir novos contatos na agenda, fornecendo nome e idade.
* **Visualizar Todos os Contatos**: Lista todos os contatos atualmente armazenados no banco de dados, exibindo ID, nome, idade e data de cadastro.
* **Atualizar Contatos**: Permite a modificação das informações de um contato existente através do seu ID.
* **Excluir Contatos**: Remove um contato do banco de dados com base no seu ID.
* **Persistência de Dados**: Todas as informações são salvas em um banco de dados MySQL, garantindo que os dados não sejam perdidos ao fechar a aplicação.

## Stack de Tecnologias

* **Linguagem**: Java
* **Banco de Dados**: MySQL
* **Conectividade**: Java Database Connectivity (JDBC)
* **Build/Gerenciamento de Dependências**: (Mencionar se usar Maven ou Gradle, caso contrário, pode ser omitido ou descrito como "Gerenciamento manual de JARs")

## Pré-requisitos para Execução

* Java Development Kit (JDK) 8 ou superior.
* Servidor de banco de dados MySQL em execução.
* Driver MySQL Connector/J.

## Como Executar o Projeto

### 1. Configuração do Banco de Dados

Antes de executar a aplicação, é necessário criar o banco de dados e a tabela. Execute o script SQL fornecido no arquivo `script.sql` em seu cliente MySQL:

```sql
CREATE DATABASE agenda;

USE agenda;

CREATE TABLE contatos (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40),
    idade INT,
    dataCadastro DATE,
    PRIMARY KEY (id)
);
```

### 2\. Configuração da Conexão

No arquivo `agenda/controller/ContatoDAO.java`, certifique-se de que os detalhes da conexão com o banco de dados (URL, usuário e senha) estão corretos para o seu ambiente local.

### 3\. Compilação e Execução

1.  Compile o código-fonte Java. Se estiver usando um IDE, ele fará isso automaticamente. Pela linha de comando, navegue até o diretório raiz do projeto e execute:

    ```bash
    javac agenda/Main.java agenda/model/Contato.java agenda/controller/ContatoDAO.java
    ```

2.  Execute a classe principal, certificando-se de incluir o driver JDBC no classpath:

    ```bash
    # Exemplo para Windows
    java -cp ".;path/to/mysql-connector-java.jar" agenda.Main

    # Exemplo para Linux/macOS
    java -cp ".:path/to/mysql-connector-java.jar" agenda.Main
    ```

    *Substitua `path/to/mysql-connector-java.jar` pelo caminho real do seu arquivo conector MySQL.*

<!-- end list -->

```


