package com.dadderio.services;

import com.dadderio.dao.IProdutoDAO;
import com.dadderio.domain.Produto;
import com.dadderio.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
