<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Every Day Baby</title>
<link rel="icon" href="imagens/352510_local_phone_icon.svg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1 class="tit">Editar trabalho</h1>

	<form name="frmContato" action="update" id="core">
		<table>
			<tr>
				<td><label for="idcon" class="pd2">ID:</label> <input
					type="text" id="idcon" name="idcon" class="cx2" readonly
					value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				  <tr>
                <td>
                    <label for="tipo" class="mt">Tipo:</label>
                    <textarea type="text" id="tipo" name="tipo"
					class="cx"
					><%out.print(request.getAttribute("tipo"));%></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="mat" class="mt">Matéria:</label>
                    <textarea type="text" id="mat" name="mat"
					class="cx"
					><%out.print(request.getAttribute("mat"));%></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="desc" class="mt">Descrição:</label>
                    <textarea type="text" id="desc" name="desc"
					class="cx"
					><%out.print(request.getAttribute("desc"));%></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="data" class="mt">Data de Entrega:</label>
                    <input type="date" id="data" name="data"
					class="caixa1"
					value="<%out.print(request.getAttribute("data"));%>">
                </td>
            </tr>
        </table>
        <input type="button" value="Salvar" class="botao1"
			onclick="validar()">
    </form>
    <script src="scripts/validador.js"></script>
    <div class="wrapper">
        <footer>
            <h>&copy; 2024 Tchunflay soluções Web. Todos os direitos reservados.</h>
        </footer>
    </div>
</body>
</html>
