package classes;

public class DesafioClassDataTest {
	public static void main(String[] args) {
		
		DesafioClasseData d1 = new DesafioClasseData();
		
		var d2 = new DesafioClasseData(31, 12, 2020);
		
		@SuppressWarnings("unused")
		String dataFormatada1 = d1.ObterDataFormatada();
		
		System.out.println(d1.ObterDataFormatada());
		System.out.println(d2.ObterDataFormatada());
		
		d1.imprimirDataFormatada();
		d2.imprimirDataFormatada();
	}

}
