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
        <style>
            .painel-cadastro {
                border-radius: 0px;
                border-right: 1px solid #dddddd;
                border-bottom: 1px solid #dddddd;
                border-left: 1px solid #dddddd;
            }

            .form-group {
                margin-bottom: 4px;
            }
        </style>
    </jsp:attribute>
    <jsp:attribute name="rodape">
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Foto do veículo"/>
        <c:if test="${administradorMaster}">
        <tags:painel titulo="usuario.titulo.cadastro">
            <form action="${linkTo[VeiculoController].salvarFotos}" method="post" enctype="multipart/form-data">
                <%--<div class="form-group">--%>
                    <%--<label for="nome-usuario">Nome:</label>--%>
                    <input id="nome-usuario" type="hidden" name="veiculo.id" value="${veiculo.id}">
                <%--</div>--%>
                <input type="file" name="foto"/>
                <button class="btn btn-primary" type="submit" style="float: right; margin-top: 16px;">Salvar</button>
            </form>
        </tags:painel>
        </c:if>
        <div id="foto-container" class="row" style="margin-top: 16px;">
            <c:forEach items="${fotos}" var="foto">
                <div class="col-md-6" style="margin-bottom: 16px;">
                    <img class="img-carro" src="${foto.path}" style="width: 504px; height: 304px; box-shadow:2px 2px 2px 2px #ddd;"/>
                </div>
            </c:forEach>
        </div>


    </jsp:body>
</tags:layout>
