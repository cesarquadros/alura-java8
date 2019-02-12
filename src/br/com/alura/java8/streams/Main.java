package br.com.alura.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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
		
		//Retorna apenas um elemento Optional<Curso>
		Optional<Curso> optional = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		
		/*nesse caso poderia ser lancada uma exception
		Curso curso = optional.get();*/
		
		//Nesse caso, evita o exception
		Curso curso = optional.orElse(null);
		
		System.out.println("================== findAny/optional  ======================");
		
		optional.ifPresent(c -> System.out.println(c.getNome()));
		
		/* apenas em uma linha
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny()
		   .ifPresent(c -> System.out.println(c.getNome()));
		 */
		
		// .collect(Collectors.toList()); usado para extrair a lista de uma stream
		cursos = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		
		// extrair o resultado da pesquisa para um map, o primeiro atributo é a chave, o segundo é o valor
		Map mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		// parallelStream() para criar threads nas buscas.
	}
}
