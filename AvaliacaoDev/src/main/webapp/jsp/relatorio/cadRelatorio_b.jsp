<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><s:text name="label.titulo.pagina.consulta"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
		<link rel='stylesheet' href='css/custom.css'>
		<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css'>
		<script src='https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js'></script>
	</head>

	<body class="bg-secondary">

		<script>
            <c:if test="${!empty exception}">
                console.log('<s:property value="exception.message"/>');

				const notyf = new Notyf({
					duration: 2000,
  					position: {
    					x: 'right',
    					y: 'top'       
  					},
				  	dismissible: true, 
  					ripple: true
					});

				notyf.error('<s:property value="exception.message"/>');
            </c:if>
        </script>

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
        		<a href="${relatorios}" class="btn bg-btn-principal ms-auto">
            		<s:text name="label.relatorio"/>
        		</a>
    		</div>
		</div>

        <div class="container bg-light p-3 mt-4 mb-3 border rounded">
            <s:form>
                <div class="row align-items-center mt-3 g-3 mb-3">
                    <div class="col-sm-3 d-flex align-items-center">
                        <label for="datainicial" class="col-sm-4 col-form-label text-start">
                            <s:text name="label.data.inicial"/>
                        </label>
                        <div class="col-sm-8">
                            <s:textfield cssClass="form-control" id="datainicial" name="relatorioVo.dataInicial"/>
                        </div>
                    </div>

                    <div class="col-sm-3 d-flex align-items-center">
                        <label for="datafinal" class="col-sm-4 col-form-label text-start">
                            <s:text name="label.data.final"/>
                        </label>
                        <div class="col-sm-8">
                            <s:textfield cssClass="form-control" id="datafinal" name="relatorioVo.dataFinal"/>
                        </div>
                    </div>

                    <div class="col-sm-4 d-flex gap-3">
                        <s:submit 
                            key="label.formulario.baixar"
                            formaction="emitirRelatorios.action"
                            cssClass="btn btn-success" />

                        <s:submit 
                            key="label.formulario.imprimir"
                            formaction="imprimirRelatorios.action"
                            formtarget="_blank"
                            cssClass="btn btn-secondary" />
                    </div>
                </div>
            </s:form>
        </div>

		<script src='webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js'></script>
	</body>
</html>