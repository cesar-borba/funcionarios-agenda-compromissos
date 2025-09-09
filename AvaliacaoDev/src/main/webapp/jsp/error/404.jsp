<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF8">
		<title><s:text name="label.titulo.pagina.consulta"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
		<link rel='stylesheet' href='css/custom.css'>
	</head>
	<body class="bg-secondary">
		
		<div class="container bg-light p-3 mt-4 mb-3 border rounded">
    		<div class="d-flex flex-row justify-content-start gap-4">
				<s:url action="todosFuncionarios" var="funcionarios"/>
        		<a href="${funcionarios}" class="btn bg-btn-navbar">
            		<s:text name="label.funcionarios"/>
        		</a>
                <s:url action="todosAgendas" var="agendas"/>
        		<a href="${agendas}" class="btn bg-btn-navbar">
            		<s:text name="label.agendas"/>
        		</a>
				<s:url action="todosCompromissos" var="compromissos"/>
        		<a href="${compromissos}" class="btn bg-btn-navbar">
            		<s:text name="label.compromissos"/>
        		</a>
				<s:url action="todosRelatorios" var="relatorios"/>
        		<a href="${relatorios}" class="btn bg-btn-navbar">
            		<s:text name="label.relatorio"/>
        		</a>
    		</div>
		</div>

		<div class="container text-danger bg-light mt-3 mb-3 p-3">
			<h1><s:text name="label.erro"/> 404</h1>
            <br>
    		<p>Página não encontrada :(</p>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>