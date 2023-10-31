package br.edu.dadderio.tarefa.mod13;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private Double valorFaturar;
    private Double imposto;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public Double renda() {
        return null;
    }
}
