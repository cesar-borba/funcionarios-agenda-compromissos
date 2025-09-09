<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><s:text name="label.titulo.pagina.cadastro"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
		<link rel='stylesheet' href='css/custom.css'>
		<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css'>
		<script src='https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js'></script>
	</head>
	<body class="bg-secondary">

		<div class="container">
			<s:if test="#request['struts.actionMapping'].name == 'novoFuncionarios'">
				<s:url action="novoFuncionarios" var="metodoAction" includeContext="false"/>
			</s:if>
			<s:elseif test="#request['struts.actionMapping'].name == 'editarFuncionarios'">
				<s:url action="atualizarFuncionarios" var="metodoAction" includeContext="false"/>
			</s:elseif>
			<s:form action="%{metodoAction}">

				<div class="card mt-5">
					<div class="card-header">
						<div class="row">
							<div class="col-sm-5">
								<s:url action="todosFuncionarios" var="todos"/>
								<a href="${todos}" class="btn bg-btn-principal">
									<s:text name="label.funcionarios"/>
								</a>
							</div>
							
							<div class="col-sm d-flex align-items-center">
								<h5 class="card-title">
									<s:if test="#request['struts.actionMapping'].name == 'novoFuncionarios'">
										<s:text name="label.cadastro.novo"/>
									</s:if>
									<s:elseif test="#request['struts.actionMapping'].name == 'editarFuncionarios'">
										<s:text name="label.cadastro.atualizar"/>
									</s:elseif>			
								</h5>
							</div>
						</div>
					</div>
					
					<div class="card-body">
						<div class="row align-items-center">
							<label for="id" class="col-sm-1 col-form-label text-center">
								<s:text name="label.formulario.codigo"/>
							</label>	

							<div class="col-sm-2">
								<s:textfield cssClass="form-control" id="id" name="funcionarioVo.rowid" readonly="true"/>					
							</div>
						</div>
						
						<div class="row align-items-center mt-3">
							<label for="nome" class="col-sm-1 col-form-label text-center">
								<s:text name="label.formulario.nome"/>
							</label>	

							<div class="col-sm-5">
								<s:textfield cssClass="form-control" id="nome" name="funcionarioVo.nome"/>							
							</div>	
						</div>
					</div>

					<div class="card-footer">
						<div class="form-row">
							<button class="btn btn-primary col-sm-4 offset-sm-1">
								<s:text name="label.formulario.salvar"/>
							</button>
							<button type="button" class="btn btn-secondary col-sm-4 offset-sm-2" onclick="limparFormulario()">
								<s:text name="label.formulario.limpar"/>
							</button>
						</div>
					</div>
				</div>
			</s:form>			
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

		<script>
			function limparFormulario() {
				document.getElementById('nome').value = '';
			}
		</script>
	</body>
</html>