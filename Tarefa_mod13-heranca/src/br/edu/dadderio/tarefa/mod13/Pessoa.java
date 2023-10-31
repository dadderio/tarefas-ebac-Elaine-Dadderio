package br.edu.dadderio.tarefa.mod13;

import java.util.List;

public abstract class Pessoa{
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private List<Pessoa> pessoas;


    public void adicionar(Pessoa pessoa){
        this.pessoas.add(pessoa);
    }

    public abstract Double renda();

    public void imprimirRenda(){
        Double valor = renda();
        System.out.println(valor);
    }
}
