<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alterarCad" var="linkServletNovoCad"/>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Cadastro</title>
</head>
<body>
	<form action="${ linkServletNovoCad }" method="post">
	
		Nome: <input type="text" name="name" value="${cadastros.nome}"/>
		CPF/CNPJ: <input type="text" name="cpf_cnpj" value="${cadastros.cpf_cnpj}"/>
		Endereço: <input type="text" name="endereco" value="${cadastros.endereco}"/>
		Placa: <input type="text" name="placa" value="${cadastros.placa}"/>
		Renavam: <input type="text" name="renavam" value="${cadastros.renavam}"/>
		<input type="hidden" name="id" value="${cadastros.id}"/>
		
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>