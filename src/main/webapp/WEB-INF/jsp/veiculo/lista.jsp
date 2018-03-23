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
        <script src="${ctx}/resources/plugins/spin/spin.js"></script>
        <script src="${ctx}/resources/plugins/moment/moment-with-locales.js"></script>
        <script src="${ctx}/resources/plugins/moment/moment.js"></script>


        <%--<script src="${ctx}/resources/plugins/dataTables/dataTables.js"></script>--%>
        <script src="${ctx}/resources/plugins/dataTables/datatables.js"></script>
        <script src="${ctx}/resources/plugins/moment/date-time-moment.js"></script>
        <script src="${ctx}/resources/js/msgTabela.js"></script>
        <script src="${ctx}/resources/js/veiculo/lista.js"></script>
        <script src="${ctx}/resources/js/veiculo/tabelaVeiculo.js"></script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Listagem de veículos de todas as delegacias cadastradas"/>
        <tags:painel titulo="veiculo.total" tipo="panel-default">
            <c:if test="${administradorPlantao}">
                <div class="col-md-6">
                    <div class="btn-container" style="margin-bottom: 16px;">
                        <a class="btn btn-info" href="${linkTo[VeiculoController].form}">Cadastrar</a>
                            <%--<a class="btn btn-primary" href="#">Gerar ocorrência</a>--%>
                        <c:if test="${administradorDelegacia}">
                            <a class="btn btn-success" href="${linkTo[RelatorioController].relatorios}">Relatórios</a>
                        </c:if>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="btn-container" align="right" style="margin-bottom: 16px;">
                        <div class="form-group">
                            <select class="form-control input-sm" id="escolher-delegacia" name="veiculo.delegacia.id">
                                <option disabled selected>Escolha uma delegacia</option>
                                <c:forEach items="${delegacias}" var="delegacia">
                                    <option value="${delegacia.valor}">${delegacia.chave}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </c:if>
            <div class="tabela-deprov col-md-12">
                <div class="msg-tabela">
                </div>
                <div id="controlPanel">
                </div>
                <table id="tabela-veiculos" class="table table-bordered table-striped" style="display: none;">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Dossie</th>
                        <th>Data de entrada</th>
                        <th>Modelo</th>
                        <th>Fabricante</th>
                        <th>Placa</th>
                        <th>Placa Original</th>
                        <th>Cor</th>
                        <th>Seguro</th>
                        <th>Local Atual</th>
                        <th>Exame veicular</th>
                        <th>Situação</th>
                        <th align="center">Ações</th>
                    </tr>
                    </thead>
                    <tbody id="tabela-corpo">
                    <c:forEach items="${veiculos}" var="veiculo">
                        <tr>
                            <td>${veiculo.id}</td>
                            <td>${veiculo.dadosOcorrencia.dossie}</td>
                            <td><span class="date-deprov">${veiculo.dadosOcorrencia.dataEntrada}</span></td>
                            <td>${veiculo.modelo.modelo}</td>
                            <td>${veiculo.modelo.fabricante.fabricante}</td>
                            <td>${veiculo.placa}</td>
                            <td>${veiculo.placaOriginal}</td>
                            <td>${veiculo.cor.cor}</td>
                            <td>${veiculo.seguro.seguro}</td>
                            <td>${veiculo.dadosOcorrencia.local.local}</td>
                            <td>${veiculo.dadosOcorrencia.pericia.pericia}</td>
                            <td>${veiculo.dadosOcorrencia.situacao.situacao}</td>
                            <td align="center">

                                <a title="Detalhes" href="${linkTo[VeiculoController].detalhes}?id=${veiculo.id}"><i
                                        class="fa fa-eye fa-lg"></i></a>
                                <c:if test="${administradorDelegacia}">
                                    <a title="Tarefas" href="${linkTo[TarefaController].lista}?id=${veiculo.id}"><i
                                            class="fa fa-tasks fa-lg"></i></a>
                                    <a title="Ocorrencias"
                                       href="${linkTo[OcorrenciaController].lista}?id=${veiculo.id}"><i
                                            class="fa fa-archive fa-lg"></i></a>
                                    <a title="Relatório do veiculo"
                                       href="${linkTo[VeiculoController].imprimirRelatorioVeiculo}?id=${veiculo.id}"><i
                                            class="fa fa-file-pdf-o fa-lg"></i></a>
                                    <a title="Fotos"
                                       href="${linkTo[VeiculoController].fotos}?id=${veiculo.id}"><i
                                            class="fa fa-file-photo-o fa-lg"></i></a>
                                    <a title="Documentos"
                                       href="${linkTo[VeiculoController].documentos}?id=${veiculo.id}"><i
                                            class="fa fa-paperclip fa-lg"></i></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </tags:painel>
    </jsp:body>
</tags:layout>
