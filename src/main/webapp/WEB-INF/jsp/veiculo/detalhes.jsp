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
        <style>
            .panel-visualizacao {
                border: 1px solid #dddddd;
                border-radius: 0px;
                min-height: 400px;
            }
        </style>
    </jsp:attribute>
    <jsp:attribute name="rodape">
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Detalhes do veículo"/>
        <div class="row">
            <div class="col-md-6" style="padding-right: 4px;">
                <div class="panel panel-visualizacao">
                    <div class="panel-heading" style="padding-bottom: 0px;">
                        <div class="row">
                            <h4 class="col-md-9">Dados do veículo</h4>
                            <div class="col-md-3" align="right">
                                <a class="btn btn-info" href="${linkTo[VeiculoController].editar}?id=${veiculo.id}">Editar Veículo</a>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body" style="padding-top: 0px">
                        <h5><b>Fabricante: </b>${veiculo.modelo.fabricante.fabricante}</h5>
                        <h5><b>Modelo: </b>${veiculo.modelo.modelo}</h5>
                        <h5><b>Ano de fabricação: </b>${veiculo.anoFabricacao}</h5>
                        <h5><b>Motor: </b>${veiculo.motor}</h5>
                        <h5><b>Placa: </b>${veiculo.placa}</h5>
                        <h5><b>Placa original: </b>${veiculo.placaOriginal}</h5>
                        <h5><b>Tipo: </b>${veiculo.tipo.tipo}</h5>
                        <h5><b>Cor: </b>${veiculo.cor.cor}</h5>
                        <h5><b>Condição: </b>${veiculo.condicao}</h5>
                        <h5><b>Seguro: </b>${veiculo.seguro.seguro}</h5>
                        <h5><b>Chassi: </b>${veiculo.chassi}</h5>
                        <h5><b>Proprietário: </b>${veiculo.proprietario}</h5>
                    </div>
                </div>

            </div>
            <div class="col-md-6" style="padding-left: 4px;">
                <div class="panel panel-visualizacao">
                    <div class="panel-heading" style="padding-bottom: 0px;">
                        <h4>Dados da apreensão</h4>
                    </div>
                    <div class="panel-body" style="padding-top: 0px">
                        <h5><b>Dossie: </b>${veiculo.dadosOcorrencia.dossie}</h5>
                        <h5><b>Numero da ocorrência: </b>${veiculo.dadosOcorrencia.numeroOcorrencia}</h5>
                        <h5><b>Processo: </b>${veiculo.dadosOcorrencia.processo}</h5>
                        <h5><b>IP: </b>${veiculo.dadosOcorrencia.ip}</h5>
                        <h5><b>Motivo da apreensão: </b>${veiculo.dadosOcorrencia.motivoApreensao}</h5>
                        <h5><b>Observações: </b>${veiculo.dadosOcorrencia.obs}"</h5>
                        <h5><b>Situação: </b>${veiculo.dadosOcorrencia.situacao.situacao}</h5>
                        <h5><b>Local atual: </b>${veiculo.dadosOcorrencia.local.local}</h5>
                        <h5><b>Exame: </b>${veiculo.dadosOcorrencia.pericia.pericia}</h5>
                        <h5><b>Chave: </b>${veiculo.dadosOcorrencia.chave}</h5>
                        <h5><b>Comentário: </b>${veiculo.dadosOcorrencia.comentario}</h5>
                        <h5><b>Data de entrada: </b><tag:localDate date="${veiculo.dadosOcorrencia.dataEntrada}"/></h5>
                    </div>
                </div>

            </div>
        </div>


    </jsp:body>
</tags:layout>
