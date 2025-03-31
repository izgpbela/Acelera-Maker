package fundamentos;

import java.util.Scanner;

public class DesafioDiaSemana {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o nome do dia:");
		
		String dia = entrada.next();
		
		if(dia.equalsIgnoreCase("domingo")) {
			System.out.println(1); 
			} else if("segunda".equals(dia)) {
				System.out.println(2);
			} else if("terça".equals(dia) || "terca".equals(dia)) {
				System.out.println(3);
			}else if("quarta".equals(dia)) {
				System.out.println(4);
			}else if("quinta".equals(dia)) {
				System.out.println(5);
			}else if("sexta".equals(dia)) {
				System.out.println(6);
			}else if("sábado".equals(dia) || "sabado".equals(dia)) {
				System.out.println(7);
			} else {
				System.out.println("Dia Inválido!");
			}
	
		
		entrada.close();
		
	}

}
