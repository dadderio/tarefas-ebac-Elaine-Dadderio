import java.util.Scanner;

/**
 * @author Elaine 
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Aluno aluno = new Aluno();

        System.out.println("**********************************");
        System.out.println("VERIFIQUE SE VOCÊ FOI APROVADO");
        System.out.println("**********************************");

        for (int i=1; i<=4; i++){
            System.out.println("Informe a nota do "+ i+"º trimestre");
            int nota = scanner.nextInt();
            aluno.registrarNotas(nota);
        }
        aluno.listarNotas();
        aluno.calcularMedia();
    }
}