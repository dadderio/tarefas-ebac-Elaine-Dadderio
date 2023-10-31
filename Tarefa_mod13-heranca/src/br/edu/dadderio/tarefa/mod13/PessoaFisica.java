package br.edu.dadderio.tarefa.mod13;

public class PessoaFisica extends Pessoa{
    private String cpf;
    private Double valorReceber;



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public Double renda() {
        return null;
    }
}
