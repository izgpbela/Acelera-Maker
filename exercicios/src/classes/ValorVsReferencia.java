package classes;

public class ValorVsReferencia {
	public static void main(String[] args) {
		
		double a =2;
		double b =a; // atribui por valor {tipo primitivo}
		
		a++;
		b--;
		
		System.out.println(a + " " + b);
		
		DesafioClasseData d1 = new DesafioClasseData(1, 6, 2022);
		DesafioClasseData d2 = d1; // atribuição por referência (Objeto)
		
		d1.dia = 31;
		d2.mes = 12;
		
		d1.ano = 2025;
		
		System.out.println(d1.ObterDataFormatada());
		System.out.println(d2.ObterDataFormatada());
		
		voltarDataParaValorPadrao(d1);
		
		int c = 5;
		alterarPrimitivo(c);
		System.out.println(c);
	}
	
	static void voltarDataParaValorPadrao(DesafioClasseData d) {
		d.dia = 1;
		d.mes = 1;
		d.ano = 1970;
	}
	
	static void alterarPrimitivo(int c) {
		c++;
	}

}
