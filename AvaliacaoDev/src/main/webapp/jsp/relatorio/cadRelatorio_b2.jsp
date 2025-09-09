<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><s:text name="label.titulo.pagina.consulta"/></title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Relatório de Compromissos</h2>
    <br>
    <table>
        <thead>
            <tr>
                <th>ID Compromisso</th>
                <th>ID Funcionário</th>
                <th>Nome Funcionário</th>
                <th>ID Agenda</th>
                <th>Nome Agenda</th>
                <th>Data Compromisso</th>
                <th>Horário Compromisso</th>
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