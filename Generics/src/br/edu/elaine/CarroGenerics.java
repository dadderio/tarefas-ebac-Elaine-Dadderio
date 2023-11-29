package br.edu.elaine;

public class CarroGenerics<T extends Carro> {
    private T carro;

    public CarroGenerics(T carro) {
        this.carro = carro;
    }

    public void detalhesCarro() {
          System.out.println("Marca: " + carro.getMarca());
    }

    public void dirigirCarro() {
        carro.dirigir();
    }
}