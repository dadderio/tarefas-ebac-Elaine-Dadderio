package br.edu.elaine.modulo15;

public class FabricaFord implements FabricaDeCarro{
    @Override
    public Carro criarCarro() {
        return new SUV();
    }
}
