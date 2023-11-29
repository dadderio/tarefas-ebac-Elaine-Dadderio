package br.edu.elaine;

public class Nissan extends Carro {
    public Nissan() {
        super("Nissan");
    }

    @Override
    public void dirigir() {
        System.out.println("Dirigindo um Nissan...");
    }
}