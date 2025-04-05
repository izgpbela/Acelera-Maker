package exercoes;

public class ChecadaVsNaoChecada {
	 public static void main(String[] args) {
	        try {
	            geraError1();
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	        try {
	        	geraError2();	
	        }catch (Throwable e) {
	        	System.out.println(e.getMessage());
	        	
	    }

	    // Exceção NÃO checada ou NÃO verificada
	    static void geraError1() throws RuntimeException {
	        throw new RuntimeException("Ocorreu um erro bem legal #01!");
	    }

	    // Exceção checada ou verificada
	    static void geraError2() throws Exception {
	        throw new Exception("Ocorreu um erro bem legal #02!");
	    }
	}
