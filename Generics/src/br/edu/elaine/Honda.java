package br.edu.elaine;

public class Honda extends Carro {
    public Honda() {
        super("Honda");
    }

    @Override
    public void dirigir() {
        System.out.println("Dirigindo um Honda...");
    }
}