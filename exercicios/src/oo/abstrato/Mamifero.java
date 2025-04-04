package oo.abstrato;

public abstract class Mamifero extends animal {
	public abstract String mamar();
	
	@Override
	public String mover() {
		return "Saindo do lugar";
	}
}