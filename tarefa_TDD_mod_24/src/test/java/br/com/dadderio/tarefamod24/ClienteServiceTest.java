package br.com.dadderio.tarefamod24;

import br.com.dadderio.tarefamod24.dao.ClienteDaoMock;
import br.com.dadderio.tarefamod24.dao.IClienteDao;
import br.com.dadderio.tarefamod24.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest(){
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("sucesso", retorno);
    }
    @Test
    public void buscarTest(){
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.buscar();
        Assert.assertEquals("sucesso", retorno);
    }

    @Test
    public void excluirTest(){
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.excluir();
        Assert.assertEquals("sucesso", retorno);
    }

    @Test
    public void atualizarTest(){
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.atualizar();
        Assert.assertEquals("sucesso", retorno);
    }

}
