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

        </style>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script>
            $("#btn-modificar").on('click', function () {
                $("#modificar-senha").show();
            })
        </script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Perfil do usuario"/>
        <div class="panel painel-deprov">
            <div class="panel-body">
                <form class="form-horizontal" action="${linkTo[UsuarioController].alterarSenha}" method="post">
                    <input hidden name="usuario.id" value="${usuario.id}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nome:</label>
                        <div class="col-sm-10">
                            <input name="usuario.nome" value="${usuario.nome}" class="form-control" id="focusedInput" type="text" value="Nome do usuário">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="login-input" class="col-sm-2 control-label">Login:</label>
                        <div class="col-sm-10">
                            <input name="usuario.login" value="${usuario.login}" class="form-control" id="login-input" type="text" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cargo-input" class="col-sm-2 control-label">Função:</label>
                        <div class="col-sm-10">
                            <input value="${usuario.funcaoUsuario.chave}" class="form-control" id="cargo-input" type="text" readonly>
                        </div>
                    </div>
                    <input hidden name="usuario.delegacia.id" value="${usuario.delegacia.id}">
                    <div class="col-sm-12" align="right" style="margin-bottom: 16px;">
                        <button type="button" class="btn btn-success" id="btn-modificar">Modificar senha</button>
                    </div>
                    <div id="modificar-senha" style="display: none;">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Senha atual:</label>
                            <div class="col-sm-10">
                                <input name="senhaAtual" class="form-control" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="login-input" class="col-sm-2 control-label">Nova senha:</label>
                            <div class="col-sm-10">
                                <input name="usuario.senha" class="form-control" type="password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cargo-input" class="col-sm-2 control-label">Confirmar senha:</label>
                            <div class="col-sm-10">
                                <input name="confirmaSenha" class="form-control" type="password">
                            </div>
                        </div>
                        <button type="submit" align="right" class="btn btn-primary">Salvar</button>
                    </div>

                </form>

            </div>
        </div>


    </jsp:body>
</tags:layout>
