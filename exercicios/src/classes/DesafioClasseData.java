package classes;

public class DesafioClasseData {
	
	int dia;
	int mes;
	int ano;
	
	DesafioClasseData(){
		dia = 1;
		mes = 1;
		ano = 1970;
	}
	DesafioClasseData(int diaInicial, int mesInicial, int anoInicial){
		dia = diaInicial;
		mes = mesInicial;
		ano = anoInicial;
		
	}
	
	String ObterDataFormatada() {
		return String.format("%d/%d/%d", dia, mes, ano);
	}
	void imprimirDataFormatada() {
		System.out.println(ObterDataFormatada());
	}

}
