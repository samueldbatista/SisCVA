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
        <script src="${ctx}/resources/plugins/moment/moment.js"></script>
                <script src="${ctx}/resources/plugins/moment/moment-with-locales.js"></script>

        <script src="${ctx}/resources/plugins/dataTables/datatables.js"></script>
        <script src="${ctx}/resources/plugins/moment/date-time-moment.js"></script>
        <script>

            $(document).ready(function() {
                moment.locale("pt-br");
                $('table').dataTable({
                    "order": [[ 0, "desc" ]],
                    "columnDefs": [
                        {
                            "targets": [ 0 ],
                            "visible": false,
                            "searchable": false
                        }
                    ]
                });

                $('.data-atualizacao').each(function () {
                    var valor = $(this).text();
                    var valorFormatado = moment(valor).format('DD/MM/YYYY HH:mm');
                    var valorRelativo = moment(valorFormatado, "DD/MM/YYYY HH:mm").fromNow();
                    $(this).text(valorRelativo);
                });
            } );


        </script>
    </jsp:attribute>

    <jsp:body>
        <tags:header titulo="Últimas movimentações"/>
        <div class="panel painel-deprov">
            <c:forEach items="${logs}" var="log">
            <ul class="list-group">
                <li class="list-group-item">${log.informacao}<span class="badge data-atualizacao">${log.dataAlteracao}</span></li>
            </ul>
            </c:forEach>
        </div>

    </jsp:body>
</tags:layout>
