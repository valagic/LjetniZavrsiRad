package nba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nba.Ulaz;

public class Start {

	private List<Igrac> igraci;
	private List<Trener> treneri;
	
	
	public Start() {
		igraci = new ArrayList<Igrac>();
		treneri = new ArrayList<Trener>();
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
		System.out.println("5. Utakmica");
		System.out.println("6. Izlaz iz programa");
		ucitajGlavnuAkciju();
		
	}

	private void ucitajGlavnuAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 6)) {
		case 1 :
			igraciIzbornik();
			break;
		case 2 :
			trenerIzbornik();
		case 6:
			System.out.println("Program je zavrsio!");
			return;
		}
		
	}

	private void trenerIzbornik() {
		System.out.println("************************");
		System.out.println("Podizbornik 2.Treneri");
		System.out.println("Odaberi opciju");
		System.out.println("1. Pregled unesenih trenera");
		System.out.println("2. Unos novog trenera");
		System.out.println("3. Promjena postojeceg trenera");
		System.out.println("4. Brisanje postojeceg trenera");
		System.out.println("5. Povratak u prethodni izbornik");
		trenerUcitajAkciju();
		
	}

	
	private void trenerUcitajAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 ->  { 
			trenerPregled();
			trenerIzbornik(); }
		case 2 -> trenerUnosNovog();
		case 3 -> trenerPromjena();
		case 4 -> trenerBrisanje();
		case 5 -> glavniIzbornik();
		}
	}
	

	private void trenerBrisanje() {
		trenerStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za brisanje: ", "Niste unijeli cijeli broj", 1,
				treneri.size());
		treneri.remove(redniBroj - 1);
		trenerIzbornik();
		
	}

	private void trenerPromjena() {
		trenerStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				treneri.size());
		Trener trenerZaPromjenu = treneri.get(redniBroj - 1);
		trenerZaPromjenu = trenerPostaviVrijednost(trenerZaPromjenu);
		treneri.set(redniBroj - 1, trenerZaPromjenu);
		trenerIzbornik();
	}

	private void trenerUnosNovog() {
		Trener t = new Trener();
		t = trenerPostaviVrijednost(t);
		treneri.add(t);
		trenerIzbornik();
	}

	private Trener trenerPostaviVrijednost(Trener t) {
		t.setIme(Ulaz.ucitajString("Unesi ime trenera: ", "Nisi unio dobro ime"));
		t.setPrezime(Ulaz.ucitajString("Unesi prezime trenera: ", "Nisi unio dobro prezime"));
		t.setEkipa(Ulaz.ucitajString("Unesi ime ekipe koju trenira: ", "Nisi unio dobro ime ekipe"));
		
		return t;
	}

	private void trenerPregled() {
		trenerStavke("Pregled unesenih trenera");
		
	}

	private void trenerStavke(String naslov) {
		System.out.println(naslov);
		System.out.println("-----------------");
		if(treneri.isEmpty()) {
			System.out.println("Nema unesenih trenera");
		}else {
			Trener t;
			for(int i = 0; i < treneri.size();i++) {
				t = treneri.get(i);
				System.out.println((i+1)+ " " + t.getIme() + " " + t.getPrezime() + " " + t.getEkipa());
			}
		}
		
	}

	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	
	private void igraciIzbornik() {
		System.out.println("************************");
		System.out.println("Podizbornik 1.Igraci");
		System.out.println("Odaberi opciju");
		System.out.println("1. Pregled unesenih igraca");
		System.out.println("2. Unos novog igraca");
		System.out.println("3. Promjena postojeceg igraca");
		System.out.println("4. Brisanje postojeceg igraca");
		System.out.println("5. Povratak u predhodnik izbornik");
		igracUcitajAkciju();
		
	}

	private void igracUcitajAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 ->  { 
				igracPregled();
				igraciIzbornik();
		}
		case 2 -> igracUnosNovog();
		case 3 -> igracPromjena();
		case 4 -> igracBrisanje();
		case 5 -> glavniIzbornik();
		}
		
	}

	private void igracBrisanje() {
		igracStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberi redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				igraci.size());
		igraci.remove(redniBroj - 1);
		igraciIzbornik();
	}
	
	private void igracPromjena() {
		igracStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberi redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				igraci.size());
		Igrac igracZaPromjenu = igraci.get(redniBroj - 1);
		igracZaPromjenu = igracPostaviVrijednost(igracZaPromjenu);
		igraci.set(redniBroj - 1, igracZaPromjenu);
		igraciIzbornik();
	}

	private void igracUnosNovog() {
		Igrac ii= new Igrac();
		ii = igracPostaviVrijednost(ii);
		igraci.add(ii);
		igraciIzbornik();
	}

	private Igrac igracPostaviVrijednost(Igrac ii) {
		ii.setIme(Ulaz.ucitajString("Unesi ime kosarkasa: ", "Nisi unio ime"));
		ii.setPrezime(Ulaz.ucitajString("Unesi prezime kosarkasa: ", "Nisi unio prezime"));
		ii.setNazivEkipe(Ulaz.ucitajString("Unesi ime ekipe za koju igra: ", "Nisi unio ime ekipe"));
		ii.setBrojPoena(Ulaz.ucitajCijeliBroj("Unesi broj poena: ", "Poeni moraju biti cijeli broj", 0, Integer.MAX_VALUE));
		ii.setBrojAsistencija(Ulaz.ucitajCijeliBroj("Unesi broj asistencija: ", "Asistencije moraju biti cijeli broj", 0, Integer.MAX_VALUE));
		ii.setBrojSkokova(Ulaz.ucitajCijeliBroj("Unesi broj skokova: ", "Skokovi moraju biti cijeli broj", 0, Integer.MAX_VALUE));
		ii.setBrojStealova(Ulaz.ucitajCijeliBroj("Unesi broj stealova: ", "Stelovi moraju biti cijeli broj", 0, Integer.MAX_VALUE));
		ii.setBrojBlokova(Ulaz.ucitajCijeliBroj("Unesi broj blokova: ", "Blokovi moraju biti cijeli broj", 0, Integer.MAX_VALUE));
		ii.setBrojTurnovera(Ulaz.ucitajCijeliBroj("Unesi broj turnovera: ", "Turnoveri moraju biti cijeli broj", 0, Integer.MAX_VALUE));
		ii.setPostotakSutaIzIgre(Ulaz.ucitajDouble("Unesi postotak suta iz igre: ", "Nisi unio dobar broj", 0, Double.MAX_VALUE));
		ii.setPostotakSutaSlobodnaBacanja(Ulaz.ucitajDouble("Unesi postotak slobodnih bacanja: ", "Nisi unio dobar broj", 0, Double.MAX_VALUE));
		
		return ii;
	}

	private void igracPregled() {
		igracStavke("Pregled unesenih igraca");
	}

	private void igracStavke(String naslov) {
		System.out.println(naslov);
		System.out.println("----------------");
		if(igraci.isEmpty()) {
			System.out.println("Nema unesenih igraca");
		}else {
			Igrac ii;
			for(int i = 0 ;i < igraci.size();i++) {
				ii = igraci.get(i);
				System.out.println((i+1) + ". " + ii.getIme() + " " + ii.getPrezime() + " " + ii.getNazivEkipe() + " "
				+ ii.getBrojPoena() + " " + ii.getBrojAsistencija() + " " + ii.getBrojSkokova() + " " + ii.getBrojStealova()
				+ " " + ii.getBrojBlokova() + " " + ii.getBrojTurnovera() + " " + ii.getPostotakSutaIzIgre() + " " + ii.getPostotakSutaSlobodnaBacanja());
			}
		}
		
	}





	public static void main(String[] args) {
		new Start();
	}
}
