import java.util.Scanner;

public class OrariPullmanOr {
	public static void main (String args[]) {
		Scanner in = new Scanner (System.in);
		
		System.out.print("Inserire linea > ");
		String lin = in.nextLine();
		System.out.print("Inserire ora > ");
		int ora = in.nextInt();
		System.out.print("Inserire minuti > ");
		int min = in.nextInt();
			
		if (ora == 12 || ora == 13) {
		if (lin.equals("C") || lin.equals("c")) {		//MODIFICARE CON SWITCH
			if (min >= 60) {
				System.out.println("Un'ora e' formata solo da 60 minuti, pirla :D");
			}
			else {
				if (ora == 12) { //orari con ora corrispondente a 12
					if (min < 12) {
							System.out.println("Il prossimo pullman e' alle ore > 12:12");
					}
					else if (min < 32 || min == 12) {
							System.out.println("Il prossimo pullman e' alle ore > 12:32");
					}
					else if (min < 52 || min == 32) {
							System.out.println("Il prossimo pullman e' alle ore > 12:52");
					}
					else if (min > 52 || min == 52) {
							System.out.println("Il prossimo pullman e' alle ore > 13:12");
					}
				}	
				if (ora == 13) { //orari con ora corrispondente a 13
					if (min < 12) {
							System.out.println("Il prossimo pullman e' alle ore > 13:12");
					}
					else if (min < 32 || min == 12) {
							System.out.println("Il prossimo pullman e' alle ore > 13:32");
					}
					else if (min < 52 || min == 32) {
							System.out.println("Il prossimo pullman e' alle ore > 13:52");
					}
				}
			}	
		}	
		if (lin.equals("E") || lin.equals("e")) {		
			if (min >= 60) {
				System.out.println("Un'ora e' formata solo da 60 minuti, pirla :D");
			}
			else {
				if (ora == 12) { //orari con ora corrispondente a 12
					if (min < 13) {
							System.out.println("Il prossimo pullman e' alle ore > 12:13 ");
					}
					else if (min < 25 || min == 13) {
							System.out.println("Il prossimo pullman e' alle ore > 12:25");
					}
					else if (min < 37 || min == 25) {
							System.out.println("Il prossimo pullman e' alle ore > 12:37");
					}
					else if (min < 49 || min == 37) {
							System.out.println("Il prossimo pullman e' alle ore > 12:49");
					}
					else if (min > 49 || min == 49) {
							System.out.println("Il prossimo pullman e' alle ore > 13:01");
					}
				}	
				if (ora == 13) { //orari con ora corrispondente a 13
					if (min < 1) {
						System.out.println("Il prossimo pullman e' alle ore > 13:01");
					}
					else if (min < 13 || min == 1) {
						System.out.println("Il prossimo pullman e' alle ore > 13:13");
					}
					else if (min < 25 || min == 13) {
						System.out.println("Il prossimo pullman e' alle ore > 13:25");
					}
					else if (min < 37 || min == 25) {
						System.out.println("Il prossimo pullman e' alle ore > 13:37");
					}
					else if (min < 49 || min == 37) {
						System.out.println("Il prossimo pullman e' alle ore > 13:49");
					}
				}
			}	
		}
		}
		else { 
			System.out.println("Il pirla dello sviluppatore non ha messo tutti gli orari :D");	
			}
	}
}
	