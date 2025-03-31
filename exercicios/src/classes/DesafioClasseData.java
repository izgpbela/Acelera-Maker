package classes;

public class DesafioClasseData {
	
	int dia;
	int mes;
	int ano;
	
	String ObterDataFormatada() {
		return String.format("%d/%d/%d", dia, mes, ano);
	}

}
