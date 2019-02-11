package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenarStrings {

	
	public static void main(String[] args) {
		
		//Arrays.asList("", "", );
		List<String> palavras = new ArrayList<>();
		
		palavras.add("bb");
		palavras.add("aaa");
		palavras.add("c");
		
		Collections.sort(palavras);
		
		System.out.println("Collections.sort(palavras) > " + palavras);
		
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();

		palavras.sort(comparador);
		
		Collections.sort(palavras, comparador);
		
		System.out.println("Collections.sort(palavras, comparador) > " + palavras);
		
		palavras.add("ddddd");
		
		palavras.sort(comparador);
		
		System.out.println("palavras.sort(comparador) > " + palavras);
		
		Consumer<String> consumidor = new ConsumidorDeString();
		
		palavras.forEach(consumidor);
		
		palavras.forEach(s -> {
			System.out.println("palavras.forEach(s ->" + s);
		});
		
		/*palavras.forEach(s -> System.out.println("palavras.forEach(s ->" + s));*/
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();


	}
}
