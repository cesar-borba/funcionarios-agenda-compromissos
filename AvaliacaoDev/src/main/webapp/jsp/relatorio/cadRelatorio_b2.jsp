<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><s:text name="label.titulo.pagina.consulta"/></title>
    <link rel='stylesheet' href='css/table.css'>
</head>
<body>
    <h2><s:text name="label.titulo.pagina.consulta"/></h2>
    <br>
    <table>
        <thead>
            <tr>
                <th><s:text name="label.relatorio.id.compromisso"/></th>
                <th><s:text name="label.relatorio.id.funcionario"/></th>
                <th><s:text name="label.relatorio.nome.funcionario"/></th>
                <th><s:text name="label.relatorio.id.agenda"/></th>
                <th><s:text name="label.relatorio.nome.agenda"/></th>
                <th><s:text name="label.relatorio.data"/></th>
                <th><s:text name="label.relatorio.horario"/></th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="compromissos" var="compromisso">
                <tr>
                    <td><s:property value="#compromisso.rowid"/></td>
                    <td><s:property value="#compromisso.rowidFuncionario"/></td>
                    <td><s:property value="businessFuncionario.buscarFuncionarioPor(#compromisso.rowidFuncionario).nome"/></td>
                    <td><s:property value="#compromisso.rowidAgenda"/></td>
                    <td><s:property value="businessAgenda.buscarAgendaPor(#compromisso.rowidAgenda).nome"/></td>
                    <td><s:property value="#compromisso.data"/></td>
                    <td><s:property value="#compromisso.horario"/></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>