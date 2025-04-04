package oo.abstrato;

public class TesteAbstrato {
	public static void main(String[] args) {
		cachorro a = new cachorro();
		System.out.println(a.mover());
		System.out.println(a.mamar());
		System.out.println(a.respirar());
	}
}
