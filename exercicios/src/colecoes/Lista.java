package colecoes;

import java.util.ArrayList;

public class Lista {
	
	public static void main(String[] args) {
		ArrayList<Usuario> Lista = new ArrayList<>();
		
		Usuario u1 = new Usuario("Ana");
		
		Lista.add(u1);
		Lista.add(new Usuario("Carlos"));
		Lista.add(new Usuario("Lia"));
		Lista.add(new Usuario("Bia"));
		Lista.add(new Usuario("Manu"));
		
		System.out.println(Lista.get(3));// acessar pelo índice
		
		System.out.println(Lista.remove(new Usuario("Manu")));
		
		for(Usuario u: Lista) {
			System.out.println(u);
		}
	}

}
