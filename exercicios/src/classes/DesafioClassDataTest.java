package classes;

public class DesafioClassDataTest {
	public static void main(String[] args) {
		
		DesafioClasseData d1 = new DesafioClasseData();
		d1.dia = 7;
		d1.mes = 11;
		d1.ano = 2025;
		
		
		var d2 = new DesafioClasseData();
		d2.dia = 31;
		d2.mes =12;
		d2.ano = 2020;
		
		System.out.println(d1.ObterDataFormatada());
		System.out.println(d2.ObterDataFormatada());
	}

}
