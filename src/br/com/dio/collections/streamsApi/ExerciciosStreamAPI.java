package br.com.dio.collections.streamsApi;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class ExerciciosStreamAPI {

    public static void main(String[] args) {

        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4","1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de string: ");
        numerosAleatorios.forEach(System.out::println);//Usando reference method


        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
        numerosAleatorios.stream()
                .limit(5)//limit()pra pegar os 5 primeiros números;
                .collect(Collectors.toSet())//pegue os 5 primeiros numeros e coloque em um Set;
                .forEach(System.out::println);//Lembrando que um Set, não aceita

        System.out.println("Transforme essa lista de String em uma lista de números inteiros: ");
        List<Integer>  numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(numerosAleatoriosInteger);


        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");

        //SEM USAR REFERENCE METHOD
       /* List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>(){
                    @Override
                    public boolean test(Integer i){
                        if (i % 2 == 0 &&  i >2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);*/


        //USANDO REFERENCE METHOD
            List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter( i -> (i % 2 == 0 &&  i >2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);



      /*  System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>(){
                    @Override
                    public int applyAsInt(String s){
                        return Integer.parseInt(s);
                 .average()//average() retorna a média;
                .ifPresent(new DoubleConsumer(){
                    @Override
                    public void accept(double v){
                        System.out.println(v);
                    }
                });
       */


        //MESMO CÓDIGO, SÓ QUE USANDO REFERENCE METHOD:
        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()//average() retorna a média;
                .ifPresent(System.out::println);


      /*  System.out.println("Remova os valores ímpares: ");//stream não modifica nossa fonte, então voltaremos com a list de Integer...
        numerosAleatoriosInteger.removeIf(new Predicate<Integer>(){
            @Override
            public boolean test(Integer i) {
                if(i % 2 != 0) return true;
                return false;
            }
        });
        System.out.println(numerosAleatoriosInteger);*/


        //USANDO REFERENCE METHOD:
        System.out.println("Remova os valores ímpares: ");//stream não modifica nossa fonte, então voltaremos com a list de Integer...
        numerosAleatoriosInteger.removeIf( i -> i % 2 != 0);
        System.out.println(numerosAleatoriosInteger);

    }
}
