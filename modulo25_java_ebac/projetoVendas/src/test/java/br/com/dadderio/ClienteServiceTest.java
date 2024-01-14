package br.com.dadderio;


import br.com.dadderio.dao.ClienteDaoMock;
import br.com.dadderio.dao.IClienteDAO;
import br.com.dadderio.domain.Cliente;
import br.com.dadderio.service.ClienteService;
import br.com.dadderio.service.IClienteService;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;


public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

        @Before
        public void init() {
            cliente = new Cliente();
            cliente.setCpf(12345678911L);
            cliente.setNome("Elaine");
            cliente.setTel(11987654321L);
        }

            @Test
            public void pesquisarCliente() {
            Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
            assertNotNull(clienteConsultado);
        }

            @Test
            public void salvarCliente(){
            Boolean retorno = clienteService.cadastrar(cliente);
            assertTrue(retorno);
        }

            @Test
            public void excluirCliente(){
            clienteService.excluir(cliente.getCpf());
        }

            @Test
            public void alterarCliente(){
            cliente.setNome("Elaine D");
            clienteService.alterar(cliente);
            assertEquals("Elaine D", cliente.getNome());
        }

}
