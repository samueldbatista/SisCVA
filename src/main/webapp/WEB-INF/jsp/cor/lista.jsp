<%--
  Created by IntelliJ IDEA.
  User: samue
  Date: 08/09/2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            $(document).ready(function () {
                $('table').dataTable();
            });
        </script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Cores"/>
        <tags:painel titulo="cor.titulo.cadastro" tipo="panel-default">
            <form action="${linkTo[CorController].salvar}" method="post">
                <div class="form-group">
                    <label for="cor">Cor:</label>
                    <input id="cor" type="text" name="cor.cor" value="${cor.cor}" class="form-control input-sm">
                </div>
                <button class="btn btn-primary" style="float: right;" type="submit">Salvar</button>
            </form>
        </tags:painel>

        <tags:painel titulo="cor.titulo.lista" tipo="panel-default">
            <div class="tabela-deprov">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cor</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cores}" var="cor">
                        <tr>
                            <td>${cor.id}</td>
                            <td>${cor.cor}</td>
                            <td>
                                <a title="Remover" class="btns-remocao" href="#modal-remocao" data-toggle="modal" url-remocao="${linkTo[CorController].remover}?id=${cor.id}"><i
                                        class="fa fa-trash fa-lg"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </tags:painel>
    </jsp:body>
</tags:layout>
