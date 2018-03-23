package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Veiculo;
import br.pcrn.deprov.dominio.relatorios.RelatorioGeral;

import java.util.List;
import java.util.Optional;

/**
 * Created by samue on 17/12/2017.
 */
public interface VeiculoDao extends EntidadeDao<Veiculo> {
    List<Veiculo> buscarPrimeiros();
    List<Veiculo> buscarParaRelatorioGeral (RelatorioGeral relatorioGeral);
    List<Veiculo> buscarVeiculosComTarefaCadastrada();
    List<Veiculo> buscarVeiculosPorDelegacia(Long id);
    Optional<Veiculo> buscarVeiculoPelaChave(String chave);
    Optional<Veiculo> buscarVeiculoPelaPlacaOriginal(String placaOriginal);
    Optional<Veiculo> buscarVeiculoPelaPlaca(String placa);
}
