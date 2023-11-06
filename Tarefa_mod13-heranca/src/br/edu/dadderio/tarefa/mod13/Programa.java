package br.edu.dadderio.tarefa.mod13;

public class Programa {

    public static void main(String[] args) {

        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Maria");
        pf.setSobrenome("da Silva");
        pf.setCpf("123456789-00");
        pf.setLogradouro("rua A");
        pf.setCidade("SCS");
        pf.setUf("SP");
        System.out.println(pf);

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Mario");
        pj.setSobrenome("dos Santos");
        pj.setCnpj("987654321-00");
        pj.setLogradouro("rua B");
        pj.setCidade("SBC");
        pj.setUf("SP");
        System.out.println(pj);
    }


}
