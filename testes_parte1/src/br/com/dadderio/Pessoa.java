package br.com.dadderio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Elaine D'Adderio
 */

public class Pessoa {

    private List <String> listaDePessoas = new ArrayList<>();

    /*public void mostrarMenu() {

        do {
            System.out.println(
                    """
                            \n
                            =============================
                            DIGITE
                            =============================
                            1 - cadastrar pessoas
                                                    
                            2 - listar gênero feminino
                                                    
                            3 - sair
                                                    
                            =============================
                                                """
            );

            Scanner leitura = new Scanner(System.in);
            int opcaoEscolhida = leitura.nextInt();

            if (opcaoEscolhida > 0 && opcaoEscolhida < 5) {
                switch (opcaoEscolhida) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        listarMulheres();
                        break;

                    case 3:
                        System.out.println("Saindo...");
                        System.exit(0);
                }
            } else {
                System.out.println("Tente novamente");
            }
        } while (true);
    }
*/


//   public void cadastrar() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Digite as pessoas e seus gêneros separados por vírgula: Nome - F, Nome - M");
//        //listaDePessoas = Arrays.asList(scanner.nextLine().toUpperCase().split(","));
//        List <String> cadastrados = Arrays.asList(scanner.nextLine().toUpperCase().split(","));
//        cadastrados.forEach(p -> listaDePessoas.add(p.trim()));
//    }


    public void setListaDePessoas(List<String> listaDePessoas) {
        this.listaDePessoas = listaDePessoas;
    }

    public List<String> listarMulheres() {
        List<String> listaMulheres = listaDePessoas.stream()
                .filter(p -> p.endsWith("F"))
                .collect(Collectors.toList());
        return listaMulheres;
    }


}