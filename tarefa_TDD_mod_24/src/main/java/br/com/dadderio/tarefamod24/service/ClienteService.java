package br.com.dadderio.tarefamod24.service;

import br.com.dadderio.tarefamod24.dao.IClienteDao;

public class ClienteService implements IClienteService {

    private IClienteDao mockDao;

    public ClienteService(IClienteDao mockDao) {
        this.mockDao = mockDao;
    }

    public String salvar() {
        mockDao.salvar();
        return "sucesso";
    }

    public String buscar() {
        return "sucesso";
    }

    public String excluir() {
        return "sucesso";
    }


    public String atualizar() {
        return "sucesso";

    }
}
