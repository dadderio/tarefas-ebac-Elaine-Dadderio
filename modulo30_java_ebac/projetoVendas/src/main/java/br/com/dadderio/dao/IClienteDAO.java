package br.com.dadderio.dao;

import br.com.dadderio.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {
    Cliente consultar(Long cpf);


    Boolean cadastrar(Cliente cliente);

    void excluir(Long cpf);

    void alterar(Cliente cliente);

    Collection<Cliente> buscarTodos();
}
