import java.util.Scanner;

public class Convertitore1610 {
	public static int pow (int base, int exp) {
		int ris = 1;
		for (int i = 0; i < exp; i++) {
			ris *= base;
		}
		return ris;
	}
	public static void main (String args[]) {
		Scanner in = new Scanner (System.in);
		
		System.out.print("Inserire numero da convertitre > ");
		String s = in.nextLine();
		int ris = 0;
		
		
		for (int i = s.length() - 1, j= 0; i >= 0; i--, j++) {
			int num; 
			if (s.charAt(i) == 'A') {
				
				num=10;
				
			}
			else if (s.charAt(i) == 'B') {
				
				num=11;
				
			}
			else if (s.charAt(i) == 'C') {
				
				num=12;
				
			}
			else if (s.charAt(i) == 'D') {
				
				num=13;
				
			}
			else if (s.charAt(i) == 'E') {
				
				num=14;
				
			}
			else if (s.charAt(i) == 'F') {
				
				num=15;
				
			} 
			else {
					num = s.charAt(i)-'0';
			}
			ris = ris + pow(16, j) * num;
		} 
		
			System.out.print("Il numero in base 16 e' > " + ris);
		
	}
}	