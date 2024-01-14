package br.com.dadderio.domain;

import br.com.dadderio.annotation.TipoChave;
import br.com.dadderio.dao.Persistente;

import java.math.BigDecimal;

public class Produto implements Persistente {

    @TipoChave("getCodigo")
    private String codigo;

    private String nome;


    private BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
