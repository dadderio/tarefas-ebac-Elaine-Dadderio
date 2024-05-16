package br.com.dadderio.service;

import br.com.dadderio.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;

public  class ClienteService  implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return clienteDAO.consultar(cpf);
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
    public Boolean salvar(Cliente cliente) {
        return clienteDAO.cadastrar(cliente);
    }


}
