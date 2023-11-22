package br.edu.elaine.modulo15;

public class SUV implements Carro {

    @Override
    public void montar() {
        System.out.println("Montando um carro SUV.");
    }

    @Override
    public void pintar() {
        System.out.println("Pintando o carro SUV.");
    }

    @Override
    public void status() {
        System.out.println("Carro SUV criado.");
    }
}
