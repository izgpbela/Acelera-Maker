package fundamentos.operadores;

public class logico {
	public static void main(String[] args) {
		
		boolean condicao1 = true;
		boolean condicao2 = 3 > 7;
		
		System.out.print(condicao1 && condicao2);
		System.out.print(condicao1 || condicao2);
		System.out.print(condicao1 ^ condicao2);
		System.out.print(condicao1);
		System.out.print(condicao2);
		
		System.out.print("Tabela verdade E {AND}");
		System.out.print(true && true);
		System.out.print(true && false);
		//System.out.print(false && true);
		//System.out.print(false && false);
		
		System.out.print("\nTabela verdade OU {OR}");
		//System.out.print(true || true);
		//System.out.print(true || false);
		System.out.print(false || true);
		System.out.print(false || false);
		
		System.out.print("\nTabela verdade OU Exclusivo {XOR}");
		System.out.print(true ^ true);
		System.out.print(true ^ false);
		System.out.print(false ^ true);
		System.out.print(false ^ false);
		
		System.out.print("Tabela verdade NOT");
		System.out.print(!true);
		System.out.print(!false);
	}
}
