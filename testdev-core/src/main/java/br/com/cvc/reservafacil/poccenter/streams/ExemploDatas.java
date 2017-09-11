package br.com.cvc.reservafacil.poccenter.streams;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class ExemploDatas {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadas = LocalDate.of(2016, Month.JUNE, 5);
        int anos = olimpiadas.getYear() - hoje.getYear();

        System.out.println(anos);

        Period period = Period.between(olimpiadas, hoje);
        System.out.println(period.getDays());

    }

}
