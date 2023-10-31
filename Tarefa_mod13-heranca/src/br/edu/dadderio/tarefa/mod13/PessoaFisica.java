package br.edu.dadderio.tarefa.mod13;

public class PessoaFisica extends Pessoa{
    private String cpf;

    private Endereco endereco;


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Pessoa Fisica {" +
                "nome= " + this.getNome() +" "+
                "sobrenome= " + this.getSobrenome() +" "+
                "cpf= " + cpf +
                ", endereco=" + this.getLogradouro() +
                ", "+ this.getCidade()+", "+ this.getUf() +" "+

                '}';
    }
}
