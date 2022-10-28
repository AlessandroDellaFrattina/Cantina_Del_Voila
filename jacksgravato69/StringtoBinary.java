import java.util.Scanner;

public class StringtoBinary {
	public static void main (String args[]) {
		Scanner in = new Scanner (System.in);
		
		System.out.print("Inserire la stringa > ");
		String s = in.nextLine();
		
		for (int i = 0; i < s.length(); i++) {
			int codepoint = (int)s.charAt(i);
			System.out.print(toBinary(codepoint) + " ");
		}
	}
	public static String toBinary (int value) {
		String bin = "";
		
		//carry
		do {
		bin = value%2 + "" + bin;
		value = value/2;
		} while (value != 0);	
		return bin;									
	}
} 