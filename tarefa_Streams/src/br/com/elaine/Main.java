package br.com.elaine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Author: Elaine D'Adderio
 */

public class Main {

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        do{
            System.out.println(
                    """
                    \n
                    =============================
                    DIGITE
                    =============================
                    1 - cadastrar pessoas
                    
                    2 - listar gênero feminino
                    
                    3 - listar gênero masculino
                    
                    4 - sair
                    =============================
                                        """
            );

            Scanner leitura = new Scanner(System.in);
            int opcaoEscolhida = leitura.nextInt();

            if(opcaoEscolhida > 0 && opcaoEscolhida < 5){
                switch (opcaoEscolhida){
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        listarMulheres();
                        break;
                    case 3:
                        listarHomens();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        System.exit(0);
                }
            }else{
                System.out.println("Tente novamente");
            }
        }while (true);
    }

    private static List <String> listaDePessoas = new ArrayList<>();

    private static void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite as pessoas e seus gêneros separados por vírgula: Nome - F, Nome - M");
        //listaDePessoas = Arrays.asList(scanner.nextLine().toUpperCase().split(","));
        List <String> cadastrados = Arrays.asList(scanner.nextLine().toUpperCase().split(","));
        cadastrados.forEach(p -> listaDePessoas.add(p.trim()));
    }

    private static void listarMulheres() {
        System.out.println("Pessoas do gênero feminino cadastradas: \n");
        List<String> listaMulheres = listaDePessoas.stream()
                .filter(p -> p.endsWith("F"))
                .collect(Collectors.toList());
        listaMulheres.forEach(System.out::println);
        long count = listaMulheres.stream()
                .count();
        System.out.println("Número de mulheres cadastradas: "+count);
    }

    private static void listarHomens() {
        System.out.println("Pessoas do gênero masculino cadastradas: \n");
        List<String> listaHomens = listaDePessoas.stream()
                .filter(p -> p.endsWith("M"))
                .collect(Collectors.toList());
        listaHomens.forEach(System.out::println);
        long count = listaHomens.stream()
                .count();
        System.out.println("Número de homens cadastradas: "+count);
    }
}