package br.com.dadderio.domain;

import br.com.dadderio.annotation.TipoChave;
import br.com.dadderio.dao.Persistente;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Venda implements Persistente {

    @TipoChave("getCodigo")
    private String codigo;
    private Cliente cliente;
    private Set<ProdutoQtde> produtos;
    private BigDecimal valorTotal;
    private Instant dataVenda;

    public Venda(){
        produtos = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQtde> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoQtde> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void adicionarProduto(Produto produto, Integer quantidade) {
        Optional<ProdutoQtde> op =   produtos.stream()
                .filter (filter -> filter.getProduto().getCodigo().equals(produto.getCodigo()))
                .findAny();
        if (op.isPresent()) {
            ProdutoQtde produtoQtd = op.get();
            produtoQtd.adicionarProduto(quantidade);
        } else {
            ProdutoQtde prod = new ProdutoQtde();
            prod.setProduto(produto);
            prod.adicionarProduto(quantidade);
            produtos.add(prod);
        }
        recalcularValorTotalVenda();
    }
    public void removerProduto(Produto produto, Integer quantidade) {
        Optional<ProdutoQtde> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if (op.isPresent()) {
            ProdutoQtde produtoQtde = op.get();
            if (produtoQtde.getQuantidade()>quantidade) {
                produtoQtde.remover(quantidade);
                recalcularValorTotalVenda();
            } else {
                produtos.remove(op.get());
                recalcularValorTotalVenda();
            }
        }
    }

    public void removerTodosProdutos() {
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos() {
        int result = produtos.stream()
                .reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }

    private void recalcularValorTotalVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQtde prod : this.produtos) {
            valorTotal = valorTotal.add(prod.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }
}
