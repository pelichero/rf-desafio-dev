package br.com.cvc.reservafacil.poccenter.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TestandoInterface {

    public static void main(String[] args) {
        //Testando teste = () -> System.out.println("asd");
        //teste.run();


        List<SimpleDomain> lista = indexesCreation();

        int soma = lista.stream()
                .filter(s -> s.getNumber() < 10)
                .mapToInt(s -> s.getNumber())
                .sum();

        Map<String, Integer> testemap = lista.stream()
                .collect(Collectors.toMap(SimpleDomain::getName, SimpleDomain::getNumber));

        System.out.println(testemap);

        String result = lista.stream()
                .mapToInt(s -> s.getNumber())
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));

        System.out.println(" T " + result);

//        int reduce = lista.stream()
//                .mapToInt(s -> s.getNumber())
//                .reduce(0, (x1, x2) -> x1 + x2);
//
//        System.out.println(reduce);
//
//
//        System.out.println(soma);

    }

    private static List<SimpleDomain> indexesCreation(){
        return IntStream.range(0, 20)
                .mapToObj(i -> new SimpleDomain(i + " - name", i))
                .collect(toList());

    }
}
