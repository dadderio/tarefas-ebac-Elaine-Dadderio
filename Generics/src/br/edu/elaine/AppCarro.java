package br.edu.elaine;

import java.util.ArrayList;
import java.util.List;

public class AppCarro {
    public static void main(String[] args) {

        Honda honda = new Honda();
        Hyundai hyundai = new Hyundai();
        Nissan nissan = new Nissan();


        List<Carro> carrosList = new ArrayList<Carro>();
        carrosList.add(honda);
        carrosList.add(nissan);
        carrosList.add(hyundai);

        for (Carro carro : carrosList) {
            CarroGenerics<Carro> carroGenerico = new CarroGenerics<>(carro);
            carroGenerico.detalhesCarro();
            carroGenerico.dirigirCarro();

            System.out.println("=====================================================");
        }
    }
}