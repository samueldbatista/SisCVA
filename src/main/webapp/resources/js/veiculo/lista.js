/**
 * Contém a lógica para a requisição de dados para tabela via ajax com jquery
 * Faz a requisição a ajax e rendiriza os dados dinamicamente no html da lista
 */

$(document).ready(function () {
    var ctx = $('#ctx').val();
    var $corpoTabela = $('#tabela-corpo');
    var spinner = new Spinner({
        lines: 12, // The number of lines to draw
        length: 7, // The length of each line
        width: 5, // The line thickness
        radius: 10, // The radius of the inner circle
        color: '#000', // #rbg or #rrggbb
        speed: 1, // Rounds per second
        trail: 100, // Afterglow percentage
        shadow: true // Whether to render a shadow
    });
    var target = document.getElementById("tabela-veiculos");

    $("#escolher-delegacia").change(function () {
        var chave = $(this).val();
        var url = ctx + 'veiculo/' + 'veiculosPorDelegacia?id='+chave;
        console.log(chave);
        $('.table').dataTable().fnDestroy();
        $('#tabela-corpo').empty();
        verificarChave(url)
    });



    function verificarChave(url) {
        limparMsgs();
        $(".table").show();
        spinner.spin(target);
        $.ajax({
            dataType: 'json',
            type: 'GET',
            url: url
        }).done(function (data) {
            console.log(data.length);
            if(data.length > 0) {
                gerarHTMLCorpoDaTabela(data)
                iniciarDataTables();
            } else {
                painelDeMensagem("Nenhum veículo encontrado para esta delegacia");
            }
            spinner.spin().stop();
            $(".table").css("width", "-webkit-fill-available");
        }).fail(function () {
            painelDeErro();
        }).always(function () {
        });
    }

    function gerarHTMLCorpoDaTabela(data) {
        data.forEach(function (dado) {
            var teste= "teste";
            $('#tabela-corpo').append(
                "<tr>"
                +"<td>"+dado.id+"</td>"
                +"<td>"+dado.dossie+"</td>"
                +"<td>"+moment(dado.dataEntrada).format('DD/MM/YYYY')+"</td>"
                +"<td>"+dado.modelo+"</td>"
                +"<td>"+dado.fabricante+"</td>"
                +"<td>"+dado.placa+"</td>"
                +"<td>"+dado.placaOriginal+"</td>"
                +"<td>"+dado.cor+"</td>"
                +"<td>"+dado.seguro+"</td>"
                +"<td>"+dado.localAtual+"</td>"
                +"<td>"+dado.exame+"</td>"
                +"<td>"+dado.situacao+"</td>"
                +"<td align='center'>"
                +"<a title='Detalhes' href='"+ctx+"veiculo/detalhes?id="+dado.id+"'>"+"<i class='fa fa-eye fa-lg'></i>"+"</a>"
                +"<a title='Tarefas' href='"+ctx+"tarefa/lista?id="+dado.id+"'>"+"<i class='fa fa-tasks fa-lg'></i>"+"</a>"
                +"<a title='Ocorrências' href='"+ctx+"ocorrencia/lista?id="+dado.id+"'>"+"<i class='fa fa-archive fa-lg'></i>"+"</a>"
                +"<a title='Imprimir relatório' href='"+ctx+"imprimirRelatorioVeiculo?id="+dado.id+"'>"+"<i class='fa fa-file-pdf-o fa-lg'></i>"+"</a>"
                +"<a title='Fotos' href='"+ctx+"veiculo/fotos?id="+dado.id+"'>"+"<i class='fa fa-file-photo-o fa-lg'></i>"+"</a>"
                +"<a title='Documentos' href='"+ctx+"veiculo/documentos?id="+dado.id+"'>"+"<i class='fa fa-paperclip fa-lg'></i>"+"</a>"
                +"</td>"
                +"</tr>");
        });
    }

    if($('#tabela-corpo').length <= 1) {
        painelDeMensagem("Selecione uma delegacia");
    }
});