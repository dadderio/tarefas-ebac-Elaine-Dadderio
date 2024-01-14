package br.com.dadderio.service;

import br.com.dadderio.dao.IProdutoDAO;
import br.com.dadderio.domain.Cliente;
import br.com.dadderio.domain.Produto;
import br.com.dadderio.service.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        return true;
    }
}