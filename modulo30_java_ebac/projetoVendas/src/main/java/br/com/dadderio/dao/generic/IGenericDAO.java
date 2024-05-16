package br.com.dadderio.dao.generic;

import br.com.dadderio.dao.Persistente;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {


    public Boolean cadastrar(T entity);


    public void excluir(E valor);


    public void alterar(T entity) ;


    public T consultar(E valor);


    public Collection<T> buscarTodos();
}
