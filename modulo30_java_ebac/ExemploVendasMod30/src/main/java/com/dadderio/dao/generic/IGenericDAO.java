package com.dadderio.dao.generic;

import com.dadderio.dao.Persistente;
import com.dadderio.exceptions.DAOException;
import com.dadderio.exceptions.MaisDeUmRegistroException;
import com.dadderio.exceptions.TableException;
import com.dadderio.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public void excluir(E valor) throws DAOException;

    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    public Collection<T> buscarTodos() throws DAOException;
}
