/**
 * Created by samue on 15/09/2017.
 */

$(document).ready(function () {
    // $(".datePicker").datepicker({
    //     format: "dd/mm/yyyy"
    // });
    console.log("js incluido");
    
    $('.btns-remocao').click(function () {
       var url =  $(this).attr("url-remocao");
       $('#btn-remover').attr("href",url);
    });


    // $('.tabela').DataTable( {
    //     pageLength:25,
    //     "language":
    //         {
    //             "sEmptyTable": "Nenhum registro encontrado",
    //             "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
    //             "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
    //             "sInfoFiltered": "(Filtrados de _MAX_ registros)",
    //             "sInfoPostFix": "",
    //             "sInfoThousands": ".",
    //             "sLengthMenu": "_MENU_ resultados por página",
    //             "sLoadingRecords": "Carregando...",
    //             "sProcessing": "Processando...",
    //             "sZeroRecords": "Nenhum registro encontrado",
    //             "sSearch": "Pesquisar",
    //             "oPaginate": {
    //                 "sNext": "Próximo",
    //                 "sPrevious": "Anterior",
    //                 "sFirst": "Primeiro",
    //                 "sLast": "Último"
    //             },
    //             "oAria": {
    //                 "sSortAscending": ": Ordenar colunas de forma ascendente",
    //                 "sSortDescending": ": Ordenar colunas de forma descendente"
    //             }
    //         }
    // } );

    // $('.alert').fadeOut(3000);
});





