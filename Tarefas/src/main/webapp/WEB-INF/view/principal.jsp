<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Tarefa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes Tarefa</title>
</head>
<body>

<h1>Tarefa: <i>${ tarefa.titulo }</i></h1>
<h2>Dados:</h2>
<table border="1" style="width: 80%">
	<tr>
		<td>Descicao<td>
		<td>${ tarefa.descricao }</td>
	</tr>
	<tr>
		<td>Data criação<td>
		<td>${ tarefa.data_criacao }</td>
	</tr>
	<tr>
		<td>Data finalização<td>
		<td>${ tarefa.data_conclusao }</td>
	</tr>
</table>
	 <input type="submit" value="Submit" />
	
</body>