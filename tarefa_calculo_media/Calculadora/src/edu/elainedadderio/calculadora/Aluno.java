package edu.elainedadderio.calculadora;

/**
 * @author Elaine
 */


public class Aluno {

    private int nota1 = 10;
    private int nota2 = 8;
    private int nota3 = 6;
    private int nota4 = 4;

    public void calcularMedia(){
        int media = (nota1 + nota2 + nota3 + nota4)/4;
        System.out.println("A média das notas "+nota1+", "+nota2+", "+nota3+" e "+nota4+" é "+media);
    }
}
