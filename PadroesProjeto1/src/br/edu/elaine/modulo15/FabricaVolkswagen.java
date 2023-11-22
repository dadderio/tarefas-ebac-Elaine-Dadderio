package br.edu.elaine.modulo15;

public class FabricaVolkswagen implements FabricaDeCarro{
    @Override
    public Carro criarCarro() {
        return new Sedan();
    }
}
