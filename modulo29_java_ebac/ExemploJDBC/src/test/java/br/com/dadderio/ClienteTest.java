package br.com.dadderio;

import br.com.dadderio.dao.generic.jdbc.dao.ClienteDAO;
import br.com.dadderio.dao.generic.jdbc.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;
import org.junit.Test;

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

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue (countDel == 1);
    }
}
