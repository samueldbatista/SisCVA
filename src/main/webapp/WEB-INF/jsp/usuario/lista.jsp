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
        <tags:painel titulo="usuario.titulo.lista" tipo="panel-default">
            <div class="btn-container" style="margin-bottom: 16px;">
                <a class="btn btn-info" href="${linkTo[UsuarioController].form}">Cadastrar</a>
            </div>

            <div class="tabela-deprov">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Função</th>
                        <th>Delegacia</th>
                        <th>Permissão</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr>
                            <td>${usuario.id}</td>
                            <td>${usuario.nome}</td>
                            <td>${usuario.funcaoUsuario.chave}</td>
                            <td>${usuario.delegacia.nome}</td>
                            <td>${usuario.perfil.chave}</td>
                            <td>
                                <a title="Editar" href="${linkTo[UsuarioController].editar}?id=${usuario.id}" ><i class="fa fa-edit fa-lg"></i></a>
                                <a class="btns-remocao" href="#modal-remocao" data-toggle="modal" title="Remover" url-remocao="${linkTo[UsuarioController].remover}?id=${usuario.id}"
                                    ><i class="fa fa-trash fa-lg"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </tags:painel>
    </jsp:body>
</tags:layout>
