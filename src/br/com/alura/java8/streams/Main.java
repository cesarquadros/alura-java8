package br.com.alura.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("==================Filter======================");
		
		Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
		
		streamDeCurso.forEach(c -> System.out.println(c.getNome()));
		
		/*modo alternativo para fazer sem instanciar a variavel streamDeCurso
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.forEach(c -> System.out.println(c.getNome()));*/
		System.out.println("==================Filter imprimindo a quantidade de alunos ======================");
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(c -> c.getAlunos())
		   .forEach(x -> System.out.println(x));
		
		/* Alternativa usando method references
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(Curso::getAlunos())
		   .forEach(System.out::println);*/
		
		System.out.println("================== Stream primitivo(INT) ======================");

		IntStream stream = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos);
		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		System.out.println(soma);
	}
}
