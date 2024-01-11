<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoCad" var="linkServletNovoCad"/>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Cadastro</title>
</head>
<body>
	<form action="${ linkServletNovoCad }" method="post">
	
		Nome: <input type="text" name="name" />
		CPF/CNPJ: <input type="text" name="cpf_cnpj" />
		Endereço: <input type="text" name="endereco" />
		Placa: <input type="text" name="placa" />
		Renavam: <input type="text" name="renavam" />
		
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>