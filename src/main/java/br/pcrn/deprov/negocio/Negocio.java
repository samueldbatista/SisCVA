package br.pcrn.deprov.negocio;

import br.pcrn.deprov.dao.*;
import br.pcrn.deprov.dominio.*;
import br.pcrn.deprov.dominio.relatorios.RelatorioGeral;
import br.pcrn.deprov.dominio.relatorios.RelatorioVeiculo;
import br.pcrn.deprov.util.OpcaoSelect;
import org.springframework.ui.Model;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Negocio {

    @Inject
    private ModeloDao modeloDao;

    @Inject
    private FabricanteDao fabricanteDao;

    @Inject
    private CorDao corDao;

    @Inject
    private PericiaDao periciaDao;

    @Inject
    private LocalDao localDao;

    @Inject
    private SeguroDao seguroDao;

    @Inject
    private SituacaoDao situacaoDao;

    @Inject
    private TipoDao tipoDao;

    @Inject
    private DelegaciaDao delegaciaDao;

    /**
     * Metodo responsável por gerar as informações para o relatório a partir da informações do veiculo.
     * @param veiculo
     * @return
     */
    public List<RelatorioVeiculo> gerarRelatorioVeiculo(Veiculo veiculo) {
        List<RelatorioVeiculo> relatorios = new ArrayList<>();
        if (veiculo.getOcorrencias().isEmpty() || veiculo.getOcorrencias() == null) {
            RelatorioVeiculo relatorioVeiculo = new RelatorioVeiculo(veiculo.getDadosOcorrencia().getChave(),
                    veiculo.getDadosOcorrencia().getDossie(), veiculo.getModelo().getFabricante().getFabricante(),
                    veiculo.getModelo().getModelo(), veiculo.getCor().getCor(), veiculo.getAnoFabricacao(), veiculo.getChassi(),
                    veiculo.getPlaca(), veiculo.getPlacaOriginal(), veiculo.getDadosOcorrencia().getIp(), veiculo.getDadosOcorrencia().getProcesso(),
                    veiculo.getDadosOcorrencia().getObs(), veiculo.getDadosOcorrencia().getMotivoApreensao());
            relatorios.add(relatorioVeiculo);
        } else {
            for (Ocorrencia ocorrencia : veiculo.getOcorrencias()) {
                RelatorioVeiculo relatorioVeiculo = new RelatorioVeiculo(veiculo.getDadosOcorrencia().getChave(),
                        veiculo.getDadosOcorrencia().getDossie(), veiculo.getModelo().getFabricante().getFabricante(),
                        veiculo.getModelo().getModelo(), veiculo.getCor().getCor(), veiculo.getAnoFabricacao(), veiculo.getChassi(),
                        veiculo.getPlaca(), veiculo.getPlacaOriginal(), veiculo.getDadosOcorrencia().getIp(), veiculo.getDadosOcorrencia().getProcesso(),
                        veiculo.getDadosOcorrencia().getObs(), veiculo.getDadosOcorrencia().getMotivoApreensao());
                relatorioVeiculo.setDescricaoOcorrencia(ocorrencia.getOcorrencia());
                relatorioVeiculo.setDataEntrada(formatDate(ocorrencia.getData().toString()));
                relatorios.add(relatorioVeiculo);
            }
        }
        return relatorios;
    }

    private String formatDate(String data) {
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        String reformattedStr ="";

        try {

            reformattedStr = myFormat.format(fromUser.parse(data));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reformattedStr;
    }

    public List<RelatorioGeral> gerarRelatorioFiltrado(List<Veiculo> veiculos) {
        List<RelatorioGeral> relatorios = new ArrayList<>();
        for (Veiculo veiculo: veiculos) {
            RelatorioGeral relatorioGeral = new RelatorioGeral(veiculo.getDadosOcorrencia().getDossie(),
                    retornarData(veiculo),
                    veiculo.getPlaca(), veiculo.getPlacaOriginal(),
                    retornarFabricante(veiculo), retornarModelo(veiculo),
                    retornarCor(veiculo),retornarSeguro(veiculo),
                    retornarLocal(veiculo),
                    retornarPericia(veiculo),
                    retornarSituacao(veiculo), veiculo.getChassi(),veiculo.getDadosOcorrencia().getProcesso(),veiculos.size());
            relatorios.add(relatorioGeral);

        }
        return relatorios;
    }

    public String retornarData(Veiculo veiculo) {
        if(veiculo.getDadosOcorrencia() != null) {
            if(veiculo.getDadosOcorrencia().getDataEntrada() != null) {
                return veiculo.getDadosOcorrencia().getDataEntrada().toString();
            }
        }
        return "";
    }

    public String retornarModelo(Veiculo veiculo) {
        if(veiculo.getModelo() != null) {
            return veiculo.getModelo().getModelo();
        }
        return "";
    }
    public String retornarFabricante(Veiculo veiculo) {
        if(veiculo.getModelo() != null) {
            if(veiculo.getModelo().getFabricante() != null) {
                return veiculo.getModelo().getFabricante().getFabricante();
            }
        }
        return "";
    }
    public String retornarCor(Veiculo veiculo) {
        if(veiculo.getCor() != null) {
            return veiculo.getCor().getCor();
        }
        return "";
    }
    public String retornarSeguro(Veiculo veiculo) {
        if(veiculo.getSeguro() != null) {
            return veiculo.getSeguro().getSeguro();
        }
        return "";
    }
    public String retornarLocal(Veiculo veiculo) {
        if(veiculo.getDadosOcorrencia() != null) {
            if(veiculo.getDadosOcorrencia().getLocal() != null){
                return veiculo.getDadosOcorrencia().getLocal().getLocal();
            }
        }
        return "";
    }
    public String retornarPericia(Veiculo veiculo) {
        if(veiculo.getDadosOcorrencia() != null) {
            if(veiculo.getDadosOcorrencia().getPericia() != null){
                return veiculo.getDadosOcorrencia().getPericia().getPericia();
            }
        }
        return "";
    }
    public String retornarSituacao(Veiculo veiculo) {
        if(veiculo.getDadosOcorrencia() != null) {
            if(veiculo.getDadosOcorrencia().getSituacao() != null)
            return veiculo.getDadosOcorrencia().getSituacao().getSituacao();
        }
        return "";
    }

    public List<OpcaoSelect> geraListaOpcoesModelo() {
        List<Modelo> todos = this.modeloDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                modelo -> new OpcaoSelect(modelo.getModelo(), modelo.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesFabricante() {
        List<Fabricante> todos = this.fabricanteDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                fabricante -> new OpcaoSelect(fabricante.getFabricante(), fabricante.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesCor() {
        List<Cor> todos = this.corDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                cor -> new OpcaoSelect(cor.getCor(), cor.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesPericia() {
        List<Pericia> todos = this.periciaDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                pericia -> new OpcaoSelect(pericia.getPericia(), pericia.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesLocal() {
        List<Local> todos = this.localDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                local -> new OpcaoSelect(local.getLocal(), local.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesSeguro() {
        List<Seguro> todos = this.seguroDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                seguro -> new OpcaoSelect(seguro.getSeguro(), seguro.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesSituacoes() {
        List<Situacao> todos = this.situacaoDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                situacao -> new OpcaoSelect(situacao.getSituacao(), situacao.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesTipo() {
        List<Tipo> todos = this.tipoDao.todos().stream().collect(Collectors.toList());
        return todos.stream().map(
                tipo -> new OpcaoSelect(tipo.getTipo(), tipo.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesDelegacia() {
        List<Delegacia> todos = this.delegaciaDao.listar();
        return todos.stream().map(
                delegacia -> new OpcaoSelect(delegacia.getNome(), delegacia.getId()))
                .collect(Collectors.toList());
    }

}
