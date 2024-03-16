package br.com.dadderio;

import br.com.dadderio.dao.generic.jdbc.dao.ClienteDAO;
import br.com.dadderio.dao.generic.jdbc.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTest() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Renato Santos");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());

        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue (countDel == 1);
    }
    @Test
    public void buscarTest() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Renato Santos");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());

        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue (countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Renato Santos");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());

        Integer countDel = clienteDAO.excluir(clienteDB);
        assertTrue (countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Renato Santos");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clientes = new Cliente();
        clientes.setCodigo("12");
        clientes.setNome("Elaine Santos");
        Integer countCad2 = clienteDAO.cadastrar(clientes);
        assertTrue(countCad2 ==1);

        List<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for(Cliente cli : list){
            clienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = clienteDAO.buscarTodos();
        assertEquals(list.size(), 0);
    }

    @Test
    public void atualizarTest() throws Exception{
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Renato Santos");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteDB = clienteDAO.buscar("10");
        assertNotNull(clienteDB);
        assertEquals(cliente.getCodigo(), clienteDB.getCodigo());
        assertEquals(cliente.getNome(), clienteDB.getNome());

        clienteDB.setCodigo("20");
        clienteDB.setNome("Outro nome");
        Integer countUpdate = clienteDAO.atualizar(clienteDB);
        assertTrue(countUpdate == 1);

        Cliente clienteDB1 = clienteDAO.buscar("10");
        assertNull(clienteDB1);

        Cliente clienteDB2 = clienteDAO.buscar("20");
        assertNotNull(clienteDB2);
        assertEquals(clienteDB.getId(), clienteDB2.getId());
        assertEquals(clienteDB.getCodigo(), clienteDB2.getCodigo());
        assertEquals(clienteDB.getNome(), clienteDB2.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list){
            clienteDAO.excluir(cli);
        }
    }
}

