/*
* Responsável por gerenciar as mensagens de erros e mensagens genéricas para busca de dados em tabelas.
*
* */

var $mensagemClass =  $('.msg-tabela');

function painelDeErro () {
    $mensagemClass.show();
    $mensagemClass.append("<h4 align='center' style='color: #cb2027'>Erro ao processar requisição</h4>");
    $('.table').hide();
}

function painelDeMensagem (msg) {
    $mensagemClass.show();
    $mensagemClass.append("<h4 align='center' style='color: #00a157'>"+msg+"</h4>");
    $('.table').hide();
}

function limparMsgs() {
    $mensagemClass.empty();
    $mensagemClass.hide();
}