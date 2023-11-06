package br.edu.dadderio.dao;

import br.edu.dadderio.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    //consultar pelo cpf e retorna Cliente:
    public Cliente consultar(Long cpf);

    //buscarTodos retorna uma Coleção de Clientes:
    public Collection<Cliente> buscarTodos();

}
