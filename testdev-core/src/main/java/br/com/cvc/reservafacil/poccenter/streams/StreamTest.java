package br.com.cvc.reservafacil.poccenter.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.comparing;

public class StreamTest {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("felipe");
        palavras.add("karina");
        palavras.add("elaine");


        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.forEach(s -> System.out.println(s));

        palavras.sort(Comparator.comparing(s -> s.length()));

        palavras.sort(Comparator.comparing(String::length));


        Function<String, Integer> funcao = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        palavras.sort(Comparator.comparing(funcao));

        palavras.sort(Comparator.comparing(String::length));

        palavras.forEach(System.out::println);

        palavras.sort(comparing(String::length));
    }

}
