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
				<s:url action="todosFuncionarios" var="funcionarios"/>
        		<a href="${funcionarios}" class="btn bg-btn-principal ms-auto">
            		<s:text name="label.funcionarios"/>
        		</a>
    		</div>
		</div>

		<div class="container">
			<div class="row mt-3 mb-2">
				<div class="col-sm p-0">
					<s:form action="/filtrarFuncionarios.action">
						<div class="input-group">
							<span class="input-group-text">
								<strong><s:text name="label.buscar.por"/></strong>
							</span>	
								<s:select  
									cssClass="form-select" 
									name="filtrar.opcoesCombo" 
									list="listaOpcoesCombo"  
									headerKey=""  
									headerValue="Escolha..." 
									listKey="%{codigo}" 
									listValueKey="%{descricao}"
									value="filtrar.opcoesCombo.codigo"
								/>
								
								<s:textfield cssClass="form-control" id="nome" name="filtrar.valorBusca"/>
								<button class="btn btn-primary" type="submit"><s:text name="label.pesquisar"/></button>
						</div>
					</s:form>			
				</div>				
			</div>

			<div class="row">
				<table class="table table-light table-striped align-middle">
					<thead>
						<tr>
							<th><s:text name="label.id"/></th>
							<th><s:text name="label.nome"/></th>
							<th class="text-end mt-5"><s:text name="label.acao"/></th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="funcionarios">
							<c:if test="${(rowid != null) && (nome != null)}">
								<tr>
									<td>${rowid}</td>
									<td>${nome}</td>
									<td class="text-end">
										<s:url action="editarFuncionarios" var="editar">
											<s:param name="funcionarioVo.rowid" value="rowid"></s:param>
										</s:url>

										<a href="${editar}" class="btn btn-warning text-white">
											<s:text name="label.editar"/>
										</a>

										<a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmarExclusao">
											<s:text name="label.excluir"/>
										</a>
									</td>
								</tr>
							</c:if>
						</s:iterator>
					</tbody>
					
					<tfoot class="table-secondary">
						<tr>
							<td colspan="3">
								<s:url action="novoFuncionarios" var="novo"/>
									
								<a href="${novo}" class="btn btn-success">
									<s:text name="label.novo"/>
								</a>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>

			<div class="row">

			</div>
		</div>
		
		<div class="modal fade" id="confirmarExclusao" 
			data-bs-backdrop="static" data-bs-keyboard="false"
			tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    	<div class="modal-header">
		    		<h5 class="modal-title"><s:text name="label.modal.titulo"/></h5>
		        
		        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		    	</div>
		      
		    	<div class="modal-body">
		      		<span><s:text name="label.modal.corpo"/></span>
					<br>
					<br>
					<span class="text-danger"><s:text name="label.modal.aviso"/></span>
				</div>
		      
		      <div class="modal-footer">
	        	<a class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">
					<s:text name="label.nao"/>
				</a>
	        	
				<s:a id="excluir" class="btn btn-primary" style="width: 75px;">
					<s:text name="label.sim"/>
				</s:a>
		      </div>
		    </div>		    
		  </div>
		</div>

		<script>
			const modalExclusao = document.getElementById('confirmarExclusao');
			
			modalExclusao.addEventListener('show.bs.modal', function(event) {
				const botao = event.relatedTarget; 

				const row = botao.closest('tr');

				const rowid = row.querySelector('td').textContent;

				const botaoExcluir = document.getElementById('excluir');

				const url = "/avaliacao/excluirFuncionarios.action?funcionarioVo.rowid=" + rowid;

				botaoExcluir.href = url;
			});
		</script>

		<script src='webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js'></script>
	</body>
</html>