package br.edu.elainedadderio.tarefa.modulo12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestePessoa {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        List<Pessoa> todas = new ArrayList<>();

        do {
            System.out.println("""
                    Digite:
                    1 - cadastrar
                    2 - listar todos cadastrados
                    3 - listar cadastros por gênero
                    4 - sair
                    """);

            int escolha = s.nextInt();

            if (escolha > 0 && escolha < 5) {

                switch (escolha) {
                    case 1:
                        cadastrar(todas);
                        break;
                    case 2:
                        listarTodas(todas);
                        break;
                    case 3:
                        listarPorGenero(todas);
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    //default:
                    //  System.out.println("Inválido");
                }
            } else {
                System.out.println("Tente novamente");
            }

        } while (true);


    }

    private static void cadastrar(List<Pessoa> todas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scanner.next();
        System.out.println("Digite o gênero (F/M): ");
        char sexo;
        sexo = scanner.next().toUpperCase().charAt(0);
        Pessoa pessoa = new Pessoa(nome, sexo);
        todas.add(pessoa);
    }

    private static void listarTodas(List<Pessoa> todas) {

        for (Pessoa pessoa : todas) {
            System.out.println("Nome :" + pessoa.getNome() + " - " + "Gênero: " + pessoa.getGenero());
        }
    }

    private static void listarPorGenero(List<Pessoa> todas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o gênero que deseja listar (F/M): ");
        char dadoGenero = scanner.next().toUpperCase().charAt(0);


        for (Pessoa pessoa : todas) {
            if (pessoa.getGenero() == dadoGenero) {
                System.out.println("Nome :" + pessoa.getNome() + " - " + "Gênero: " + pessoa.getGenero());
            }
        }

    }
}



