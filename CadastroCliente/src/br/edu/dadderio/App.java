package br.edu.dadderio;

import br.edu.dadderio.dao.ClienteMapDAO;
import br.edu.dadderio.dao.IClienteDAO;
import br.edu.dadderio.domain.Cliente;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {

        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar e 5 para sair", "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);

        while(!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }
             opcao = JOptionPane.showInputDialog(null,"Opção inválida! Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar e 5 para sair", "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)){
            if(isOpcaoSair(opcao)){
                sair();
                } else if(isOpcaoCadastrar(opcao)){
                   String dado = JOptionPane.showInputDialog(null,"Digite os dados do cliente separados por vírgula: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                   cadastrar(dadoValidado(dado));
                    } else if(isConsultar(opcao)){
                        String dados = JOptionPane.showInputDialog(null,"Digite o CPF que deseja consultar (somente números)", "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        consultar(dados);
                    }
            opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar e 5 para sair", "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    private static List<String> dadoValidado (String dado) {

        String[] dadosSeparados = dado.split(",");


        while(dadosSeparados.length != 7){
            String novoDado = JOptionPane.showInputDialog(null,"Digite novamente os dados do cliente separados por vírgula: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            dadosSeparados = novoDado.split(",");
        }

        List<String> todosDados = new ArrayList<>();
        for(String dados: dadosSeparados){
            todosDados.add(dados);
        }

       System.out.println(todosDados);

        while(todosDados.get(1).trim().length() != 11) {
            String opcaoCpf = JOptionPane.showInputDialog(null, "Digite novamente o CPF com 11 dígitos (somente números)", "Cadastro de CPF", JOptionPane.INFORMATION_MESSAGE);
            String opcaoCpfTrim = opcaoCpf.trim();
            if (opcaoCpfTrim.length() == 11) {
                todosDados.remove(todosDados.get(1));
                todosDados.add(1, opcaoCpfTrim);
            }
        }

        for (int i : new int[]{0, 2, 3, 4, 5, 6}) {
            if (todosDados.get(i).isBlank()) {
                if (i == 0 || i == 3 || i == 5 || i == 6) {
                    todosDados.set(i, "null");
                } else {
                    todosDados.set(i, "0");
                }
            }
        }


        System.out.println(todosDados);
        return todosDados;
    }

     private static void cadastrar(List<String> dadoValidado) {

            Cliente cliente = new Cliente(dadoValidado.get(0), dadoValidado.get(1), dadoValidado.get(2), dadoValidado.get(3), dadoValidado.get(4), dadoValidado.get(5), dadoValidado.get(6));
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
            if (isCadastrado) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(iClienteDAO.buscarTodos());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
        }

    private static void consultar(String dado) {
        String nCpf = dado.trim();

        /*while (nCpf.length() != 11) {*/
            if(nCpf.length() == 11){
                Cliente cliente = iClienteDAO.consultar(Long.parseLong(nCpf));
                JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Consulta", JOptionPane.INFORMATION_MESSAGE);
            }/*else {
                JOptionPane.showMessageDialog(null, "Digite um CPF com 11 dígitos", "Consulta", JOptionPane.INFORMATION_MESSAGE);
                nCpf = JOptionPane.showInputDialog(null, "Digite novamente o CPF com 11 dígitos (somente números)", "Consultar por CPF", JOptionPane.INFORMATION_MESSAGE);
            }*/

        //}
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastrar(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isConsultar(String opcao) {
        if("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null,"Até logo!", "Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao)
                || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }


}
