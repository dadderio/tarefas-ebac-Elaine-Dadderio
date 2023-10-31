package br.edu.elainedadderio.tarefa.modulo12;
public class Pessoa {
    private String nome;
    private char genero;

    public Pessoa(String nome, char genero) {
        this.nome = nome;
        this.genero = genero;
    }
    public Pessoa(){

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", genero=" + genero +
                '}';
    }
}
