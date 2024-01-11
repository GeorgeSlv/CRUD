<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/listarProprietario" var="carregarDadosProp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de cadastros</title>
</head>
<body>
	Lista de proprietários e veiculos: <br/>
	<ul>
		<c:forEach items="${cadastros}" var="cadastros">
			<li>
				${cadastros.nome} - ${cadastros.cpf_cnpj} - ${cadastros.endereco}
				- ${cadastros.placa} - ${cadastros.renavam} - 
				<a href="/CRUD/mostraCad?id=${cadastros.id}">editar</a> - 
				<a href="/CRUD/removeCad?id=${cadastros.id}">deletar</a>
			</li>
		</c:forEach>	
	</ul>
	
	<form action="${ carregarDadosProp }" method="post">
		<input type="submit" value="Buscar"/>
	</form> <br />
	
	<form action="/CRUD/NovoCad.jsp" method="post">
		<input type="submit" value="Adicionar"/>
	</form>
	
</body>
</html>