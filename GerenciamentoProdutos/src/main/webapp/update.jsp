<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="model.Product"%>
<%@page import="dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%Product product = new Product();%> --%>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">

<nav class="navbar" role="navigation" aria-label="main navigation">
	<div class="navbar-brand">
		<a class="navbar-item" href="/GerenciamentoProdutos/index.html"> <img
			src="Imagens/pm_logo.png" width="112" height="28">
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
<title>Gerenciamento de Produto</title>
</head>

<body>
	<h1>Atualizar Produto</h1>
	<form action="update">

		<div class="field">
			<label class="label">ID</label>
			<div class="control">
				<input class="input" type="text" name="id" readonly
					value="<%out.println(request.getAttribute("id"));%>">
			</div>
		</div>
		<div class="field">
			<label class="label">Código de Barras</label>
			<div class="control">
				<input class="input" type="text" name="barcode"
					value="<%out.println(request.getAttribute("barcode"));%>">
			</div>
		</div>
		<div class="field">
			<label class="label">Nome</label>
			<div class="control">
				<input class="input" type="text" name="name"
					value="<%out.println(request.getAttribute("name"));%>">
			</div>
		</div>
		<div class="field">
			<label class="label">Categoria</label>
			<div class="control">
				<input class="input" type="text" name="category"
					value="<%out.println(request.getAttribute("category"));%>">
			</div>
		</div>
		<div class="field">
			<label class="label">Preço</label>
			<div class="control">
				<input class="input" type="text" name="price"
					value="<%out.println(request.getAttribute("price"));%>">
			</div>
		</div>
		<div class="field">
			<label class="label">Quantidade</label>
			<div class="control">
				<input class="input" type="text" name="quantity"
					value="<%out.println(request.getAttribute("quantity"));%>">
			</div>
		</div>
		<div class="field is-grouped">
			<div class="control">
				<button class="button is-link" type="submit">Atualizar</button>
			</div>
			<div class="control">
				<button class="button is-link is-light" type="button"
					href="/GerenciamentoProdutos/list">Cancelar</button>
			</div>
		</div>
	</form>
</body>
</html>