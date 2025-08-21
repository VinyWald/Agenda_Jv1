# Gerador de Cronogramas

## Descrição

O Gerador de Cronogramas é uma aplicação web desenvolvida em Java para auxiliar estudantes na organização de seus trabalhos acadêmicos. Com uma interface simples e intuitiva, a ferramenta permite o cadastro, controle e visualização de tarefas, ajudando a manter os estudos em dia e a não perder nenhum prazo importante.

## Funcionalidades

* **Adicionar Novos Trabalhos:** Permite o cadastro de novas tarefas, especificando o tipo (trabalho, prova, etc.), a matéria, uma breve descrição e a data de entrega.
* **Visualizar Cronograma:** Apresenta todas as tarefas cadastradas em uma tabela organizada, com a possibilidade de ordenação por data.
* **Editar e Excluir Tarefas:** Oferece a flexibilidade de modificar ou remover tarefas já existentes.
* **Filtrar por Matéria:** Permite que o usuário visualize apenas as tarefas de uma matéria específica, facilitando o foco nos estudos.
* **Gerar Relatórios em PDF:** Cria um relatório completo com todas as tarefas cadastradas, que pode ser salvo ou impresso.

## Tecnologias Utilizadas

* **Backend:** Java, Servlets
* **Frontend:** JSP, HTML, CSS
* **Banco de Dados:** MySQL
* **Geração de PDF:** iTextPDF

## Estrutura do Projeto

O projeto é organizado seguindo o padrão MVC (Model-View-Controller):

* **Model:** As classes `JavaBeans.java` e `DAO.java` são responsáveis pela representação dos dados e pela comunicação com o banco de dados.
* **View:** Os arquivos `.jsp` e `.html` (`agenda.jsp`, `index.html`, `materia.html`, etc.) compõem a interface do usuário.
* **Controller:** A classe `Controler.java` é o servlet que gerencia as requisições do usuário e coordena a interação entre o Model e a View.

## Como Executar o Projeto

1.  **Pré-requisitos:**
    * Java JDK
    * Servidor de Aplicações (ex: Apache Tomcat)
    * Banco de Dados MySQL

2.  **Configuração do Banco de Dados:**
    * Crie um banco de dados no MySQL.
    * Importe o script SQL do banco de dados para criar as tabelas necessárias.
    * Atualize as credenciais de acesso ao banco de dados no arquivo `DAO.java`.

3.  **Deploy da Aplicação:**
    * Compile o projeto.
    * Faça o deploy do arquivo `.war` gerado no seu servidor de aplicações.
    * Acesse a aplicação através do seu navegador.
