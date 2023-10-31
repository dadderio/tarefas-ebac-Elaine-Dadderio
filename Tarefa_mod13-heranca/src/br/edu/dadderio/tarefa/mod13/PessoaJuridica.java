package br.edu.dadderio.tarefa.mod13;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    private Endereco endereco;



    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Pessoa Juridica {" +
                "nome= " + this.getNome() +" "+
                "sobrenome= " + this.getSobrenome() +" "+
                "cnpj= " + cnpj +
                ", endereco=" + this.getLogradouro() +
                ", "+ this.getCidade()+", "+ this.getUf() +" "+

                '}';
    }

}
