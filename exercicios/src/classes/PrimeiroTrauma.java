package classes;

public class PrimeiroTrauma {
	
	 int a = 3;       // Variável de instância (não estática)
	 static int b = 4; // Variável de classe (estática)
	
	public static void main(String[] args) {
	    // Criando uma instância da classe
	    PrimeiroTrauma p = new PrimeiroTrauma();
	    System.out.println(p.a); // Acessando variável de instância 'a'
	    
	    System.out.println(b);   // Acessando variável estática 'b' diretamente
	}

}
