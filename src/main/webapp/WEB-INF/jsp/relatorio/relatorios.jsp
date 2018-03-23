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

            @media (min-width: 768px) {
                .form-inline .form-control {
                    display: inline-block;
                    width: auto;
                    vertical-align: middle;
                    width: 250px;
                    margin-bottom: 8px;
                }
            }

        </style>
    </jsp:attribute>
    <jsp:attribute name="rodape">
        <script>

            $('#dossie-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#dossie').removeAttr('disabled');
                } else {
                    $('#dossie').attr('disabled', 'disabled');
                }
            });

            $('#data-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#data').removeAttr('disabled');
                } else {
                    $('#data').attr('disabled', 'disabled');
                }
            });
            $('#placaNoVeiculo-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#placaNoVeiculo').removeAttr('disabled');
                } else {
                    $('#placaNoVeiculo').attr('disabled', 'disabled');
                }
            });
            $('#placaOriginal-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#placaOriginal').removeAttr('disabled');
                } else {
                    $('#placaOriginal').attr('disabled', 'disabled');
                }
            });
            $('#fabricante-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#fabricante').removeAttr('disabled');
                } else {
                    $('#fabricante').attr('disabled', 'disabled');
                }
            });
            $('#modelo-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#modelo').removeAttr('disabled');
                } else {
                    $('#modelo').attr('disabled', 'disabled');
                }
            });
            $('#cor-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#cor').removeAttr('disabled');
                } else {
                    $('#cor').attr('disabled', 'disabled');
                }
            });
            $('#seguro-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#seguro').removeAttr('disabled');
                } else {
                    $('#seguro').attr('disabled', 'disabled');
                }
            });
            $('#localAtual-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#localAtual').removeAttr('disabled');
                } else {
                    $('#localAtual').attr('disabled', 'disabled');
                }
            });
            $('#exame-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#exame').removeAttr('disabled');
                } else {
                    $('#exame').attr('disabled', 'disabled');
                }
            });
            $('#situacao-chk').change(function () {
                if ($(this).is(':checked')) {
                    $('#situacao').removeAttr('disabled');
                } else {
                    $('#situacao').attr('disabled', 'disabled');
                }
            });


        </script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Relatórios"/>
        <tags:painel titulo="relatorio.titulo.cadastro">
            <form class="form-inline col-md-10" action="${linkTo[RelatorioController].imprimirRelatorioVeiculo}"
                  method="post">
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="dossie-chk">Dossiê</label>
                        <input id="dossie-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                            <%--<select class="form-control">--%>
                            <%--<option>Samuel Dantas</option>--%>
                            <%--</select>--%>
                        <input class="form-control" disabled id="dossie" name="relatorioGeral.dossie"
                               value="${relatorioGeral.dossie}" type="text">
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="data-chk">Data</label>
                        <input id="data-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <input class="form-control" id="data" disabled type="text">
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="placaNoVeiculo-chk">Placa no veículo</label>
                        <input id="placaNoVeiculo-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <input class="form-control" id="placaNoVeiculo" disabled type="text">
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="placaOriginal-chk">Placa original: </label>
                        <input id="placaOriginal-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <input class="form-control" id="placaOriginal" disabled type="text">
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="fabricante-chk">Fabricante: </label>
                        <input id="fabricante-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                        <select class="form-control form-relatorio" name="relatorioGeral.fabricante">
                            <option></option>
                            <c:forEach items="${fabricantes}" var="fabricante">
                                <option value="${fabricante.chave}">${fabricante.chave}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="modelo-chk">Modelo: </label>
                        <input id="modelo-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="relatorioGeral.modelo" id="modelo" disabled type="text">
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="cor-chk">Cor: </label>
                        <input id="cor-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <select class="form-control" name="relatorioGeral.cor">
                            <option></option>
                            <c:forEach items="${cores}" var="cor">
                                <option value="${cor.chave}">${cor.chave}</option>
                            </c:forEach>
                        </select>
                            <%--<input class="form-control" id="cor" disabled type="text" >--%>
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="seguro-chk">Seguro: </label>
                        <input id="seguro-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <select class="form-control" name="relatorioGeral.seguro">
                            <option></option>
                            <c:forEach items="${seguros}" var="seguro">
                                <option value="${seguro.chave}">${seguro.chave}</option>
                            </c:forEach>
                        </select>
                            <%--<input class="form-control" id="seguro" disabled type="text">--%>
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="localAtual-chk">Local atual: </label>
                        <input id="localAtual-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <select class="form-control" name="relatorioGeral.localAtual">
                            <option></option>
                            <c:forEach items="${locais}" var="local">
                                <option value="${local.chave}">${local.chave}</option>
                            </c:forEach>
                        </select>
                            <%--<input class="form-control" id="localAtual" disabled type="text">--%>
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="exame-chk">Exame veicular: </label>
                        <input id="exame-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                        <select class="form-control" name="relatorioGeral.exame">
                            <option></option>
                            <c:forEach items="${pericias}" var="pericia">
                                <option value="${pericia.chave}">${pericia.chave}</option>
                            </c:forEach>
                        </select>
                            <%--<input class="form-control" id="exame" disabled type="text">--%>
                    </div>
                </div>
                <div class="col-md-6" align="right">
                    <div class="form-group">
                        <label for="situacao-chk">Situação: </label>
                        <input id="situacao-chk" type="checkbox">
                    </div>
                    <div class="form-group">
                            <%--<label for="inputPassword">Disabled</label>--%>
                            <%--<input class="form-control" id="situacao" disabled type="text">--%>
                        <select class="form-control" name="relatorioGeral.situacao">
                            <option></option>
                            <c:forEach items="${situacoes}" var="situacao">
                                <option value="${situacao.chave}">${situacao.chave}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-12" align="right">
                    <button class="btn btn-success" type="submit">Imprimir relatório</button>
                </div>
            </form>

        </tags:painel>

    </jsp:body>
</tags:layout>
