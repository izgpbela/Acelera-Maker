package heranca.desafio;

public class CarroTeste {
	
	public static void main(String[] args) {
		
		Civic c1 = new Civic();
		
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();
		System.out.println(c1);
		
		Ferrari c2 = new Ferrari();
		
		c2.acelerar();
		System.out.println(c1);
		
		c2.acelerar();
		System.out.println(c1);
		
		c2.acelerar();
		System.out.println(c1);
	}

}
