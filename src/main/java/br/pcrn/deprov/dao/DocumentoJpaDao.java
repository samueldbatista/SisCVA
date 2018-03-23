package br.pcrn.deprov.dao;

import br.pcrn.deprov.dominio.Documento;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DocumentoJpaDao extends EntidadeJpaDao<Documento> implements DocumentoDao{

    @Deprecated
    protected DocumentoJpaDao(){
        this(null);
    }

    @Inject
    public DocumentoJpaDao(EntityManager entityManager) {
        super(entityManager, Documento.class);
    }


}
