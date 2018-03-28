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
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
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
        <script>

            $('#fabricante').change(function () {
                var idFabricante = $(this).val();
                var url = $('#urlModelo').val() + "?idFabricante=" + idFabricante;
                // console.log($('#urlModelo').val());
                requisicaoModelos(url)
            });

            VMasker(document.getElementById("anoFabricacao")).maskPattern("9999/9999");
            VMasker($('input[name="veiculo.placa"]')).maskPattern("AAA9999");
            VMasker($('input[name="veiculo.placaOriginal"]')).maskPattern("AAA9999");
            // VMasker(document.getElementByName("anoFabricacao")).maskPattern("9999/9999");
            // VMasker(document.getElementByName("anoFabricacao")).maskPattern("9999/9999");

            function requisicaoModelos(url) {
                $.ajax({
                    dataType: 'json',
                    type: 'GET',
                    url: url
                }).done(function (data) {
                    console.log("Deu certo")
                    $('#modelo').empty();
                    $('#modelo').append("<option value=''></option>");
                    data.forEach(function (modelo) {
                       $('#modelo').append("<option value='"+modelo.id+"'>"+modelo.modelo+"</option>");
                    });
                }).fail(function () {
                }).always(function () {
                });
            }
            $('.datePicker').datepicker(
                {
                    format: "dd/mm/yyyy"
                });
        </script>
        <script src="${ctx}/resources/js/veiculo/form.js"></script>

    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Cadastro de veículos"/>

        <input id="urlModelo" type="hidden" value="${linkTo[VeiculoController].buscarMoleloPorFabricante}"/>
        <ul class="nav nav-tabs nav-justified">
            <li class="active"><a href="#menu" data-toggle="tab">Dados do veículo</a></li>
        </ul>
        <form id="form-veiculo" action="${linkTo[VeiculoController].salvar}" method="post">
            <input name="veiculo.id" value="${veiculo.id}" type="hidden"/>
            <input name="veiculo.dadosOcorrencia.id" value="${veiculo.dadosOcorrencia.id}" type="hidden"/>
            <input name="veiculo.delegacia.id" value="${idDelegacia}" type="hidden"/>
            <c:forEach items="${veiculo.fotos}" var="foto" begin="0" varStatus="count">
                <input type="hidden" name="veiculo.fotos[${count.index}].id" value="${foto.id}">
            </c:forEach>
            <c:forEach items="${veiculo.documentos}" var="documento" begin="0" varStatus="count">
                <input type="hidden" name="veiculo.documentos[${count.index}].id" value="${documento.id}">
            </c:forEach>
            <c:forEach items="${veiculo.tarefas}" var="tarefa" begin="0" varStatus="count">
                <input type="hidden" name="veiculo.tarefas[${count.index}].id" value="${tarefa.id}">
            </c:forEach>
            <c:forEach items="${veiculo.ocorrencias}" var="ocorrencia" begin="0" varStatus="count">
                <input type="hidden" name="veiculo.ocorrencias[${count.index}].id" value="${ocorrencia.id}">
            </c:forEach>
            <div class="tab-content panel painel-cadastro">
                <div id="menu" class="tab-pane fade in active">
                    <div class="panel-body">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="fabricante">Fabricante:</label>
                                <select class="form-control input-sm" required id="fabricante" name="veiculo.modelo.fabricante.id">
                                    <option></option>
                                    <c:forEach items="${fabricantes}" var="fabricante">
                                        <c:choose>
                                            <c:when test="${fabricante.valor == veiculo.modelo.fabricante.id}">
                                                <option value="${fabricante.valor}" selected="true">${fabricante.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${fabricante.valor}">${fabricante.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="modelo">Modelo:</label>
                                <select class="form-control input-sm" required id="modelo" name="veiculo.modelo.id">
                                    <option></option>
                                    <c:forEach items="${modelos}" var="modelo">
                                        <c:choose>
                                            <c:when test="${modelo.valor == veiculo.modelo.id}">
                                                <option value="${modelo.valor}" selected="true">${modelo.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${modelo.valor}">${modelo.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                </select>
                            </div>

                            <div class="form-group">
                                <label class="control-label">Ano de fabricação:</label>
                                <input type="text" required name="veiculo.anoFabricacao" value="${veiculo.anoFabricacao}" class="form-control input-sm" id="anoFabricacao">
                            </div>
                            <div class="form-group">
                                <label for="motor">Motor:</label>
                                <input type="text" name="veiculo.motor" value="${veiculo.motor}" class="form-control input-sm" id="motor">
                            </div>
                            <div class="form-group">
                                <label for="placa">Placa:</label>
                                <input type="text" required name="veiculo.placa" minlength="7" maxlength="7" value="${veiculo.placa}" class="form-control input-sm" id="placa">
                                <div id="msg-placa"></div>
                            </div>
                            <div class="form-group">
                                <label for="placaOriginal">Placa original:</label>
                                <input type="text" required value="${veiculo.placaOriginal}" minlength="7" maxlength="7" name="veiculo.placaOriginal" class="form-control input-sm" id="placaOriginal">
                                <div id="msg-placaOriginal"></div>
                            </div>
                            <div class="form-group">
                                <label for="tipo">Tipo:</label>
                                <select name="veiculo.tipo.id" required class="form-control input-sm" id="tipo">
                                    <option></option>
                                    <c:forEach items="${tipos}" var="tipo">
                                        <c:choose>
                                            <c:when test="${tipo.valor == veiculo.tipo.id}">
                                                <option value="${tipo.valor}" selected="true">${tipo.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${tipo.valor}">${tipo.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="cor">Cor:</label>
                                <select name="veiculo.cor.id" required class="form-control input-sm" id="cor">
                                    <option></option>
                                    <c:forEach items="${cores}" var="cor">
                                        <c:choose>
                                            <c:when test="${cor.valor == veiculo.cor.id}">
                                                <option value="${cor.valor}" selected="true">${cor.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cor.valor}">${cor.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="condicao">Condição:</label>
                                <input type="text" name="veiculo.condicao" value="${veiculo.condicao}" class="form-control input-sm" id="condicao">
                            </div>
                            <div class="form-group">
                                <label for="seguro">Seguro:</label>
                                <select name="veiculo.seguro.id" class="form-control input-sm" id="seguro">
                                    <option></option>

                                    <c:forEach items="${seguros}" var="seguro">
                                        <c:choose>
                                            <c:when test="${seguro.valor == veiculo.seguro.id}">
                                                <option value="${seguro.valor}" selected="true">${seguro.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${seguro.valor}">${seguro.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="chassi">Chassi:</label>
                                <input type="text" name="veiculo.chassi" value="${veiculo.chassi}" class="form-control input-sm" id="chassi">
                            </div>
                            <div class="form-group">
                                <label for="proprietario">Proprietário:</label>
                                <input type="text" name="veiculo.proprietario" value="${veiculo.proprietario}" class="form-control input-sm" id="proprietario">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="dossie">Dossiê:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.dossie" value="${veiculo.dadosOcorrencia.dossie}" class="form-control input-sm" id="dossie">
                            </div>
                            <div class="form-group">
                                <label for="numeroOcorrencia">Numero da ocorrência:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.numeroOcorrencia" value="${veiculo.dadosOcorrencia.numeroOcorrencia}" class="form-control input-sm" id="numeroOcorrencia">
                            </div>
                            <div class="form-group">
                                <label for="processo">Processo:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.processo" value="${veiculo.dadosOcorrencia.processo}" class="form-control input-sm" id="processo">
                            </div>
                            <div class="form-group">
                                <label for="ip">Ip:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.ip" value="${veiculo.dadosOcorrencia.ip}" class="form-control input-sm" id="ip">
                            </div>
                            <div class="form-group">
                                <label for="motivoApreensao">Motivo da apreensão:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.motivoApreensao" value="${veiculo.dadosOcorrencia.motivoApreensao}" class="form-control input-sm" id="motivoApreensao">
                            </div>
                            <div class="form-group">
                                <label for="obs">Obs:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.obs" value="${veiculo.dadosOcorrencia.obs}" class="form-control input-sm" id="obs">
                            </div>
                            <div class="form-group">
                                <label for="situacao">Situação:</label>
                                <select name="veiculo.dadosOcorrencia.situacao.id" class="form-control input-sm" id="situacao">
                                    <option></option>
                                    <c:forEach items="${situacoes}" var="situacao">
                                        <c:choose>
                                            <c:when test="${situacao.valor == veiculo.dadosOcorrencia.situacao.id}">
                                                <option value="${situacao.valor}" selected="true">${situacao.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${situacao.valor}">${situacao.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="local">Local:</label>
                                <select name="veiculo.dadosOcorrencia.local.id" class="form-control input-sm" id="local">
                                    <option></option>
                                    <c:forEach items="${locais}" var="local">
                                        <c:choose>
                                            <c:when test="${local.valor == veiculo.dadosOcorrencia.local.id}">
                                                <option value="${local.valor}" selected="true">${local.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${local.valor}">${local.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="pericia">Pericia:</label>
                                <select name="veiculo.dadosOcorrencia.pericia.id" class="form-control input-sm" id="pericia">
                                    <option></option>
                                    <c:forEach items="${pericias}" var="pericia">
                                        <c:choose>
                                            <c:when test="${pericia.valor == veiculo.dadosOcorrencia.pericia.id}">
                                                <option value="${pericia.valor}" selected="true">${pericia.chave}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${pericia.valor}">${pericia.chave}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="chave">Chave:</label>
                                <input type="text" required name="veiculo.dadosOcorrencia.chave" value="${veiculo.dadosOcorrencia.chave}" class="form-control input-sm" id="chave">
                                <div id="msg-chave"></div>
                            </div>
                            <div class="form-group">
                                <label for="comentario">Comentários:</label>
                                <input type="text" name="veiculo.dadosOcorrencia.comentario" value="${veiculo.dadosOcorrencia.comentario}" class="form-control input-sm" id="comentario">
                            </div>
                            <div class="form-group">
                                <label for="dataEntrada">Data de entrada:</label>
                                <input id="dataEntrada" type="text" name="veiculo.dadosOcorrencia.dataEntrada" class="form-control input-sm datePicker"
                                       value="<tag:localDate date="${veiculo.dadosOcorrencia.dataEntrada}"/>">
                            </div>
                        </div>
                    </div>
                </div>
                <div id="painel" class="tab-pane fade">
                    <div class="panel-body">
                        <div class="col-md-6">

                        </div>
                        <div class="col-md-6">

                        </div>
                    </div>
                </div>
                    <div class="panel-footer" align="right">
                    <button id="btnSalvar" class="btn btn-primary" type="submit">Salvar</button>
                    </div>

            </div>
        </form>

        <%--</tags:painel>--%>

    </jsp:body>
</tags:layout>
