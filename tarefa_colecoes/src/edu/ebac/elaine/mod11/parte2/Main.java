package edu.ebac.elaine.mod11.parte2;

import java.util.*;


/**
 * @author elainef
 */
public class Main {
    public static void main(String[] args) {


        System.out.println("*******************************************************************");
        System.out.println("Digite nome e respectivo gênero das pessoas, conforme modelo baixo:");
        System.out.println("Nome - F, Nome - M");
        System.out.println("*******************************************************************");

        List <String> feminino = new ArrayList<>();
        List <String> masculino = new ArrayList<>();

        List <String> pessoasF = new ArrayList<>();
        List <String> pessoasM = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String leitura = scanner.nextLine().toUpperCase();

//SEPARANDO EM GRUPOS - FEMININO E MASCULINO

        String [] pessoas = leitura.split(", ");

        for(String pessoa : pessoas){
            if(pessoa.endsWith("- F|-F")||pessoa.endsWith("-F")){
                feminino.add(pessoa);
            }else if (pessoa.endsWith("- M")||pessoa.endsWith("-M")){
                masculino.add(pessoa);
            }else{
                System.out.println("Verifique a digitação do gênero");
            }
        }

//RESOLVENDO O GENERO FEMININO - RETIRANDO "-F / - F":

        String  soMulheres = "";
        for (String fem : feminino){
           soMulheres += fem;
        }

        String []femin = soMulheres.split("- F|-F");

        for(String elemento : femin){
            pessoasF.add(elemento);
        }

        Collections.sort(pessoasF);


        System.out.println("***** Grupo de pessoas do gênero Feminino *****");
        for(String f : pessoasF) {
            System.out.println("- "+f);
        }

//RESOLVENDO O GENERO MASCULINO - RETIRANDO "-M / - M":

        String  soHomens = "";
        for (String hom : masculino){
            soHomens += hom;
        }

        String []home = soHomens.split("- M|-M");

        for(String elementoh : home){
            pessoasM.add(elementoh);
        }

        Collections.sort(pessoasM);

        System.out.println("***** Grupo de pessoas do gênero Masculino *****");
        for(String m : pessoasM) {
            System.out.println("- "+m);
        }
    }
}