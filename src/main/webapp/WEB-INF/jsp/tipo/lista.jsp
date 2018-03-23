<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 08/09/2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="tagSisInt" %>
<%@ taglib prefix="td" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<tags:layout>
    <jsp:attribute name="cabecalho">
        <link href="${ctx}/resources/css/geral.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataTables/Buttons-1.5.1/css/buttons.bootstrap.min.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataTables/Buttons-1.5.1/css/buttons.dataTables.min.css" rel="stylesheet"/>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/moment/moment-with-locales.js"></script>
        <script src="${ctx}/resources/plugins/moment/moment.js"></script>
        <script src="${ctx}/resources/plugins/dataTables/datatables.js"></script>
        <script src="${ctx}/resources/plugins/moment/date-time-moment.js"></script>
        <script>

            $(document).ready(function() {
                $('table').dataTable();
            } );

        </script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Tipos de veículo"/>
        <tags:painel titulo="tipo.titulo.cadastro" tipo="panel-default">
            <form action="${linkTo[TipoController].salvar}" method="post">
                <div class="form-group">
                    <label for="tipo">Tipo:</label>
                    <input id="tipo" type="text" name="tipo.tipo" value="${tipo.tipo}" class="form-control input-sm">
                </div>
                <button class="btn btn-primary" style="float: right;" type="submit">Salvar</button>
            </form>
        </tags:painel>

        <tags:painel titulo="tipo.titulo.lista" tipo="panel-default">
            <div class="tabela-deprov">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tipo</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tipos}" var="tipo">
                        <tr>
                            <td>${tipo.id}</td>
                            <td>${tipo.tipo}</td>
                            <td>
                                <a class="btns-remocao" title="Remover" url-remocao="${linkTo[TipoController].remover}?id=${tipo.id}" data-toggle="modal" href="#modal-remocao" ><i class="fa fa-trash fa-lg"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </tags:painel>

    </jsp:body>
</tags:layout>
