package br.edu.dadderio.domain;

import java.util.Objects;

public class Cliente {
    private String nome;//0
    private Long cpf;//1
    private Long tel;//2
    private String end;//3
    private Integer numero;//4
    private String cidade;//5
    private String estado;//6

    public Cliente(String nome, String cpf, String tel, String end, String numero, String cidade, String estado) {
        this.nome = nome;
        //recebe como parâmetro uma String e é convertida em Long, tanto cpf quanto tel:
        this.cpf = Long.valueOf(cpf.trim());
        this.tel = Long.valueOf(tel.trim());
        this.end = end;
        //recebe como parâmetro uma String e é convertida em Integer, o caso do numero:
        this.numero = Integer.valueOf(numero.trim());
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {

        return cpf;
    }

    public void setCpf(Long cpf) {

        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

//necessário equals, porque estamos usando HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }
//necessário hashCode porque estamos usando HashMap
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente :" +
                "nome= " + nome + '\'' +
                ", cpf= " + cpf;
    }
}
