import java.util.Scanner;

public class ConvertitoreBinario {
	public static void main (String args[]) {
		Scanner in = new Scanner (System.in);
		System.out.print("Inserire il numero da convertire > ");
		int num = in.nextInt();
		System.out.print("Inserire la base > ");
		int base = in.nextInt();
		String s = "";
		
		
		while (num != 0) {
			
			if (num%base == 10) {
				
				s = 'A' + s;
				
			}
			else if (num%base == 11) {
				
				s = 'B' + s;
				
			}
			else if (num%base == 12) {
				
				s = 'C' + s;
				
			}
			else if (num%base == 13) {
				
				s = 'D' + s;
				
			}
			else if (num%base == 14) {
				
				s = 'E' + s;
				
			}
			else if (num%base == 15) {
				
				s = 'F' + s;
				
			}
			else {
			s = num%base + s;
			}
			num = num/base;
		
			
			
		} 
		
		System.out.println("Il tuo numero convertito e' > " + s);
		
	}
}