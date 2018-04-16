package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * unabh�ngiger W�rfel mit variabler Augenzahl
 * @author Lukas
 * @version 2.0
 */
public class Kontrolle {
	// Klassenvariablen, die eine Instanz des W�rfels und eine der Berechnungen enthalten und dazu die Anzahl der W�rfe in anzahlVersuche
	private Wuerfel wuerfel1;
	private Berechnungen berechnungen1;
	private int anzahlVersuche;
	
	/**
	 * Konstruktor
	 * @param anzahlVersuche Anzahl der W�rfe des zu testenden W�rfels
	 */
	
	public Kontrolle(int anzahlVersuche) {
		// Wei�t anzahlVersuche die Anzahl der W�rfe zu
		this.anzahlVersuche = anzahlVersuche;
	}
	
	
	/**
	 * Fragt nach geforderter Augenzahl, erstellt den W�rfel und f�hrt die W�rfe durch, bef�llt dabei ein Int-Array
	 * @return Das gef�llte Int-Array mit den absoluten H�ufigkeiten
	 */
	public int[] steuerfunktion() {
		// Initialisierung, lege Eingabe-Stream  und Augen-Zahl-Variable an 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe1 = "";
		int augenZahl = 1;
		
		// Versuche die Augenzahl per Konsole einzulesen, fange Exceptions ab
		System.out.println("Bitte geben sie die maximale Augenzahl des zu Testenden W�rfels ein! (Bitte realistisch bleiben)");
		try {
			eingabe1 = br.readLine();
			augenZahl = Integer.parseInt(eingabe1);
		}
		catch(IOException ioex) {
			System.out.println("Fehler beim Einlesen der Augenzahl!");
			ioex.printStackTrace();
		}
		catch(NumberFormatException nfex) {
			System.out.println("Zu gro�e Augenzahl eingegeben!");
			nfex.printStackTrace();
		}

		
		// Unsinnige Eingabe wird abgefangen (Augenzahl -> 0)
		if(augenZahl == 0) {
			System.out.println("Ein W�rfel ohne w�rfelbare Ereignisse macht keinen Sinn! Programm bricht ab.");
			return null;
		}
		
		
		// Erschaffe W�rfelinstanz und initialisiere die H�ufigkeitstabelle mit 0
		wuerfel1 = new Wuerfel(augenZahl);
		int[] ereignisse = new int[augenZahl + 1];
		for(int i = 0; i<augenZahl+1; i++) {
			ereignisse[i] = 0;
		}
		
		
		// F�hre die W�rfe des W�rfels aus und erh�he den Wert des Arrays an der Stelle des Ereignisses (H�ufigkeitsz�hler)
		for(int i = 0; i<anzahlVersuche; i++) {
			int gew�rfelt = wuerfel1.wuerfelMich();
			ereignisse[gew�rfelt] += 1;
		}
		
		//Gib fertiges Array zur�ck
		return ereignisse;
	}
	
	/**
	 * Lenkt den Programm-Ablauf m�glichst UML-Konform und die Reihenfolge der Aufrufe der Methoden
	 */
	public void beginneTest() {
		// Erzeuge ein Objekt vom Typ Berechnungen und �bergebe ihm die Anzahl der W�rfe
		berechnungen1 = new Berechnungen(anzahlVersuche);
		
		// Initialisiere das Berechnungen-Objekt
		berechnungen1.initialisiereKontrolle();
		
		// Gib die Inhalte der errechnete Tabellen sauber formatiert aus
		System.out.println(berechnungen1.ausgabeFunktion());
		System.out.println("\n\n");

	}
	
}
