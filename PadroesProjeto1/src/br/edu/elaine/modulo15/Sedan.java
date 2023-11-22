package br.edu.elaine.modulo15;


    public class Sedan implements Carro {
        @Override
        public void montar() {
            System.out.println("Montando um carro sedan.");
        }

        @Override
        public void pintar() {
            System.out.println("Pintando o carro sedan.");
        }

        @Override
        public void status() {
            System.out.println("Carro sedan criado.");
        }

}

