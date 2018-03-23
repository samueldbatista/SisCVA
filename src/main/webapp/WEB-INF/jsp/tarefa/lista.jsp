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
        <tags:header titulo="Tarefas do veículo"/>
        <tags:painel titulo="tarefa.titulo.cadastro" tipo="panel-default">
            <form action="${linkTo[TarefaController].salvar}" method="post">
                <input type="hidden" name="tarefa.veiculo.id" value="${veiculo.id}">
                <input type="hidden" name="tarefa.id" value="${tarefa.id}">
                <div class="form-group">
                    <label for="tarefa">decricao:</label>
                    <input id="tarefa" type="text" name="tarefa.descricaoTarefa" value="${tarefa.descricaoTarefa}"
                           class="form-control input-sm">
                </div>
                <div class="form-group">
                    <label for="data">Data:</label>
                    <input id="data" type="text" name="tarefa.dataTarefa" value="${tarefa.dataTarefa}"
                           class="form-control input-sm">
                </div>
                <button class="btn btn-primary" style="float: right;" type="submit">Salvar</button>
            </form>
        </tags:painel>

        <tags:painel titulo="tarefa.titulo.lista" tipo="panel-default">
            <div class="tabela-deprov">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tarefa</th>
                        <th>Data</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tarefas}" var="tarefa">
                        <tr>
                            <td>${tarefa.id}</td>
                            <td>${tarefa.descricaoTarefa}</td>
                            <td>${tarefa.dataTarefa}</td>
                            <td>
                                <a title="Editar" href="${linkTo[TarefaController].editar}?id=${tarefa.id}"><i
                                        class="fa fa-edit fa-lg"></i></a>
                                <a title="Remover" class="btns-remocao" href="#modal-remocao" data-toggle="modal" url-remocao="${linkTo[TarefaController].remover}?id=${tarefa.id}"><i
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

