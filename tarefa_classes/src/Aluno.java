import java.util.ArrayList;
import java.util.List;

/**
 * @author Elaine
 */

public class Aluno {

    private String nomeAluno;
    private List<Float> notas = new ArrayList<>();
    private float totalNota = 0;
    private float media = 0;


    public void registrarNotas(float nota){
        notas.add(nota);
    }

    public void listarNotas(){
        System.out.println("Suas notas foram: "+  notas);
    }

    public void calcularMedia(){
        for(int i=0; i< notas.size(); i++){
            totalNota = totalNota + notas.get(i);
        }
        media = totalNota/notas.size();
        System.out.println("Sua média anual foi: "+ media);
        boletim(media);
    }

    public void boletim(float media){
        if(media > 6){
            System.out.println("Você está aprovado");
        }else if(media > 4){
            System.out.println("Você está em recuperação");
            }else{
                System.out.println("Você está reprovado");
            }
   }
}
