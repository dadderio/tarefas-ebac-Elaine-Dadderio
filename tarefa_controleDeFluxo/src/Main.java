import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double soma = 0;
        double media = 0;
        List<Double> notas = new ArrayList<>();

        for(int i = 1; i <= 4; i++) {
            System.out.println("DIGITE A " + i + ".ª NOTA DE 0 A 10: ");
            double nota = scanner.nextDouble();
            while(nota < 0 || nota > 10 ){
                System.out.println("Atenção: a nota digitada está fora do range de 0 a 10");
                System.out.println("DIGITE NOVAMENTE A " + i + ".ª NOTA DE 0 A 10: ");
                nota = scanner.nextDouble();
                }
            soma = soma + nota;
            media = soma / i;
            notas.add(nota);
        }
        System.out.println("Notas válidas digitadas: "+notas);

        if(media >=7){
            System.out.println("Média igual a "+ media +": aprovado");
        }else if(media >=5){
            System.out.println("Média igual a "+ media +": recuperação");
        }else{
            System.out.println("Média igual a "+ media +": reprovado");
        }
    }
}