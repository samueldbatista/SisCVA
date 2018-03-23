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
                $('.datePicker').datepicker(
                    {
                        format: "dd/mm/yyyy"
                    });

                $(".td-date").each(function () {
                    var date = $(this).text();
                    var dateMoment = moment().format(data, "dd/MM/yyyy");
                    console.log(dateMoment);
                })

            } );


        </script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Ocorrências do veículo"/>
        <tags:painel titulo="ocorrencia.titulo.cadastro" tipo="panel-default">
            <form action="${linkTo[OcorrenciaController].salvar}" method="post">
                <input type="hidden" name="ocorrencia.veiculo.id" value="${veiculo.id}">
                <input type="hidden" name="ocorrencia.id" value="${ocorrencia.id}">
                <div class="form-group">
                    <label for="ocorrencia">Ocorrencia:</label>
                    <input id="ocorrencia" type="text" name="ocorrencia.ocorrencia" value="${ocorrencia.ocorrencia}" class="form-control input-sm">
                </div>
                <div class="form-group">
                    <label for="data">Data:</label>
                    <input id="data" type="text" name="ocorrencia.data" value="${ocorrencia.data}" class="form-control datePicker input-sm">
                </div>
                <button class="btn btn-primary" style="float: right;" type="submit">Salvar</button>
            </form>
        </tags:painel>

        <tags:painel titulo="ocorrencia.titulo.lista" tipo="panel-default">
            <div class="tabela-deprov">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Ocorrencia</th>
                        <th>Data</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ocorrencias}" var="ocorrencia">
                        <tr>
                            <td>${ocorrencia.id}</td>
                            <td>${ocorrencia.ocorrencia}</td>
                            <td><span class="td-date">${ocorrencia.data}</span></td>
                            <td>
                                <a title="Editar" href="${linkTo[OcorrenciaController].editar}?id=${ocorrencia.id}" ><i class="fa fa-edit fa-lg"></i></a>
                                <a title="Remover" class="btns-remocao" href="#modal-remocao" data-toggle="modal" url-remocao="${linkTo[OcorrenciaController].remover}?id=${ocorrencia.id}" ><i class="fa fa-trash fa-lg"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </tags:painel>
    </jsp:body>
</tags:layout>
