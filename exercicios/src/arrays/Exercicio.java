package arrays;

import java.util.Arrays;

public class Exercicio {
	
	private static double totalAlunoB;

	public static void main(String[] args) {
		
		double[] notasAlunoA = new double[4];
		System.out.println(Arrays.toString(notasAlunoA));
		
		notasAlunoA[0] = 7.9;
		notasAlunoA[1] = 8;
		notasAlunoA[2] = 6.7;
		notasAlunoA[3] = 9.7;
		
		System.out.println(Arrays.toString(notasAlunoA));
		
		double total = 0;
		for(int i = 0; i < notasAlunoA.length; i++) {
			total += notasAlunoA[i];
			
		}
		System.out.println(total / 3);
		
		double[] notasAlunoB = { 6.9, 8.9, 5.5, 10};
		for (int i = 0; i < notasAlunoB.length; i++) {
			totalAlunoB += notasAlunoB[i];
		}
		
	    System.out.println(totalAlunoB / notasAlunoB.length);

	}

}
