import java.util.Random;
import java.util.Scanner;

public class Newmastermind {
	public static void main(String[] args) {
		System.out.println("Oooo noooo! Your girlfriend is locked in a tiny box...");
		System.out.println("Quick, solve the 4 letter code before she gets cramp and dumps you!!");
		System.out.println(" ");
		System.out.println("The code is in a random order and made from the following letters:");
		System.out.println("a, b, c, d, e, f ");
		System.out.println(" ");

		Code code = new Code();
		code.codemaken();

		Speler speler = new Speler();
		speler.spelen();
	}
}

class Regels extends Speler {
	static void eerstevergelijking() {
		if (spelervergelijking[0] == compvergelijking[0]) {
			dezelfdeplek += 1;
			spelervergelijking[0] = 0;
			compvergelijking[0] = 1;
			return;
		}
	}

	static void tweedevergelijking() {
		if (spelervergelijking[1] == compvergelijking[1]) {
			dezelfdeplek += 1;
			spelervergelijking[1] = 0;
			compvergelijking[1] = 1;
			return;
		}
	}

	static void derdevergelijking() {
		if (spelervergelijking[2] == compvergelijking[2]) {
			dezelfdeplek += 1;
			spelervergelijking[2] = 0;
			compvergelijking[2] = 1;
			return;
		}
	}

	static void vierdevergelijking() {
		if (spelervergelijking[3] == compvergelijking[3]) {
			dezelfdeplek += 1;
			spelervergelijking[3] = 0;
			compvergelijking[3] = 1;
			return;
		}
	}

	static void vijfdevergelijking() {
		if (spelervergelijking[0] == compvergelijking[1]) {
			inderij += 1;
			spelervergelijking[0] = 0;
			compvergelijking[1] = 1;
			return;
		} else if (spelervergelijking[0] == compvergelijking[2]) {
			inderij += 1;
			spelervergelijking[0] = 0;
			compvergelijking[2] = 1;
			return;
		} else if (spelervergelijking[0] == compvergelijking[3]) {
			inderij += 1;
			spelervergelijking[0] = 0;
			compvergelijking[3] = 1;
			return;
		}
	}
	static void sesdevergelijking() {
		if(spelervergelijking[1] == compvergelijking[0]) {
			inderij += 1;
			spelervergelijking [1] = 0;
			compvergelijking[0] = 1;
			return;
		}else if(spelervergelijking[1] == compvergelijking[2]) {
			inderij += 1;
			spelervergelijking [1] = 0;
			compvergelijking[2] = 1;
			return;
		}else if(spelervergelijking[1] == compvergelijking[3]) {
			inderij += 1;
			spelervergelijking [1] = 0;
			compvergelijking[3] = 1;
			return;
		}
	}
	static void sevendevergelijking() {
		if(spelervergelijking[2] == compvergelijking[0]) {
			inderij += 1;
			spelervergelijking [2] = 0;
			compvergelijking[0] = 1;
			return;
		}else if(spelervergelijking[2] == compvergelijking[1]) {
			inderij += 1;
			spelervergelijking [2] = 0;
			compvergelijking[1] = 1;
			return;
		}else if(spelervergelijking[2] == compvergelijking[3]) {
			inderij += 1;
			spelervergelijking [2] = 0;
			compvergelijking[3] = 1;
			return;

		}
	}
	static void achtstevergelijking() {
		if(spelervergelijking[3] == compvergelijking[0]) {
			inderij += 1;
			spelervergelijking [3] = 0;
			compvergelijking[0] = 1;
			return;
		}else if(spelervergelijking[3] == compvergelijking[1]) {
			inderij += 1;
			spelervergelijking [3] = 0;
			compvergelijking[1] = 1;
			return;
		}else if(spelervergelijking[3] == compvergelijking[2]) {
			inderij += 1;
			spelervergelijking [3] = 0;
			compvergelijking[2] = 1;
			return;
		}
	}
}

class Speler extends Code {
	static int beurten = 11;
	static String spelerinvoer;
	static char[] spelervergelijking = new char[4];
	static char[] compvergelijking = new char[4];
	static int dezelfdeplek = 0;
	static int inderij = 0;

	void spelen() {
		for (int i = 11; i >= 0; i--) {

			compvergelijking[0] = teraden[0];
			compvergelijking[1] = teraden[1];
			compvergelijking[2] = teraden[2];
			compvergelijking[3] = teraden[3];

			Scanner invoer = new Scanner(System.in);
			String scan = invoer.nextLine();
			spelerinvoer = scan;

			if (scan.length() < 4 || scan.length() > 4) {
				System.out.println("You did not enter 4 letters. Please start again and enter exactly 4 letters.");
				return;
			}

			spelervergelijking[0] = spelerinvoer.charAt(0);
			spelervergelijking[1] = spelerinvoer.charAt(1);
			spelervergelijking[2] = spelerinvoer.charAt(2);
			spelervergelijking[3] = spelerinvoer.charAt(3);

			Regels.eerstevergelijking();
			Regels.tweedevergelijking();
			Regels.derdevergelijking();
			Regels.vierdevergelijking();
			Regels.vijfdevergelijking();
			Regels.sesdevergelijking();
			Regels.sevendevergelijking();
			Regels.achtstevergelijking();

			System.out.println(spelerinvoer + "    On the right spot: " + dezelfdeplek + "    In the row: " + inderij
					+ "    Attempts left: " + beurten);
			if (dezelfdeplek == 4) {
				System.out.println(" ");
				System.out.println(
						"You did it! You have unlocked the code and saved your girlfriend from endless cramp in a tiny box!");
				return;
			}
			dezelfdeplek = 0;
			inderij = 0;
			beurten--;

		}
		System.out.println(" ");
		System.out.println("You have been dumped! Your girlfriend is getting crazy cramps in this tiny box ... ");
		System.out.println("You did not crack the code in all your 12 attempts.");
		System.out.print("The code was: ");
		System.out.print(Code.teraden[0]);
		System.out.print(Code.teraden[1]);
		System.out.print(Code.teraden[2]);
		System.out.println(Code.teraden[3]);
	}
}

class Code {
	char codecomp;
	static char[] teraden = new char[4];
	char deString;

	void RandomLetter() {
		char[] LetterKeuze = { 'a', 'b', 'c', 'd', 'e', 'f' };
		Random schudden = new Random();
		int geschud = schudden.nextInt(5);
		int i = geschud;
		deString = LetterKeuze[i];
	}

	void codemaken() {
		for (int i = 0; i < teraden.length; i++) {
			Code L1 = new Code();
			L1.RandomLetter();
			teraden[i] = L1.deString;
		}
		for (int x = 0; x < teraden.length; x++) {
		}
	//	System.out.print(Code.teraden[0]);
	//	System.out.print(Code.teraden[1]);
	//	System.out.print(Code.teraden[2]);
	//	System.out.println(Code.teraden[3]);

	}
}
