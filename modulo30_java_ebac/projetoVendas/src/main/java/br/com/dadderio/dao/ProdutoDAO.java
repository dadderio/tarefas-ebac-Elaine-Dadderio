package br.com.dadderio.dao;

import br.com.dadderio.dao.generic.GenericDAO;
import br.com.dadderio.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements  IProdutoDAO{

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
            entityCadastrado.setCodigo(entity.getCodigo());
            entityCadastrado.setNome(entity.getNome());
            entityCadastrado.setValor(entity.getValor());
    }
}
