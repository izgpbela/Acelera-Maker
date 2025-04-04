package oo.abstrato;

public class cachorro extends Mamifero {
		@Override
		public String mover() {
			return "Usando patas";
		}
		
		@Override
		public final String mamar() {
			return "Usando leite";
		}
}
