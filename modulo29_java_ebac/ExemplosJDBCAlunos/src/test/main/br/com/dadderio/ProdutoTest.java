package br.com.dadderio;


import br.com.dadderio.dao.IProdutoDAO;
import br.com.dadderio.dao.ProdutoDAO;
import br.com.dadderio.domain.Produto;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;


public class ProdutoTest {
    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigoProduto("01");
        produto.setNomeProduto("caneta");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigoProduto());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getIdProduto());
        assertEquals(produto.getCodigoProduto(), produtoBD.getCodigoProduto());
        assertEquals(produto.getNomeProduto(), produtoBD.getNomeProduto());

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTest()throws Exception{
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigoProduto("01");
        produto.setNomeProduto("caneta");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigoProduto());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getIdProduto());
        assertEquals(produto.getCodigoProduto(), produtoBD.getCodigoProduto());
        assertEquals(produto.getNomeProduto(), produtoBD.getNomeProduto());

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel);
    }

    @Test
    public void excluirTest() throws Exception{
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        produto.setCodigoProduto("01");
        produto.setNomeProduto("caneta");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigoProduto());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getIdProduto());
        assertEquals(produto.getCodigoProduto(), produtoBD.getCodigoProduto());
        assertEquals(produto.getNomeProduto(), produtoBD.getNomeProduto());

        Integer qtdDel = dao.excluir(produto);
        assertNotNull(qtdDel);
    }

    @Test
    public void buscarTodosTest()throws Exception{

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto1 = new Produto();
        produto1.setCodigoProduto("01");
        produto1.setNomeProduto("caneta");
        Integer qtdPro1 = dao.cadastrar(produto1);
        assertTrue(qtdPro1 == 1);

        Produto produto2 = new Produto();
        produto2.setCodigoProduto("02");
        produto2.setNomeProduto("lápis");

        Integer qtdPro2 = dao.cadastrar(produto2);
        assertTrue(qtdPro2 == 1);

        List<Produto> listaProdutos = dao.buscarTodos();
        assertNotNull(listaProdutos);
        assertEquals(2, listaProdutos.size());

        int countDel = 0;
        for(Produto produto : listaProdutos){
            dao.excluir(produto);
            countDel++;
        }

        listaProdutos = dao.buscarTodos();
        assertEquals(listaProdutos.size(), 0);
    }

    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigoProduto("01");
        produto.setNomeProduto("borracha");
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoDB = dao.consultar("01");
        assertNotNull(produtoDB);
        assertEquals(produto.getNomeProduto(), produtoDB.getNomeProduto());
        assertEquals(produto.getCodigoProduto(), produtoDB.getCodigoProduto());

        produtoDB.setCodigoProduto("02");
        produtoDB.setNomeProduto("caderno");
        Integer qtd2 = dao.atualizar(produtoDB);
        assertTrue(qtd2 == 1);

        Produto produtoDB1 = dao.consultar("01");
        assertNull(produtoDB1);

        Produto produtoDB2 = dao.consultar("02");
        assertNotNull(produtoDB2);
        assertEquals(produtoDB2.getIdProduto(), produtoDB.getIdProduto());
        assertEquals(produtoDB2.getNomeProduto(), produtoDB.getNomeProduto());
        assertEquals(produtoDB2.getCodigoProduto(), produtoDB.getCodigoProduto());

        List<Produto> listaProdutos = dao.buscarTodos();
        for (Produto pro : listaProdutos){
            dao.excluir(pro);
        }
        assertEquals(listaProdutos.size(), 1);
    }

}
