package nba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nba.Ulaz;

public class Start {

	private List<Igrac> igraci;
	
	
	public Start() {
		igraci = new ArrayList<Igrac>();
		Ulaz.scanner = new Scanner(System.in);
		glavniIzbornik();
		
		
		
	}
	
	
	
	
	
	private void glavniIzbornik() {
		System.out.println("***** NBA *****");
		System.out.println("IZBORNIK");
		System.out.println("1. Igraci");
		System.out.println("2. Treneri");
		System.out.println("3. Statistika");
		System.out.println("4. Ekipe");
		System.out.println("5. Izlaz iz programa");
		ucitajGlavnuAkciju();
		
	}





	private void ucitajGlavnuAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 :
			igraciIzbornik();
			break;
		case 5:
			System.out.println("Program je zavrsio!");
			return;
		}
		
	}





	private void igraciIzbornik() {
		System.out.println("************************");
		System.out.println("Podizbornik 1.Igraci");
		System.out.println("Odaberi akciju");
		System.out.println("1. Unos novog igraca");
		System.out.println("2. Promjena postojeceg igraca");
		System.out.println("3. Brisanje postojeceg igraca");
		System.out.println("4. Povratak u predhodnik izbornik");
		System.out.println("5. Povratak u predthodni izbornik");
		igracUcitajAkciju();
		
	}





	private void igracUcitajAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 -> igracPregled();
		case 2 -> igracUnosNovog();
		case 3 -> igracPromjena();
		case 4 -> igracBrisanje();
		case 5 -> glavniIzbornik();
		}
		
	}





	private Object igracBrisanje() {
		// TODO Auto-generated method stub
		return null;
	}





	private Object igracPromjena() {
		// TODO Auto-generated method stub
		return null;
	}





	private Object igracUnosNovog() {
		// TODO Auto-generated method stub
		return null;
	}





	private Object igracPregled() {
		// TODO Auto-generated method stub
		return null;
	}





	public static void main(String[] args) {
		new Start();
	}
}
