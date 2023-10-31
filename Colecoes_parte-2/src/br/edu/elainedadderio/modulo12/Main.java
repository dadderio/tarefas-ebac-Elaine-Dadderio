package br.edu.elainedadderio.modulo12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        mostrarMenu();
        cadastrarCliente();
        listarClientes(List<Cliente> clientes);


    }

    private static void mostrarMenu() {
        System.out.println(
                """
                        ===================================
                              CADASTRO DE CLIENTES
                        ===================================
                        Digite 1 para cadastrar
                        Digite 2 para listar todos clientes
                        Digite 3 para listar clientes do sexo F
                        Digite 4 para listar clientes do sexo M
                        Digite 5 para listar clientes do sexo M
                        Digite 0 para sair            
                        """
        );
    }


    private static void cadastrarCliente() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome");
        String nome = scan.next();
        System.out.println("Digite o gênero (F/M)");
        char sexo = scan.next().toUpperCase().charAt(0);
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = new Cliente(nome, sexo);
        clientes.add(cliente);
    }

    private static void listarClientes(List<Cliente> clientes) {
        for (Cliente cl : clientes) {
            System.out.println(cl.getNome() + " " + cl.getSexo());
        }
    }
}
