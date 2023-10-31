package br.edu.dadderio.tarefa.mod13;

public abstract class Pessoa extends Endereco{
    private String nome;
    private String sobrenome;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
