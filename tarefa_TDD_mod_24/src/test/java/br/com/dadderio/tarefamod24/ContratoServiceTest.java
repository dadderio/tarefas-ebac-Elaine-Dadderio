package br.com.dadderio.tarefamod24;


import br.com.dadderio.tarefamod24.dao.ContratoDao;
import br.com.dadderio.tarefamod24.dao.IContratoDao;
import br.com.dadderio.tarefamod24.dao.mock.ContratoDaoMock;
import br.com.dadderio.tarefamod24.service.ContratoService;
import br.com.dadderio.tarefamod24.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("sucesso", retorno);

    }

    @Test
    public void buscarTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("sucesso", retorno);
    }

    @Test
    public void excluirTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("sucesso", retorno);
    }

    @Test
    public void atualizarTest(){
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("sucesso", retorno);
    }




    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest(){
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("sucesso", retorno);
    }
}
