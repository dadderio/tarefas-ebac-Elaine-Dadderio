package br.com.dadderio;

import br.com.dadderio.dao.ClienteDAO;
import br.com.dadderio.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class ClienteTest {

   @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Elaine");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(cliente);
       assertNotNull(qtdDel);
   }

    @Test
    public void buscarTest()throws Exception{
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Elaine");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel);
    }

    @Test
    public void excluirTest() throws Exception{
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Elaine");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTodosTest()throws Exception{
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente1 = new Cliente();
        cliente1.setCodigo("01");
        cliente1.setNome("Elaine");
        Integer qtdCli1 = dao.cadastrar(cliente1);
        assertTrue(qtdCli1 == 1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Marcelo");

        Integer qtdCli2 = dao.cadastrar(cliente2);
        assertTrue(qtdCli2 == 1);

        List<Cliente> listaClientes = dao.buscarTodos();
        assertNotNull(listaClientes);
        assertEquals(2, listaClientes.size());

        int countDel = 0;
        for(Cliente cliente : listaClientes){
            dao.excluir(cliente);
            countDel++;
        }

        listaClientes = dao.buscarTodos();
        assertEquals(listaClientes.size(), 0);
    }

    @Test
    public void atualizarTest() throws Exception {
       IClienteDAO dao = new ClienteDAO();

       Cliente cliente = new Cliente();
       cliente.setCodigo("01");
       cliente.setNome("Maria");
       Integer qtd = dao.cadastrar(cliente);
       assertTrue(qtd == 1);

       Cliente clienteDB = dao.consultar("01");
       assertNotNull(clienteDB);
       assertEquals(cliente.getNome(), clienteDB.getNome());
       assertEquals(cliente.getCodigo(), clienteDB.getCodigo());

       clienteDB.setCodigo("02");
       clienteDB.setNome("Renata");
       Integer qtd2 = dao.atualizar(clienteDB);
       assertTrue(qtd2 == 1);

       Cliente clienteDB1 = dao.consultar("01");
       assertNull(clienteDB1);

       Cliente clienteDB2 = dao.consultar("02");
       assertNotNull(clienteDB2);
       assertEquals(clienteDB2.getId(), clienteDB.getId());
       assertEquals(clienteDB2.getNome(), clienteDB.getNome());
       assertEquals(clienteDB2.getCodigo(), clienteDB.getCodigo());

       List<Cliente> listaClientes = dao.buscarTodos();
       for (Cliente cli : listaClientes){
           dao.excluir(cli);
       }
       assertEquals(listaClientes.size(), 1);
    }

}
