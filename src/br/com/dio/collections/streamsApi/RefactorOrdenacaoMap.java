package br.com.dio.collections.streamsApi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/*Dadas as seguintes informações de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);

id = 1 - Contato = nome: simba, número: 2222;
id = 4 - Contato = nome: Cami, número; 5555;
id = 3 - Contato = nome: Jon número: 1111;*/
public class RefactorOrdenacaoMap {



    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{

            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(agenda);
        for(Map.Entry<Integer, Contato> entries: agenda.entrySet()){
            System.out.println(entries.getKey() + " - " + entries.getValue().getNome());
        }


        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{

            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(agenda1);
        for(Map.Entry<Integer, Contato> entries: agenda1.entrySet()){
            System.out.println(entries.getKey() + " - " + entries.getValue().getNome());
        }


        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for(Map.Entry<Integer, Contato> entries: agenda2.entrySet()){
            System.out.println(entries.getKey() + " - " + entries.getValue().getNome());
        }


        System.out.println("--\tOrdem número telefone\t--");
        //Class Anonima:
      /*  Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>(){
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });*/
        //Function Interface:
       /* Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/
        //Lambda:
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getNumero()));
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entries: set){
            System.out.println(entries.getKey() + " - " + entries.getValue().getNumero() +
                    " : " + entries.getValue().getNome());
        }

        System.out.println("--\tOrdem nome contato\t--");
        //Lambda:
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>( Comparator.comparing(
                cont -> cont.getValue().getNome()));
        set1.addAll(agenda.entrySet());
        //Imprimindo com foreach:
        set1.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getNome()));
    }
}


/*class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}*/

/*class ComapratorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}*/
