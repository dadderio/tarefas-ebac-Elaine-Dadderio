package br.com.dadderio.service;

import br.com.dadderio.domain.Cliente;

public interface IClienteService {
    Boolean salvar(Cliente cliente);

    Cliente buscarPorCPF(Long cpf);

    Boolean cadastrar(Cliente cliente);

    void excluir(Long cpf);

    void alterar(Cliente cliente);
}