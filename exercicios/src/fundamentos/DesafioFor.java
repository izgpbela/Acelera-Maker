package fundamentos;

public class DesafioFor {
	public static void main(String[] args) {
		
		/*String valor = "#";
		for (int i = 1; i <= 5; i++) {
			System.out.println(valor);
			valor += "#";*/
		
//Desafio e fazer esse programa de cima sem usar valor numéros para controlar o laço		
		/*String valor = "#";
		String limite = "######";  // 6 caracteres como limite
		while (!valor.equals(limite)) {
		    System.out.println(valor);
		    valor += "#";*/
		
	// de outra forma
		for(String v = "#"; !v.equals("######"); v += "#") {
			System.out.println(v);
		   
		}
	}

}
