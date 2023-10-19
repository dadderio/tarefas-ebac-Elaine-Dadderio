package edu.ebac.elaine.modulo9;

/**
 * @author Elaine
 */

import java.util.Scanner;

public class ExercicioModulo9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número de 0 a 10: ");

        int numero = scanner.nextInt();

        if (numero >= 0 && numero <=10){
            //Boxing:
            Integer numeroInteger = numero;
            System.out.println("O número int = "+ numero +" foi convertido para Integer = "+numeroInteger+".");
        }else{
            System.out.println("O número "+numero+" não foi convertido para Integer.");
        }
    }
}
