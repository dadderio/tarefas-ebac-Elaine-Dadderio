package br.com.dadderio.dao;


import br.com.dadderio.domain.Produto;
import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    Produto consultar(String codigoProduto) throws Exception;

    Integer excluir(Produto produto) throws Exception;

    List<Produto> buscarTodos() throws Exception;

    Integer atualizar(Produto produto) throws Exception;
}
