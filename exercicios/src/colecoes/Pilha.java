package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
	
	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("O pequeno Prícipe");
		livros.push("Don Quixote");
		livros.push("O Hbbit");
		
		System.out.println(livros.peek());
		System.out.println(livros.element());
		
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
		System.out.println(livros.poll());
	//	System.out.println(livros.pop());  tbm remove
	//	System.out.println(livros.remove());
		
		//livros.isEmpty();
	}

}
