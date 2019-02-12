package br.com.alura.java8.datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		
		//Data atual
		LocalDate hoje = LocalDate.now();
		System.out.println("Data atual - > "+hoje);
		
		LocalDate meuNiver = LocalDate.of(1988, Month.JULY, 18);
		
		System.out.println("Minha idade -> " + (hoje.getYear() - meuNiver.getYear()));
		
		Period periodo = Period.between(hoje, meuNiver);
		System.out.println("Pediodo usando Between - > " + periodo);
		System.out.println("-- Ano do periodo -> " + periodo.getYears());
		System.out.println("-- Mes do periodo -> " + periodo.getMonths());
		System.out.println("-- Dia do periodo -> " + periodo.getDays());
		
		
		System.out.println("saber datas anteriores");
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		System.out.println("saber datas aposteriores");
		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
		System.out.println("data formatada");
		LocalDate niverDepoisQuatroAnos = meuNiver.plusYears(4);

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = niverDepoisQuatroAnos.format(formatador);
		System.out.println(valorFormatado);
		
	}
}
