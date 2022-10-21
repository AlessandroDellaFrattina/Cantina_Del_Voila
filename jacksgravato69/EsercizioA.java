import java.util.Scanner;

public class EsercizioA {
	public static void main (String args[]) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Inserire primo numero > ");
		int num1 = in.nextInt();
		
		System.out.print("Inserire secondo numero > ");
		int num2 = in.nextInt();
		
		int som = num1 + num2;
		System.out.println("La somma e' > " + som);
		
		int dif = num1 - num2;
		System.out.println("La differenza e' > " + dif);
		
		int prod = num1 * num2;
		System.out.println("Il prodotto e' > " + prod);
		
		int quoz = num1/num2;
		System.out.println("Il quoziente e' > " + quoz);
		
	}
}