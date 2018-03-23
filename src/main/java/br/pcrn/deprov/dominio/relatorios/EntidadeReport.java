package br.pcrn.deprov.dominio.relatorios;

import br.com.caelum.vraptor.jasperreports.Report;
import br.pcrn.deprov.dominio.relatorios.RelatorioVeiculo;

import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class EntidadeReport<T extends Relatorio> implements Report{

    private final List<T> data;
    private Map<String, Object> parameters;
    private String template;

    public EntidadeReport(List<T> data, String template, ServletContext context) {

        this.data = data;
        this.template = template;
        this.parameters = new HashMap<>();
        addParameter("diretorio_base", context.getRealPath("/") );

    }



    @Override
    public String getTemplate() {
        return template;
    }


    @Override
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public Collection<T> getData() {
        return data;
    }

    @Override
    public String getFileName() {
        return "report" + System.currentTimeMillis();
    }

    @Override
    public Report addParameter(String parameter, Object value) {
        parameters.put(parameter, value);
        return this;
    }

    @Override
    public boolean isCacheable() {
        return false;
    }

}
