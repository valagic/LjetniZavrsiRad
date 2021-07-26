package nba;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ulaz {

	public static Scanner scanner;
	
public static final String FORMAT_DATUM="dd.MM.yyyy.";
	
	public static Date ucitajDatum(String poruka) {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUM);
		while(true) {
			System.out.print(poruka);
			try {
				return df.parse(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Ne ispravan format datuma. "
						+ "Primjer unosa: " + df.format(new Date()));
			}
		}
	}
	

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
	
	public static double ucitajDouble(
			String poruka, 
			String greska, 
			double min, 
			double max) {
		double broj=0;
		while(true) {
			System.out.print(poruka);
			try {
				
				broj = Double.parseDouble(
						scanner.nextLine());
				if (broj<min || broj>max) {
					System.out.println("Broj ne smije biti manji od " + min
							+ " ili ve�i od " + max);
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println(greska);
			}
		}
		
		return broj;
	}
	public static String ucitajString(String poruka,String greska) {
		String s="";
		while(true) {
			System.out.print(poruka);
			s = scanner.nextLine();
			if(s.trim().equals("")){
				System.out.println(greska);
				continue;
			}
			break;
		}
		
		return s;
	}
	
}
