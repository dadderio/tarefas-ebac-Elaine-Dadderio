package br.com.dadderio.dao;

import br.com.dadderio.dao.generic.GenericDAO;
import br.com.dadderio.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setTel(entity.getTel());

    }



}
