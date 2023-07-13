<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista Telefonica</title>
</head>
<body>
	<div align="center">
		<h1>Gerenciamento de Livros</h1>
		<h2>
			<a href="/${requestScope.contextPath}">Menu Principal</a> &nbsp;&nbsp;&nbsp; 
			<a href="/${requestScope.contextPath}/pessoas/cadastro">Adicione Nova Pessoa</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Pessoas</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Estado</th>
				<th>Cidade</th>
				<th>Ocupação</th>
				<th>Acões</th>
			</tr>
			<c:forEach var="pessoa" items="${requestScope.listaPessoas}">
				<tr>
					<td>${pessoa.id}</td>
					<td>${pessoa.nome}</td>
					<td>${pessoa.telefone}</td>
					<td>${pessoa.estado}</td>
					<td>${pessoa.cidade}</td>
					<td>${pessoa.ocupacao}</td>
					<td><a href="/${requestScope.contextPath}/pessoas/edicao?id=${pessoa.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/${requestScope.contextPath}/pessoas/remocao?id=${pessoa.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>