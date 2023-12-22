package br.com.elaine.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemplosStreams {
    public static void main(String[] args) {

        List<Pessoa> lista = new Pessoa().populaPessoas();

        lista.stream().forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println("*****************************************************");

        //MAIS COMUM, MAIS UTILIZADO:
        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach((p -> System.out.println(p.getNome())));


        System.out.println("*****************************************************");

        //outra forma de escrever o que está logo acima
        Stream<Pessoa> stream = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .sorted(Comparator.comparing(Pessoa::getNome));

        stream.forEach(p -> System.out.println(p.getNome()));

        System.out.println("*****************************************************");
        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .map(Pessoa::getIdade)
                .forEach(p -> System.out.println(p));

        System.out.println("*****************************************************");

        long count = lista.stream()
                        .filter(p -> p.getNome().startsWith("M"))
                        .count();

        System.out.println(count);

        System.out.println("*****************************************************");
        System.out.println("allMatch para verificar: todos da lista são Mexicanos? resposta: true ou false");

        boolean result = lista.stream()
                .allMatch(pessoa -> pessoa.getNacionalidade().equals("Mexico"));
        System.out.println(result);

        System.out.println("*****************************************************");
        System.out.println("MÉTODO CONVENCIONAL: outra forma que substitui allMatch. Todos da lista são Mexicanos?");

        Boolean re = true;
        for (Pessoa p: lista){
            if(!p.getNacionalidade().equals("Mexico")){
                re=false; //encontrou o primeiro que não é Mexicano, o break já para. Basta um não Mexicano, né?!
                break;
            }
        }
        System.out.println(re);

        System.out.println("*****************************************************");
        System.out.println("Aqui passamos para a variavel listaBrasileiro");
        System.out.println("COLLECT");

        List<Pessoa> listaBrasileiro = lista.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList());
        listaBrasileiro.forEach(System.out::println);

        System.out.println("*****************************************************");
        System.out.println("não atribuiu o resultado a nenhuma variável, mas imprimiu direto a coleção");

        lista.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("*****************************************************");
        Set<Pessoa> set = lista.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("*****************************************************");
        lista.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("*****************************************************");

        ArrayList<Pessoa> arraylist = lista.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toCollection(ArrayList::new));
        arraylist.forEach(System.out::println);
        System.out.println("*****************************************************");

        lista.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(System.out::println);
        System.out.println("*****************************************************");

//        TreeSet<Pessoa> tree = lista.stream()
//                .filter(p -> p.getNacionalidade().equals("Brasil"))
//                .collect(Collectors.toCollection(TreeSet::new));
//        tree.forEach(System.out::println);

        System.out.println("*****************************************************");
//        lista.stream()
//                .filter(p -> p.getNacionalidade().equals("Brasil"))
//                .collect(Collectors.toCollection(TreeSet::new))
//                .forEach(System.out::println);

        System.out.println("*****************************************************");

        Map<Integer, Pessoa> map = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Argentina"))
                .collect(Collectors.toMap(Pessoa::getIdade, Pessoa::new));

        //aqui não pode ter mais de uma pessoa Argentina COM A MESMA IDADE

        map.forEach((k, v) -> System.out.println(k + " / " + v));

        System.out.println("*****************************************************");
        System.out.println("*********** AGRUPAR POR IDADE ********");

        Map<Integer, List<Pessoa>> agrupaPorIdade = lista.stream()
                .collect(Collectors.groupingBy(Pessoa::getIdade));
        agrupaPorIdade.forEach((k, v) -> System.out.println(k + "  /  " + v));

        System.out.println("************** AGRUPAR POR NACIONALIDADE ****************");

        Map<String, List<Pessoa>> agrupaPorNacionalidade = lista.stream()
                .collect(Collectors.groupingBy(Pessoa::getNacionalidade));
        agrupaPorNacionalidade.forEach((a, b)-> System.out.println(a + "  / " +b));

        System.out.println("************** AGRUPA POR NACIONALIDADE E FAZ A SOMA DAS IDADES ****************");
        Map<String, Integer> agrupaPorNacionalidadeSomandoIdades = lista.stream()
                .collect(Collectors.groupingBy(Pessoa::getNacionalidade,
                        Collectors.summingInt(Pessoa::getIdade)));
        agrupaPorNacionalidadeSomandoIdades.forEach((a, b)-> System.out.println(a + "  / " +b));

        System.out.println("************ OPTIONAL ***************");

        lista.stream()
                .max(Comparator.comparing(Pessoa::getIdade))
                .ifPresent(System.out::println);

        System.out.println("************ outra forma de fazer: OPTIONAL ***************");


        Optional<Pessoa> max = lista.stream()
                .max(Comparator.comparing(Pessoa::getIdade));
        if(max.isPresent()){
            System.out.println(max.get());
        }
        
        
    }
}
