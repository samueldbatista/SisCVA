function iniciarDataTables() {
    $.fn.dataTable.moment('DD/MM/YYYY');
    var confBtn = [{extend: 'colvis', text: 'Escolher colunas'}];
    var ptbrLang = {sEmptyTable: "Nenhum registro encontrado",
        sInfo: "Mostrando de _START_ até _END_ de _TOTAL_ registros",
        sInfoEmpty: "Mostrando 0 até 0 de 0 registros",
        sInfoFiltered: "(Filtrados de _MAX_ registros)",
        sInfoPostFix: "",
        sInfoThousands: ".",
        sLengthMenu: "_MENU_ resultados por página",
        sLoadingRecords: "Carregando...",
        sProcessing: "Processando...",
        sZeroRecords: "Nenhum registro encontrado",
        sSearch: "Pesquisar",
        oPaginate: {
            sNext: "Próximo",
            sPrevious: "Anterior",
            sFirst: "Primeiro",
            sLast: "Último"
        },
        oAria: {
            sSortAscending: ": Ordenar colunas de forma ascendente",
            sSortDescending: ": Ordenar colunas de forma descendente"
        }};


    var table = $('.table').DataTable({
        dom: "<'row controlBtnTables'<'col-md-7'l><'btnVis col-md-2'><'col-md-3'f>>tip",
        buttons: confBtn,
        order: [1,'desc'],
        columnDefs: [
            {targets: [1, 2, 3, 4, 5, 6, 12], visible: true},
            {targets: '_all', visible: false}
        ], language: ptbrLang,
        autoFill: true
    });

    table
        .buttons()
        .container()
        .appendTo('.btnVis');

    moment.locale('pt-BR');
}