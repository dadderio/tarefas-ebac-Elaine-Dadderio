package br.com.elaine.streams;

import java.util.List;

public class Pessoa {
    String id;
    String nome;
    String nacionalidade;
    int idade;

    public Pessoa(){}

    public Pessoa(String id, String nome, String nacionalidade, int idade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public Pessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getNacionalidade(), pessoa.getIdade());
    }

    public List populaPessoas(){
        Pessoa pessoa1 = new Pessoa("p1","Mateus", "Brasil", 18);
        Pessoa pessoa2 = new Pessoa("p2","Aurora", "Brasil", 16);
        Pessoa pessoa3 = new Pessoa("p3","Aldo", "Peru", 21);
        Pessoa pessoa4 = new Pessoa("p4","Maria", "Bolivia", 22);
        Pessoa pessoa5 = new Pessoa("p5","Vera", "Argentina", 24);
        Pessoa pessoa6 = new Pessoa("p6","Maria", "Brasil", 20);
        Pessoa pessoa7 = new Pessoa("p7","Antonia", "Argentina", 23);
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6, pessoa7);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", idade=" + idade +
                '}';
    }
}
