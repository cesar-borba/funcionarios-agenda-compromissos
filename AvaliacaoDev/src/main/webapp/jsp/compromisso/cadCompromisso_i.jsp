<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><s:text name="label.titulo.pagina.cadastro"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
		<link rel='stylesheet' href='css/custom.css'>
	</head>
	<body class="bg-secondary">

		<div class="container">
			<s:if test="#request['struts.actionMapping'].name == 'novoCompromissos'">
				<s:url action="novoCompromissos" var="metodoAction" includeContext="false"/>
			</s:if>
			<s:elseif test="#request['struts.actionMapping'].name == 'editarCompromissos'">
				<s:url action="atualizarCompromissos" var="metodoAction" includeContext="false"/>
			</s:elseif>
			<s:form action="%{metodoAction}">

				<div class="card mt-5">
					<div class="card-header">
						<div class="row">
							<div class="col-sm-5">
								<s:url action="todosCompromissos" var="todos"/>
								<a href="${todos}" class="btn bg-btn-principal">
									<s:text name="label.compromissos"/>
								</a>
							</div>
							
							<div class="col-sm d-flex align-items-center">
								<h5 class="card-title">
									<s:if test="#request['struts.actionMapping'].name == 'novoCompromissos'">
										<s:text name="label.cadastro.novo"/>
									</s:if>
									<s:elseif test="#request['struts.actionMapping'].name == 'editarCompromissos'">
										<s:text name="label.cadastro.atualizar"/>
									</s:elseif>
								</h5>
							</div>
						</div>
					</div>
					
					<div class="card-body">
						<div class="row align-items-center">
							<label for="rowid" class="col-sm-2 col-form-label text-start">
								<s:text name="label.formulario.cod.compromisso"/>
							</label>	

							<div class="col-sm-1">
								<s:textfield cssClass="form-control" id="rowid" name="compromissoVo.rowid" readonly="true"/>
							</div>
						</div>

                        <div class="row align-items-center mt-3">
							<label for="rowidfuncionario" class="col-sm-2 col-form-label text-start">
								<s:text name="label.formulario.cod.funcionario"/>
							</label>

							<div class="col-sm-1">
								<s:textfield cssClass="form-control" id="rowidfuncionario" name="compromissoVo.rowidFuncionario"/>							
							</div>
						</div>

                        <div class="row align-items-center mt-3">
							<label for="rowidagenda" class="col-sm-2 col-form-label text-start">
								<s:text name="label.formulario.cod.agenda"/>
							</label>

							<div class="col-sm-1">
								<s:textfield cssClass="form-control" id="rowidagenda" name="compromissoVo.rowidAgenda"/>							
							</div>
						</div>
						
						<div class="row align-items-center mt-3">
							<label for="data" class="col-sm-2 col-form-label text-start">
								<s:text name="label.formulario.data"/>
							</label>	

							<div class="col-sm-2">
								<s:textfield cssClass="form-control" id="data" name="compromissoVo.data"/>							
							</div>
						</div>

						<div class="row align-items-center mt-3">
							<label for="horario" class="col-sm-2 col-form-label text-start">
								<s:text name="label.formulario.horario"/>
							</label>

                            <div class="col-sm-2">
								<s:textfield cssClass="form-control" id="horario" name="compromissoVo.horario"/>							
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
				document.getElementById('rowidfuncionario').value = '';
				document.getElementById('rowidagenda').value = '';
                document.getElementById('data').value = '';
				document.getElementById('horario').value = '';
			}
		</script>
	</body>
</html>