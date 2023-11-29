package br.edu.elaine;

public class AppCarro {
    public static void main(String[] args) {

        Honda honda = new Honda();
        Hyundai hyundai = new Hyundai();
        Nissan nissan = new Nissan();

        CarroGenerics<Honda> carroHonda = new CarroGenerics<>(honda);
        carroHonda.detalhesCarro();
        carroHonda.dirigirCarro();

        CarroGenerics<Hyundai> carroHyundai = new CarroGenerics<>(hyundai);
        carroHyundai.detalhesCarro();
        carroHyundai.dirigirCarro();

        CarroGenerics<Nissan> carroNissan = new CarroGenerics<>(nissan);
        carroNissan.detalhesCarro();
        carroNissan.dirigirCarro();
    }
}