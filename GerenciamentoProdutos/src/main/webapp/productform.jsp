<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<title>Gerenciamento de Produto</title>

</head>
<body>
	<center>
		<h1>Gerenciamento de Produto</h1>

		<h2>
			<a href="/GerenciamentoProdutos/insert.html">Novo Produto</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href="/GerenciamentoProdutos/list?action=list" method="get">Listar Produtos</a>
		</h2>
	</center>

	<div align="center">
		<c:if test="${user!= null}">
			<form action="update" method="post">
		</c:if>

		<c:if test="${user == null}">
			<form action="insert" method="post">
		</c:if>

		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${user != null}">
				Editar Produto
			</c:if>
					<c:if test="${user == null}">
				Adicionar Novo Produto
			</c:if>
				</h2>
			</caption>

			<c:if test="${user != null}">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			</c:if>
			<tr>
				<th>Código do produto:</th>
				<td><input type="text" name="barcode" size="45"
					value="<c:out value="${product.barcode}" />" /></td>
			<tr>
			<tr>
				<th>Nome do produto:</th>
				<td><input type="text" name="nome" size="45"
					value="<c:out value="${product.name}" />" /></td>
			<tr>
				<th>Categoria do produto:</th>
				<td><input type="text" name="category" size="45"
					value="<c:out value="${product.category}" />" /></td>
			<tr>
				<th>Preço do produto:</th>
				<td><input type="text" name="price" size="45"
					value="<c:out value="${product.price}" />" /></td>
			<tr>
			<tr>
				<th>Quantidade do produto:</th>
				<td><input type="text" name="quantity" size="45"
					value="<c:out value="${product.quantity}" />" /></td>
			<tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit"
					value="Save" /></td>
			</tr>
		</table>
	</div>
</body>
</html>