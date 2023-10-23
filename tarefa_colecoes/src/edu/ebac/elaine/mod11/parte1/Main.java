package edu.ebac.elaine.mod11.parte1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author elainef
 */

public class Main {
    public static void main(String[] args) {


        System.out.println("***************************************");
        System.out.println("Digite nomes separados por vírgula");
        System.out.println("***************************************");


        List <String> pessoas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String leitura = scanner.nextLine().toUpperCase();


        String [] nomes = leitura.split(", ");

        for(String nome: nomes){
            pessoas.add(nome);
        }

        Collections.sort(pessoas);

        System.out.println("***** Relação das pessoas ordenadas alfabeticamente *****");

        for(String p: pessoas){
            System.out.println(p);
        }
    }
}