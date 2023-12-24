import br.com.elaine.streams.Pessoa;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<String> streamList = List.of("Renato", "Ana", "Mariana").stream();
        //System.out.println(streamList);

        //Set<String> set = Set.of("Renato", "Ana", "Mariana");
        //Stream<String> streamSet = set.stream();
        Stream<String> streamSet = Set.of("Renato", "Ana", "Mariana").stream();
        //System.out.println(streamSet);

        Map<String, String> map = Map.of("Renato", "Mariana");
        Stream<String> chaves = map.keySet().stream();
        Stream<String> valores = map.values().stream();

        Stream<String> streamSTS = Stream.of("String", "asds");

        List<Pessoa> pessoas = new Pessoa().populaPessoas();

        Predicate<Pessoa> predi1 = new Predicate<Pessoa>() {
            @Override
            public boolean test(Pessoa pessoa) {
                return pessoa.getNacionalidade().equals("Brasil");
            }
        };
        Stream stream2 = pessoas.stream().filter(predi1);
        stream2.forEach(System.out::println);

        Predicate<Pessoa> predi = pessoa -> pessoa.getNacionalidade().equals("Brasil");
        Stream stream1 = pessoas.stream().filter(predi);
        stream1.forEach(System.out::println);

        Stream<Integer> stream3 = pessoas.stream()
                .filter(predi)
                .map(Pessoa::getIdade);


        stream3.forEach(System.out::println);

        List<String> nomesComMaisDe5Letras = pessoas.stream()
                .filter(pessoa -> pessoa.getNome().length() > 5) // Filtrar nomes com mais de 5 letras
                .map(Pessoa::getNome) // Mapear para os nomes das pessoas
                .collect(Collectors.toList()); // Coletar os nomes em uma lista

        // Imprimir os nomes que atendem ao critério
        System.out.println("Nomes com mais de 5 letras: " + nomesComMaisDe5Letras);

        // Você também pode adicionar mais operações intermediárias aqui antes do terminal
    }
    }
