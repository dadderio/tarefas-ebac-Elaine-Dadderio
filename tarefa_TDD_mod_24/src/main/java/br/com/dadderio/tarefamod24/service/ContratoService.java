package br.com.dadderio.tarefamod24.service;

import br.com.dadderio.tarefamod24.dao.IContratoDao;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;

    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "sucesso";
    }

    @Override
    public String buscar() {
        return "sucesso";
    }

    @Override
    public String excluir() {
        return "sucesso";
    }

    @Override
    public String atualizar() {
        return "sucesso";
    }


}
