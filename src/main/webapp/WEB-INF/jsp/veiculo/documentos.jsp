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
<!DOCTYPE html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<tags:layout>
    <jsp:attribute name="cabecalho">
        <link href="${ctx}/resources/css/geral.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataTables/Buttons-1.5.1/css/buttons.bootstrap.min.css" rel="stylesheet"/>
        <link href="${ctx}/resources/plugins/dataTables/Buttons-1.5.1/css/buttons.dataTables.min.css" rel="stylesheet"/>
        <style>
            .controlBtnTables {
                margin-bottom: 8px;
            }
        </style>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script src="${ctx}/resources/plugins/moment/moment-with-locales.js"></script>
        <script src="${ctx}/resources/plugins/moment/moment.js"></script>
        <script>
            $('.timestamp').each(function () {
               var timestamp = $(this).text();
               console.log(timestamp);
               // timestamp = moment(timestamp).format("DD/MM/YYYY HH:mm");
               $(this).text(moment(timestamp).format("DD/MM/YYYY HH:mm"));
            });
        </script>

    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Gerenciamento de documentos do veículo ${veiculo.modelo.modelo} de dossiê: ${veiculo.dadosOcorrencia.dossie}"/>
        <tags:painel titulo="documento.titulo.cadastro">
            <form action="${linkTo[VeiculoController].salvarDocumento}" method="post" enctype="multipart/form-data">
                <input id="veiculo-id" type="hidden" name="veiculo.id" value="${veiculo.id}">
                <div class="form-group">
                    <label for="doc-descricao">Descrição:</label>
                    <input id="doc-descricao" type="text" name="informacao.descricao" required class="form-control input-sm">
                </div>
                    <%--</div>--%>
                <input type="file" name="documento"/>
                <button class="btn btn-primary" type="submit" style="float: right; margin-top: 16px;">Salvar</button>
            </form>
        </tags:painel>

        <tags:painel titulo="veiculo.documentos" tipo="panel-default">
            <div class="list-group">
                <c:forEach items="${veiculo.documentos}" var="doc">
                    <a href="${doc.path}" class="list-group-item list-group-item-action">
                            ${doc.descricao}<span class="badge timestamp">${doc.data}</span>
                    </a>
                </c:forEach>
            </div>
        </tags:painel>
    </jsp:body>
</tags:layout>
