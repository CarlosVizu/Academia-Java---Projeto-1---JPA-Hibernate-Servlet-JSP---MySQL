<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
ProductDao dao = new ProductDao();
ArrayList<Product> lista = new ArrayList<>(dao.listProducts());
	
%>
<!DOCTYPE html>
<html lang="pt-br">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">

<nav class="navbar" role="navigation" aria-label="main navigation">
	<div class="navbar-brand">
		<a class="navbar-item" href="/GerenciamentoProdutos/index.html"> 
		<img src="Imagens/pm_logo.png" width="112" height="28">
		</a> <a role="button" class="navbar-burger"
			href="/GerenciamentoProdutos/insert.html" aria-label="menu"
			aria-expanded="false" data-target="navbarBasicExample"> <span
			aria-hidden="true"></span> <span aria-hidden="true"></span> <span
			aria-hidden="true"></span>
		</a>
	</div>

	<div id="navbarBasicExample" class="navbar-menu">
		<div class="navbar-start">
			<a class="navbar-item" href="/GerenciamentoProdutos/insert.html">
				Novo Produto </a> <a class="navbar-item"
				href="/GerenciamentoProdutos/list"> Gerenciar Produtos </a>
		</div>
	</div>
</nav>


<head>
<meta charset="UTF-8">
<title>Gerenciamento de Produto</title>
</head>

<body>
	<center>
		<h1>Gerenciamento de Produto</h1>

	</center>

	<div align="center">
		<table border="1" cellpadding="5" class="table">
			<thead>
				<tr>
					<th align="center">Código</th>
					<th align="center">Nome</th>
					<th align="center">Categoria</th>
					<th align="center">Preço</th>
					<th align="center">Quantidade</th>
					<th align="center">Ações</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${lista}" var="product">
					<tr>
						<td align="center"><c:out value="${product.barcode}" /></td>
						<td align="center"><c:out value="${product.name}" /></td>
						<td align="center"><c:out value="${product.category}" /></td>
						<td align="center"><c:out value="${product.price}" /></td>
						<td align="center"><c:out value="${product.quantity}" /></td>
						<td align="center"><a href="edit?id=<c:out value="${product.id}" />">Editar</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="delete?id=<c:out value="${product.id}" />">Deletar</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</body>
</html>