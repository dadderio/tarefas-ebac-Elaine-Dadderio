package br.com.dadderio.domain;

import br.com.dadderio.annotation.TipoChave;
import br.com.dadderio.dao.Persistente;

public class Cliente implements Persistente {

    private String nome;

    @TipoChave("getCpf")
    private Long cpf;

    private Long tel;


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


}