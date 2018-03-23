package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Veiculo;
import br.pcrn.deprov.dominio.relatorios.RelatorioGeral;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by samue on 17/12/2017.
 */
public class VeiculoJpaDao  extends EntidadeJpaDao<Veiculo> implements VeiculoDao {

    @Deprecated
    public VeiculoJpaDao(){
        this(null);
    }

    @Inject
    public VeiculoJpaDao(EntityManager entityManager) {
        super(entityManager, Veiculo.class);
    }

    @Override
    public List<Veiculo> buscarPrimeiros() {
        Query query = manager.createQuery("SELECT p from Veiculo p ");
        return query.setMaxResults(10).getResultList();
    }

    @Override
    public List<Veiculo> buscarVeiculosPorDelegacia(Long id) {
        Query query = manager.createQuery("SELECT p from Veiculo p WHERE p.delegacia.id = :idDelegacia");
        query.setParameter("idDelegacia",id);
        return query.getResultList();
    }

    @Override
    public List<Veiculo> buscarVeiculosComTarefaCadastrada() {
        Query query = manager.createQuery("SELECT p from Veiculo p WHERE p.tarefas.size > 0");
        return query.getResultList();
    }

    @Override
    public Optional<Veiculo> buscarVeiculoPelaChave(String chave) {
        Query query = manager.createQuery("SELECT v FROM Veiculo v WHERE v.dadosOcorrencia.chave = :chave").setParameter("chave",chave);
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }

    @Override
    public Optional<Veiculo> buscarVeiculoPelaPlacaOriginal(String placaOriginal) {
        Query query = manager.createQuery("SELECT v FROM Veiculo v WHERE v.placaOriginal = :placaOriginal").setParameter("placaOriginal",placaOriginal);
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }

    @Override
    public Optional<Veiculo> buscarVeiculoPelaPlaca(String placa) {
        Query query = manager.createQuery("SELECT v FROM Veiculo v WHERE v.placa = :placa").setParameter("placa",placa);
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }

    public List<Veiculo> buscarParaRelatorioGeral (RelatorioGeral relatorioGeral) {
        Query query = manager.createQuery(gerarQueryParaRelatorio(relatorioGeral));
        if(relatorioGeral.getChassi() != null) {
            query.setParameter("chassi", relatorioGeral.getChassi());
        }
        if(relatorioGeral.getCor() != null) {
            query.setParameter("cor", relatorioGeral.getCor());
        }
        if(relatorioGeral.getData() != null) {
            query.setParameter("data", relatorioGeral.getData());
        }
        if(relatorioGeral.getDossie() != null) {
            query.setParameter("dossie", relatorioGeral.getDossie());
        }
        if(relatorioGeral.getExame() != null) {
            query.setParameter("exame", relatorioGeral.getExame());
        }
        if(relatorioGeral.getFabricante() != null) {
            query.setParameter("fabricante", relatorioGeral.getFabricante());
        }
        if(relatorioGeral.getLocalAtual() != null) {
            query.setParameter("localAtual", relatorioGeral.getLocalAtual());
        }
        if(relatorioGeral.getModelo() != null) {
            query.setParameter("modelo", relatorioGeral.getModelo());
        }
        if(relatorioGeral.getPlacaOriginal() != null) {
            query.setParameter("placaOriginal", relatorioGeral.getPlacaOriginal());
        }
        if(relatorioGeral.getPlacaVeiculo() != null) {
            query.setParameter("placaVeiculo", relatorioGeral.getPlacaVeiculo());
        }
        if(relatorioGeral.getProcesso() != null) {
            query.setParameter("processo", relatorioGeral.getProcesso());
        }
        if(relatorioGeral.getSeguro() != null) {
            query.setParameter("seguro", relatorioGeral.getSeguro());
        }
        if(relatorioGeral.getSituacao() != null) {
            query.setParameter("situacao",relatorioGeral.getSituacao());
        }
        return query.getResultList();
    }

    private String gerarQueryParaRelatorio (RelatorioGeral relatorioGeral) {
        int contador = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT p from Veiculo p ");
        if(relatorioGeral.getChassi() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.chassi = :chassi ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.chassi = :chassi ");
            }
        }
        if(relatorioGeral.getCor() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.cor.cor = :cor ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.cor.cor = :cor ");
            }
        }
        if(relatorioGeral.getData() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.dadosOcorrencia.dataEntrada = :data ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.dadosOcorrencia.dataEntrada = :data ");
            }
        }
        if(relatorioGeral.getDossie() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.dadosOcorrencia.dossie = :dossie ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.dadosOcorrencia.dossie = :dossie ");
            }
        }
        if(relatorioGeral.getExame() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.dadosOcorrencia.pericia.pericia = :exame ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.dadosOcorrencia.pericia.pericia = :exame ");
            }
        }
        if(relatorioGeral.getFabricante() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.modelo.fabricante.fabricante = :fabricante ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.modelo.fabricante.fabricante = :fabricante ");
            }
        }
        if(relatorioGeral.getLocalAtual() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.dadosOcorrencia.local.local = :localAtual ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.dadosOcorrencia.local.local = :localAtual ");
            }
        }
        if(relatorioGeral.getModelo() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.modelo.modelo = :modelo ");
                contador++;
            }
            else {
                stringBuilder.append("WHERE AND p.modelo.modelo = :modelo ");
            }
        }
        if(relatorioGeral.getPlacaOriginal() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.placaOriginal = :placaOriginal ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.placaOriginal = :placaOriginal ");
            }
        }
        if(relatorioGeral.getPlacaVeiculo() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.placa = :placaVeiculo ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.placa = :placaVeiculo ");
            }
        }
        if(relatorioGeral.getProcesso() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.dadosOcorrencia.processo = :processo ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.dadosOcorrencia.processo = :processo ");
            }
        }
        if(relatorioGeral.getSeguro() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.seguro.seguro = :seguro ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.seguro.seguro = :seguro ");
            }

        }
        if(relatorioGeral.getSituacao() != null) {
            if(contador == 0) {
                stringBuilder.append("WHERE p.dadosOcorrencia.situacao.situacao = :situacao ");
                contador++;
            }
            else {
                stringBuilder.append("AND p.dadosOcorrencia.situacao.situacao = :situacao ");
            }
        }
        return stringBuilder.toString();
    }
}
