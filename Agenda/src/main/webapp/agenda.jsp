<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
	@SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Task Every Day Baby</title>
<link rel="icon" href="imagens/352510_local_phone_icon.svg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="tit">Data de trabalhos</h1>
	<a href="novo.html" class="botao1">Novo Trabalho</a>
	<a href="materia.html" class="botao1">Materias</a>
	<a href="report" class="botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Data</th>
				<th>Tipo</th>
				<th>Matéria</th>
				<th>Descrição</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>

			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getData()%></td>
				<td><%=lista.get(i).getTipo()%></td>
				<td><%=lista.get(i).getMat()%></td>
				<td><%=lista.get(i).getDesc()%></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class=botao1>Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class=botao2>Excluir</a>
					</td>
			</tr>
			
			
			
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
	<div class="wrapper">
        
    
    <footer>
        <h>&copy; 2024 Tchunflay soluções Web. Todos os direitos reservados.</h>
    </footer>
</div>
</body>
</html>