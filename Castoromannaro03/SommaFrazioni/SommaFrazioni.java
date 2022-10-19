import prog.utili.Frazione;
import java.util.Scanner;

public class SommaFrazioni{
	
	public static void main(String[] args){
		
		//istanzio il canale di ingresso, di uscita e prendo in input il numeratore
		System.out.println("Inserisci il numeratore della prima frazione");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		//Prendo in input il denominatore
		System.out.println("Inserisci il denominatore della prima frazione");
		int den = in.nextInt();
		
		//Istanzio la prima frazione e gli attribuisco i valori inseriti dall'utente
		Frazione f1 = new Frazione(num,den);
		
		
		//prendo in input il numeratore per la seconda frazione
		System.out.println("Inserisci il numeratore della seconda frazione");
		num = in.nextInt();
		
		//Prendo in input il denominatore per la seconda frazione
		System.out.println("Inserisci il denominatore della seconda frazione");
		den = in.nextInt();
		
		//Istanzio la seconda frazione e gli attribuisco i valori inseriti dall'utente
		Frazione f2 = new Frazione(num,den);
		
		//Effettuo la somma tra le frazioni
		Frazione somma = f1.piu(f2);
		
		System.out.println("Il risultato e' " + somma);
		
		//System.out.println(num);
		
		
	}
}

/*
istanziare i due canali di comunicazione	
leggere num/dem per le due fraioni
creare la due frazioni
eseguire la somma dei due oggetti di tipo Frazione
stampare il risultato
*/