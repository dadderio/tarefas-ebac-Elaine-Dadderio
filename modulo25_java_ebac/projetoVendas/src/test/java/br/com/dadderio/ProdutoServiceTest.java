package br.com.dadderio;

import br.com.dadderio.dao.IProdutoDAO;
import br.com.dadderio.dao.ProdutoDaoMock;
import br.com.dadderio.domain.Produto;
import br.com.dadderio.service.IProdutoService;
import br.com.dadderio.service.ProdutoService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init(){
        produto = new Produto();
        produto.setCodigo("A1");
        produto.setNome("Produto A");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void salvar() {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() {
        produto.setNome("A2");
        produtoService.alterar(produto);
        Assert.assertEquals("A2", produto.getNome());
    }
}




