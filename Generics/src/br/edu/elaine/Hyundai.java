package br.edu.elaine;

public class Hyundai extends Carro {
    public Hyundai() {
        super("Hyundai");
    }

    @Override
    public void dirigir() {
        System.out.println("Dirigindo um Hyundai...");
    }
}