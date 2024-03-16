package br.com.dadderio.dao;

import br.com.dadderio.domain.Cliente;

import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    Cliente consultar(String codigo) throws Exception;

    Integer excluir(Cliente cliente) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    Integer atualizar(Cliente cliente) throws Exception;
}
