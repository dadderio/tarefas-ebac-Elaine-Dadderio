package br.edu.elaine.modulo15;

public class Cliente {
    public static void main(String[] args) {
        //Aqui estou criando a volksFabrica
        FabricaDeCarro volksFabrica = new FabricaVolkswagen();

        //Aqui estou criando um carroVolks, pela volksFabrica;
        Carro carroVolks = volksFabrica.criarCarro();

        carroVolks.montar();
        carroVolks.pintar();
        carroVolks.status();

        System.out.println("=====================================================");

        //Aqui estou criando a fordFabrica
        FabricaDeCarro fordFabrica = new FabricaFord();

        //Aqui estou criando um carroFord, pela fordFabrica;
        Carro carroFord = fordFabrica.criarCarro();

        carroFord.montar();
        carroFord.pintar();
        carroFord.status();
    }
}
