import java.util.Scanner;


//faccio inserire mantissa, segno ed esponente
//calcolo l'esponente sottraendo 127
//calcolo la mantissa e aggiungo 1.0
public class toDec{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		//faccio inserire all'utente i dati
		System.out.println("Inserisci il bit corrispondente al segno");
		String segno = in.nextLine();
		if(segno.equals("1"))
			segno = "-";
		else
			segno =  "+";
		
		System.out.println("Inserisci gli 8 bit corrispondenti all'esponente");
		String esponente = in.nextLine();
		if(esponente.length() > 8){
			System.out.println("Il numero inserito per l'esponenteha un valore non valido");
			//i topi non avevano nipoti
		}
		
		System.out.println("Inserisci i bit corrispondenti alla mantissa");
		String mantissa = in.nextLine();
		mantissa = 1 + mantissa;
		
		//lavoro sull'esponente
		int valoreEspontente = 0;
		int cifra = 0;
		//parto dalla fine della stringa, cioè dal bit meno significativo e mi fermo dopo 8 cicli
		for(int i=7; i>=0; i--){
			cifra = Character.getNumericValue(esponente.charAt(i));
			valoreEspontente += cifra * Math.pow(2,7-i);
		}

		valoreEspontente = valoreEspontente-127;
		
		//lavoro sulla mantissa
		float valoreMantissa = 0;
		for(int i=0; i<mantissa.length(); i++){
			//calcolo la parte intera
			if(i<=valoreEspontente){
				cifra = Character.getNumericValue(mantissa.charAt(i));
				valoreMantissa += cifra * Math.pow(2,valoreEspontente-i);
			}
			//calcolo la parte decimale
			else{
				cifra = Character.getNumericValue(mantissa.charAt(i));
				valoreMantissa += cifra / Math.pow(2,i-valoreEspontente);
			}
			
			//System.out.println("valore mantissa> " + valoreMantissa + " " + Math.pow(2,i));
		}
		
		System.out.println("Il valore decimale e': " + segno + " " + valoreMantissa);
	}
}