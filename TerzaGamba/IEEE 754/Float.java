import java.util.Scanner;

public class Float {

	public static int trunc(float n) {

		return (int)n;
	}

	public static String trimBin(String bin) {

		String binCpy = "";

		for (int i = 0; i < bin.length(); i++) {

			if (bin.charAt(i) == '1') {

				binCpy += bin.substring(i);
				i = bin.length();
			}
		}

		return binCpy;
	}

	public static String base10ToBase2(int n) {

		//The variable that will contain the binary value
		String bin = "";

		n = Math.abs(n);

		while (n != 0) {

			bin = String.valueOf(n % 2) + bin;
			n /= 2;
		}

		return bin;
	}

	public static String base10ToBase2(float n, int bit_count) {

		//The variable that will contain the binary value
		String bin = "";

		n = Math.abs(n);

		//Put 0 to the left of the "."
		n = n - trunc(n);

		while (bit_count > 0) {

			n *= 2;
			bin += String.valueOf(trunc(n));
			n = n - trunc(n);

			bit_count--;
		}

		return bin;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Insert the number to convert: ");
		float num = in.nextFloat();

		//If the variable "sign" is true, the num sign is negative,
		//but if it is false, then the num sign is positive
		int sign;
		if (num < 0)
			sign = 1;
		else
			sign = 0;

		String bin = trimBin(base10ToBase2(trunc(num)));
		int exponent = bin.length() - 1;

		String convertedMantissa = bin.substring(1) + base10ToBase2(num - trunc(num), 23 - exponent);

		//Convert the exponent in base 2
		String convertedExponent = base10ToBase2(exponent + 127);

		//Print the P754
		System.out.print(num + " as FLOAT-32 is " + sign + " " + convertedExponent + " " + convertedMantissa);
	}
}
