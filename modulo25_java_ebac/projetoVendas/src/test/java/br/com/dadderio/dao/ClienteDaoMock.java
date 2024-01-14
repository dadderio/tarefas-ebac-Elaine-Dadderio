package br.com.dadderio.dao;

import br.com.dadderio.domain.Cliente;

import java.util.Collection;

public class ClienteDaoMock implements IClienteDAO{


    @Override
    public Cliente consultar(Long cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        return cliente;
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        return true;
    }

    @Override
    public void excluir(Long cpf) {

    }

    @Override
    public void alterar(Cliente cliente) {

    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
