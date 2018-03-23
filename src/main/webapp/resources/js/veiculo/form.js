$(document).ready(function () {
    var ctx = $('#ctx').val();
    var $inputPressionado;
    var chaveBoolean = false;
    var placaOriginalBoolean = false;
    $("input[name='veiculo.dadosOcorrencia.chave']").change(function () {
        $inputPressionado = $('#msg-chave');
        console.log($(this).val());
        var chave = $(this).val();
        var url = ctx + 'veiculo/' + 'verificarChave?chave='+chave;
        console.log(url);
        verificarExistencia(url,"label-danger","chave")

    });

    $("input[name='veiculo.placa']").change(function () {
        $inputPressionado = $('#msg-placa');
        var placa = $(this).val();
        var url = ctx + 'veiculo/' + 'verificarPlaca?placa='+placa;
        console.log(url);
        verificarExistencia(url,"label-warning","placa")

    });

    $("input[name='veiculo.placaOriginal']").change(function () {
        $inputPressionado = $('#msg-placaOriginal');
        var placa = $(this).val();
        var url = ctx + 'veiculo/' + 'verificarPlacaOriginal?placaOriginal='+placa;
        console.log(url);
        verificarExistencia(url,"label-danger","placaOriginal");

    });

    function verificarExistencia(url,classe,tipo) {
        $.ajax({
            dataType: 'json',
            type: 'GET',
            url: url
        }).done(function (data) {

            console.log(data);
           $inputPressionado.empty();
           $inputPressionado.append("<span class='label "+classe+"'>"+"Esse ítem já está sendo utilizado pelo veiculo "+data.veiculo+" de placa original "+data.placa+"."+"</span>");
            if(tipo == "placaOriginal") {
                placaOriginalBoolean = true;
            } else if(tipo == "chave") {
                chaveBoolean = true;
            }
        }).fail(function () {
            if(tipo == "placaOriginal") {
                placaOriginalBoolean = false;
            } else if(tipo == "chave") {
                chaveBoolean = false;
            }
           $inputPressionado.empty();
           $inputPressionado.append("<span class='label label-success'>Disponível</span>");
        }).always(function () {
            habilitarBtns();
        });
    }


    function habilitarBtns() {
        if(chaveBoolean || placaOriginalBoolean) {
            $('#btnSalvar').attr("disabled","disabled");            // alert("A placa original ou chave não está disponivel");
        } else {
            $('#btnSalvar').removeAttr("disabled");            // alert("A placa original ou chave não está disponivel");
        }
    }
});