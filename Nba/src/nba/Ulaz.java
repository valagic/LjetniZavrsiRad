package nba;

import java.util.Scanner;

public class Ulaz {

	public static Scanner scanner;
	
	
	

	public static int ucitajCijeliBroj (String poruka, String greska, int min, int max) {
		int broj = 0;
		while(true) {
			System.out.println(poruka);
			try {

				broj = Integer.parseInt(
						scanner.nextLine());
				if (broj<min || broj>max) {
					System.out.println("Broj ne smije biti manji od " + min
							+ " ili ve�i od " + max);
					continue;
			}
				break;
			}catch (Exception e) {
				System.out.println(greska);
			}
		}
		return broj;
	}
}
