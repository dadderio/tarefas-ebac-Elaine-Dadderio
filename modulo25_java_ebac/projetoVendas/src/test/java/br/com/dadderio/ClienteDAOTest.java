package br.com.dadderio;

import br.com.dadderio.dao.ClienteDAO;
import br.com.dadderio.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAO();
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12345678911L);
        cliente.setNome("Elaine");
        cliente.setTel(11987654321L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente(){
        cliente.setCpf(12345678910L);
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }


    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() {
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
}
