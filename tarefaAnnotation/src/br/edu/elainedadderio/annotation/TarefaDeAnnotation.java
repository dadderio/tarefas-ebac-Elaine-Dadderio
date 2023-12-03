package br.edu.elainedadderio.annotation;

@Tabela(nome = "tarefa_da_elaine")
public class TarefaDeAnnotation {

    public void imprimirNomeDaTabela(){
        Class<?> classe = this.getClass();
        System.out.println(classe);
        if(classe.isAnnotationPresent(Tabela.class)){
            Tabela annotation = classe.getAnnotation(Tabela.class);
            System.out.println(annotation);
            String nomeDaTabela = annotation.nome();
            System.out.println("Nome da tabela: "+ nomeDaTabela);
        }else{
            System.out.println("Não há annotation");
        }

    }
}
