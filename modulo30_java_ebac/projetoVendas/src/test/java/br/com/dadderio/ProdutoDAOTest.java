package br.com.dadderio;

import br.com.dadderio.dao.IProdutoDAO;
import br.com.dadderio.dao.ProdutoDAO;
import br.com.dadderio.domain.Produto;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static junit.framework.TestCase.*;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDao;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setNome("Prod 12");
        produto.setValor(BigDecimal.TEN);
        produtoDao.cadastrar(produto);
    }

    @Test
    public void pesquisar() {
        Produto produto = this.produtoDao.consultar(this.produto.getCodigo());
        assertNotNull(produto);
    }

    @Test
    public void salvar()  {
        produto.setCodigo("A2");
        Boolean retorno = produtoDao.cadastrar(produto);
        assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoDao.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente()  {
        produto.setNome("Maria das Dores");
        produtoDao.alterar(produto);
        assertEquals("Maria das Dores", produto.getNome());
    }

    @Test
    public void buscarTodos() {
        Collection<Produto> list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());
    }
}