package nba;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nba.Ulaz;
// u metodi ucitajglavnuakciju probati napraviti za izlaz iz programa metodu
// u metodi ucitajGlavnuAkciju mozda prebaciti na novu switch umjesto stare
// pokusati malo popraviti izbornike od svih klasa, da to ljepse izgleda
// kod klase Igrac -> nepotrebno je unositi statistiku kod igraca 
// u metodi igracStavke je potrebno obrisati nepotrebne podatke o statistici(ostaviti samo ime,prezime i naziv ekipe)
// kod klase Utakmica -> potrebno jos napraviti rezultat prve ekipe i rezultat druge ekipe, za sada je napravljeno da samo jedan broj mogu unijeti


public class Start {

	private List<Igrac> igraci;
	private List<Trener> treneri;
	private List<Statistika> statistike;
	private List<Ekipa> ekipe;
	private List<Utakmica> utakmice;
	//private Scanner scanner;
	
	public static final String poveznicaEraDijagram = "https://github.com/valagic/NBA/blob/main/era%20dijagram.png";
	public static final String poveznicaZaGithub = "https://github.com/valagic/LjetniZavrsiRad";
	
	public Start() {
		igraci = new ArrayList<Igrac>();
		treneri = new ArrayList<Trener>();
		statistike = new ArrayList<Statistika>();
		ekipe = new ArrayList<Ekipa>();
		utakmice = new ArrayList<Utakmica>();
		Ulaz.scanner = new Scanner(System.in);
		pocetniEkran();
		

	}
	private void pocetniEkran() {
		System.out.println("*********************");
		System.out.println("Moja prva aplikacija");
		System.out.println("*********************");
		System.out.println("");
		System.out.println("1. Ulaz u aplikaciju NBA");
		System.out.println("2. Link za github");
		System.out.println("3. Link za era dijagram");
		System.out.println("4. Informacije o programu");
		ucitajPocetnuAkciju();
		
	}

	private void ucitajPocetnuAkciju() {
		System.out.println("");
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 4)) {
		case 1 -> glavniIzbornik();
		case 2 -> poveznicaZaGithub();
		case 3 -> poveznicaZaEraDijagram();
		case 4 -> informacijeOProgramu();
		}
		
	}

	private void informacijeOProgramu() {
		System.out.println("");
		System.out.println("Aplikacija o NBA");
		System.out.println("");
		System.out.println("U ovoj se aplikaciju mogu dodavati igraci,");
		System.out.println("mijenjati postojece, dodavati njihovu statistiku");
		System.out.println("i sve to brisati.");
		System.out.println("");
		System.out.println("Aplikaciju je napravio Vedran Alagić");
		System.out.println("");
		String informacije = Ulaz.ucitajInformacije("Ako zelis saznati vise o programu upisi da: ", "Nisi upisao da");
		if(informacije.toLowerCase().equals("da")) {
			System.out.println("");
			glavniIzbornik();
			
		}else {
			System.out.println("");
			pocetniEkran();
		}
		
	}

	private void poveznicaZaGithub() { 
		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			desktop.browse(new URI(poveznicaZaGithub));
		} catch (Exception e) {
			System.out.println("Dogodila se greška. Pokušajte ponovno kasnije.");
		}
	}
	
	private void poveznicaZaEraDijagram() {
		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			desktop.browse(new URI(poveznicaEraDijagram));
		} catch (Exception e) {
			System.out.println("Dogodila se greška. Pokušajte ponovno kasnije.");
		}
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
		case 1 -> igraciIzbornik();

		case 2 -> trenerIzbornik();
			
		case 3 -> statistikaIzbornik();
			
		case 4 -> ekipaIzbornik();
			
		case 5 -> utakmicaIzbornik();
			
		case 6 ->  {
					String izlaz = Ulaz.ucitajIzlaz("jesi siguran da hoces izaci", "greska");
					System.out.println("");
					if(izlaz.trim().toLowerCase().equals("da")) {
						 System.exit(0);
					} else {
						glavniIzbornik();
					}
				}
		}
	}
	// kada se pokrene aplikacija kod utakmica bilo bi dobro napraviti kod pregleda utakmica da izgleda tipa ovako
	// datum pocetka : 28.07.2021.
	// domaca momcad : ime
	// gostujuca momcad : ime
	// naziv dvorane : ime
	// rezultat : domaca momcad rezultat : rezultat gostujuca momcad
	
	
	private void utakmicaIzbornik() {
		System.out.println("************************");
		System.out.println("Podizbornik 5.Utakmice");
		System.out.println("Odaberi opciju");
		System.out.println("1. Pregled utakmica");
		System.out.println("2. Unos nove utakmice");
		System.out.println("3. Promjena postojece utakmice");
		System.out.println("4. Brisanje postojece utakmice");
		System.out.println("5. Vracanje u prethodni izbornik");
		utakmicaUcitajAkciju();
		
	}

	private void utakmicaUcitajAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 -> { 
			utakmicaPregled();
			utakmicaIzbornik();
		}
		case 2 -> utakmicaUnosNove();
		case 3 -> utakmicaPromjena();
		case 4 -> utakmicaBrisanje();
		case 5 -> glavniIzbornik();
		}
	}

	private void utakmicaBrisanje() {
		utakmicaStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				utakmice.size());
		utakmice.remove(redniBroj-1);
		utakmicaIzbornik();
	}

	private void utakmicaPromjena() {
		utakmicaStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				utakmice.size());
		Utakmica utakmicaZaPromjenu = utakmice.get(redniBroj - 1);
		utakmicaZaPromjenu = utakmicaPostaviVrijednosti(utakmicaZaPromjenu);
		utakmice.set(redniBroj - 1, utakmicaZaPromjenu);
		utakmicaIzbornik();
	}

	private void utakmicaUnosNove() {
		Utakmica u = new Utakmica();
		u = utakmicaPostaviVrijednosti(u);
		utakmice.add(u);
		utakmicaIzbornik();
	}

	private Utakmica utakmicaPostaviVrijednosti(Utakmica u) {
		u.setDatumPocetka(Ulaz.ucitajDatum("Unesi datum početka: "));
		u.setDomacaMomcad(Ulaz.ucitajString("Naziv domace momcadi: ", "Nisi unio dobar naziv"));
		u.setGostujucaMomcad(Ulaz.ucitajString("Naziv gostujuce momcadi: ", "Nisi unio dobar naziv"));
		u.setNazivDvorane(Ulaz.ucitajString("Unesi naziv dvorane: ", "Nisi unio dobar naziv"));
		u.setRezultat(Ulaz.ucitajCijeliBroj("Unesi broj poena ekipa: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		return u;
	}

	private void utakmicaPregled() {
		utakmicaStavke("Pregled utakmica");
		
	}

	private void utakmicaStavke(String naslov) {
		System.out.println(naslov);
		System.out.println("------------------------");
		if(utakmice.isEmpty()) {
			System.out.println("Nema unesenih utakmica");
		}else {
			Utakmica u;
		for(int i = 0; i < utakmice.size(); i++) {
			u = utakmice.get(i);
			System.out.println((i+1) + " " + u.getDatumPocetka() + " " +  u.getDomacaMomcad() + " " + u.getGostujucaMomcad() + " " + u.getNazivDvorane()
			+ " " + u.getRezultat());
			}
		}
		
	}

	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	
	// kada se pokrene pregled ekipa trebalo bi napraviti da izlgeda tipa
	// ime momcadi : utah jazz
	
	
	private void ekipaIzbornik() {
		System.out.println("************************");
		System.out.println("Podizbornik 4.Ekipe");
		System.out.println("Odaberi opciju");
		System.out.println("1. Pregled ekipa");
		System.out.println("2. Unos nove ekipe");
		System.out.println("3. Promjena postojece ekipe");
		System.out.println("4. Brisanje postojece ekipe");
		System.out.println("5. Vracanje u prethodni izbornik");
		ekipaUcitajAkciju();
	}

	private void ekipaUcitajAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 -> { 
			ekipaPregled();
			ekipaIzbornik();
		}
		case 2 -> ekipaUnosNove();
		case 3 -> ekipaPromjena();
		case 4 -> ekipaBrisanje();
		case 5 -> glavniIzbornik();
		}
		
	}

	private void ekipaBrisanje() {
		ekipaStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				ekipe.size());
		ekipe.remove(redniBroj-1);
		ekipaIzbornik();
	}

	private void ekipaPromjena() {
		ekipaStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				statistike.size());
		Ekipa ekipaZaPromjenu = ekipe.get(redniBroj - 1);
		ekipaZaPromjenu = ekipaPostaviVrijednosti(ekipaZaPromjenu);
		ekipe.set(redniBroj - 1, ekipaZaPromjenu);
		ekipaIzbornik();
	}

	private void ekipaUnosNove() {
		Ekipa e = new Ekipa();
		e = ekipaPostaviVrijednosti(e);
		ekipe.add(e);
		ekipaIzbornik();
	}

	private Ekipa ekipaPostaviVrijednosti(Ekipa e) {
		e.setNaziv(Ulaz.ucitajString("Unesi naziv ekipe", "Nisi unio dobar naziv"));
		return e;
	}

	private void ekipaPregled() {
		ekipaStavke("Pregled ekipa");
		
	}

	private void ekipaStavke(String naslov) {
		System.out.println(naslov);
		System.out.println("------------------------");
		if(ekipe.isEmpty()) {
			System.out.println("Nema unesenih ekipa");
		}else {
			Ekipa e;
		for(int i = 0; i < ekipe.size(); i++) {
			e = ekipe.get(i);
			System.out.println((i+1) + " " + e.getNaziv());
			}
		}
		
	}

	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	
	// kada se radi pregled statistike potrebno je napraviti da izgleda tipa
	//	postotak suta iz igre : 
	// postotak slobodna :
	// poeni
	// skokovi
	// assisti
	// stealovi
	// blokovi
	// TO
	
	private void statistikaIzbornik() {
		System.out.println("************************");
		System.out.println("Podizbornik 3.Statistike");
		System.out.println("Odaberi opciju");
		System.out.println("1. Pregled statistike za igraca");
		System.out.println("2. Unos nove statistike za igraca");
		System.out.println("3. Promjena postojece statistike");
		System.out.println("4. Brisanje postojece statistike");
		System.out.println("5. Vracanje u prethodni izbornik");
		statistikaUcitajAkciju();
		
	}

	private void statistikaUcitajAkciju() {
		switch(Ulaz.ucitajCijeliBroj("Odaberi broj: ", "Nisi unio cijeli broj", 1, 5)) {
		case 1 ->  {
			statistikaPregled();
			statistikaIzbornik();
		}
		case 2 -> statistikaUnosNove();
		case 3 -> statistikaPromjena();
		case 4 -> statistikaBrisanje();
		case 5 -> glavniIzbornik();
	
		}
		
	}

	private void statistikaBrisanje() {
		statistikaStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				statistike.size());
		statistike.remove(redniBroj-1);
		statistikaIzbornik();
	}

	private void statistikaPromjena() {
		statistikaStavke("Trenutno dostupno u aplikaciji");
		int redniBroj = Ulaz.ucitajCijeliBroj("Odaberite redni broj za promjenu: ", "Niste unijeli cijeli broj", 1,
				statistike.size());
		Statistika statistikaZaPromjenu = statistike.get(redniBroj - 1);
		statistikaZaPromjenu = statisikaPostaviVrijednosti(statistikaZaPromjenu);
		statistike.set(redniBroj - 1, statistikaZaPromjenu);
		statistikaIzbornik();
	}

	private void statistikaUnosNove() {
		Statistika s = new Statistika();
		s = statisikaPostaviVrijednosti(s);
		statistike.add(s);
		statistikaIzbornik();
	}

	private Statistika statisikaPostaviVrijednosti(Statistika s) {
		s.setPostotakSutaIzIgre(Ulaz.ucitajDouble("Unesi postotak suta iz igre: ", "Nisi unio dobar broj", 0, 100));
		s.setPostotakSutaSlobodnaBacanja(Ulaz.ucitajDouble("Unesi postotak slobodnih bacanja: ", "Nisi unio dobar broj", 0, 100));
		s.setBrojPoena(Ulaz.ucitajCijeliBroj("Unesi broj poena: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		s.setBrojSkokova(Ulaz.ucitajCijeliBroj("Unesi broj skokova: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		s.setBrojAsistencija(Ulaz.ucitajCijeliBroj("Unesi broj asistencija: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		s.setBrojStealova(Ulaz.ucitajCijeliBroj("Unesi broj stealova: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		s.setBrojBlokova(Ulaz.ucitajCijeliBroj("Unesi broj blokova: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		s.setBrojTurnovera(Ulaz.ucitajCijeliBroj("Unesi broj turnovera: ", "Nisi unio dobar broj", 0, Integer.MAX_VALUE));
		return s;
	}

	private void statistikaPregled() {
		statistikaStavke("Pregled statistike igraca");
		
	}

	private void statistikaStavke(String naslov) {
		System.out.println(naslov);
		System.out.println("------------------------");
		if(statistike.isEmpty()) {
			System.out.println("Nema unesenih statistika");
		}else {
			Statistika s;
			for(int i = 0; i < statistike.size(); i++) {
				s = statistike.get(i);
				System.out.println((i+1) + " " + s.getPostotakSutaIzIgre() + " " + s.getPostotakSutaSlobodnaBacanja() + " " + s.getBrojPoena() + " " + s.getBrojSkokova()
				+ " " + s.getBrojAsistencija() + " " + s.getBrojStealova() + " " + s.getBrojBlokova() + " " + s.getBrojTurnovera());
			}
		}
		
	}

	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	
	// kod pregleda napraviti
	// ime :
	// przime :
	// ekipu koju trenira :
	
	
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
	
	// kod pregleda napraviti
	// ime
	// prezime
	// za koju ekipu igra
	
	
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
