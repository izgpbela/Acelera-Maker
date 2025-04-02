package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
	
	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<>();
		
		//offer e add -> adicionar elementos a fila
		// Diferença é o comportamento quando a fila está cheia!
		fila.add("Ana"); // retorna false
		fila.offer("Bia");// lança uma exceção
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		// peek e element -> obter próximo elemento
		// elementos na fila (sem remover)
		//Diferença é o comportamento ocorre
		// quando a fila está vazia!
		System.out.println(fila.peek()); // retorna null
		System.out.println(fila.peek());
		System.out.println(fila.element()); //lança uma exceção
		System.out.println(fila.element());
		
		//fila.size()
		//fila.clear()
		//fila.isEmpty()
		
		
		// poll e remove -> obter o próximo elemento
		// da fila e reove
		
		//Diferença é o comportamento ocorre
		//quando a fila está vazia!
		System.out.println(fila.poll());// retorna null
		System.out.println(fila.remove());// lança uma exceção
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.remove());
	
	}

}
