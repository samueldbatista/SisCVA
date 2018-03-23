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
        <tags:painel titulo="usuario.titulo.cadastro">
            <form action="${linkTo[UsuarioController].salvar}" method="post">
                <input name="usuario.id" type="hidden" value="${usuario.id}">
                <div class="form-group">
                    <label for="nome-usuario">Nome:</label>
                    <input id="nome-usuario" type="text" name="usuario.nome" value="${usuario.nome}" class="form-control input-sm">
                </div>

                <div class="form-group">
                    <label for="login-usuario">Login:</label>
                    <input id="login-usuario" type="text" name="usuario.login" value="${usuario.login}" class="form-control input-sm">
                </div>

                <div class="form-group">
                    <label for="senha-usuario">Senha:</label>
                    <input id="senha-usuario" type="password" name="usuario.senha" value="${usuario.senha}" class="form-control input-sm">
                </div>

                <label for="perfil-usuario">Perfil</label>
                <select class="form-control input-sm" id="perfil-usuario" name="usuario.perfil">
                    <option value=""></option>
                    <c:forEach items="${perfis}" var="perfil">
                        <c:if test="${perfil.valor == usuario.perfil.valor}">
                            <option value="${perfil.valor}"
                                    selected="true">${perfil.chave}</option>
                        </c:if>
                        <c:if test="${!(perfil.valor == usuario.perfil.valor)}">
                            <option value="${perfil.valor}">${perfil.chave}</option>
                        </c:if>
                    </c:forEach>
                </select>

                <label for="delegacia-usuario">Delegacia</label>
                <select class="form-control input-sm" id="delegacia-usuario" name="usuario.delegacia.id">
                    <option value=""></option>
                    <c:forEach items="${delegacias}" var="delegacia">
                        <c:if test="${delegacia.valor == usuario.delegacia.id}">
                            <option value="${delegacia.valor}"
                                    selected="true">${delegacia.chave}</option>
                        </c:if>
                        <c:if test="${!(delegacia.valor == usuario.delegacia.id)}">
                            <option value="${delegacia.valor}">${delegacia.chave}</option>
                        </c:if>
                    </c:forEach>
                </select>

                <label for="funcao-usuario">Função</label>
                <select class="form-control input-sm" id="funcao-usuario" name="usuario.funcaoUsuario">
                    <option value=""></option>
                    <c:forEach items="${funcaoUsuario}" var="funcao">
                        <c:if test="${funcao.valor == usuario.funcaoUsuario.valor}">
                            <option value="${funcao.valor}"
                                    selected="true">${funcao.chave}</option>
                        </c:if>
                        <c:if test="${!(funcao.valor == usuario.funcaoUsuario.valor)}">
                            <option value="${funcao.valor}">${funcao.chave}</option>
                        </c:if>
                    </c:forEach>
                </select>

                <button class="btn btn-primary" type="submit" style="float: right; margin-top: 16px;">Salvar</button>
            </form>
        </tags:painel>

    </jsp:body>
</tags:layout>
