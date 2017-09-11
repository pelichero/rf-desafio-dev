package br.com.cvc.reservafacil.poccenter.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class SimpleDomain {

    private String name;
    private Integer number;

    public SimpleDomain(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SimpleDomain{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

public class ExemploDomain{
    public static void main(String[] args) {
        List<SimpleDomain> domains = new ArrayList<>();
        domains.add(new SimpleDomain("Felipe", 12));
        domains.add(new SimpleDomain("Karina", 23));
        domains.add(new SimpleDomain("Elaine", 1));
        domains.add(new SimpleDomain("Jose", 84));

        domains.sort(Comparator.comparing(SimpleDomain::getNumber));

        //domains.forEach(System.out::println);

        /*
        domains.stream()
                .filter(c -> c.getNumber() >= 10)
                //.forEach(c -> System.out.println(c.getName()));
                .map(c -> c.getNumber())
                .forEach(System.out::println);
        */

        /*
        domains.stream()
                .filter(c -> c.getNumber() >= 10)
                //.forEach(c -> System.out.println(c.getName()));
                .map(SimpleDomain::getNumber)
                .forEach(System.out::println);
        */

        System.out.println(domains.stream().filter(c -> c.getNumber() >= 10).mapToInt(SimpleDomain::getNumber).sum());

        //domains.forEach(d -> System.out.println(d.getName()));


        domains.stream().map(SimpleDomain::getName).forEach(d -> System.out.println(" - "+d));
    }
}