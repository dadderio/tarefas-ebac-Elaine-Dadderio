package com.dadderio.dao;

import com.dadderio.dao.generic.IGenericDAO;
import com.dadderio.domain.Venda;
import com.dadderio.exceptions.DAOException;
import com.dadderio.exceptions.TipoChaveNaoEncontradaException;
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
