package br.com.dadderio;

import br.com.dadderio.dao.ClienteDAO;
import br.com.dadderio.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @After
    public void end() throws DAOException{
        Collection<Cliente> list = clienteDao.buscarTodos();
        list.forEach(cli -> {
            try {
                clienteDao.excluir(cli.getCpf());
            } catch (DAOException e){
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws MaisDeUmRegistroExpection, TableException, TipoChaveNaoEncontrada{
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Roberto");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);
        clienteDao.cadastrar(cliente);


    }

    @Test
    public void salvarCliente(){
        Cliente cliente = new Cliente();
        cliente.setCpf(12345678910L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }


    @Test
    public void excluirCliente() {
        Cliente cliente = new Cliente();
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Elaine F");
        clienteDao.alterar(cliente);
        Assert.assertEquals("Elaine F", cliente.getNome());
    }

    @Test
    public void buscarTodos() {
        Collection<Cliente> list = clienteDao.buscarTodos();
        Assert.assertTrue(list != null);
        Assert.assertTrue(list.size() == 2);
    }

    private class DAOException extends Exception {
    }

    private class TableException extends Exception {
    }

    private class TipoChaveNaoEncontrada extends Exception {
    }
}
