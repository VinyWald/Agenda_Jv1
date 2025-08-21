<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
	@SuppressWarnings("unchecked")
	
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<% String gg=""; %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Task Every Day Baby</title>
<link rel="icon" href="imagens/352510_local_phone_icon.svg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="tit">Gerar Trabalhos</h1>
	
	<a href="materia.html" class="botao1">Voltar</a>
	
	<table id="tabela">
		<thead>
			<tr>
				
				<th>Data</th>
				<th>Tipo</th>
				<th>Matéria</th>
				<th>Descrição</th>
				
			</tr>
		</thead>
		<tbody>
					
			
			
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			
			<tr>
				
				<td><%=lista.get(i).getData()%></td>
				
				<td><%=lista.get(i).getTipo()%></td>
				<td><%=gg=lista.get(1).getMat()%></td>
				<td><%=lista.get(i).getDesc()%></td>
				
			</tr>
			
			<%
			}
			%>
		</tbody>
	</table>
	
<form action="insert2" >
    <button type="submit" name="ggg"class="botao1" value="<%= gg %>">GERAR</button>
</form>

	<div class="wrapper">
        
    
    <footer>
        <h>&copy; 2024 Tchunflay soluções Web. Todos os direitos reservados.</h>
    </footer>
</div>
</body>
</html>