package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.LogMovimentacao;

import java.util.List;

public interface LogMovimentacaoDao extends EntidadeDao<LogMovimentacao>{
    public List<LogMovimentacao> retornarUltimasAlterações ();
}
