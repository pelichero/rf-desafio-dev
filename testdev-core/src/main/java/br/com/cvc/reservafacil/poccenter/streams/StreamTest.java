package br.com.cvc.reservafacil.poccenter.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("felipe");
        palavras.add("karina");
        palavras.add("elaine");


        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.forEach(s -> System.out.println(s));
    }

}
