package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * unabh�ngiger W�rfel mit variabler Augenzahl
 * @author Lukas
 *
 */
public class Kontrolle {
	private Wuerfel wuerfel1;
	private Berechnungen berechnungen1;
	private int anzahlVersuche;
	
	/**
	 * Konstruktor
	 * @param anzahlVersuche Anzahl der W�rfe des zu testenden W�rfels
	 */
	
	public Kontrolle(int anzahlVersuche) {
		this.anzahlVersuche = anzahlVersuche;
	}
	
	
	/**
	 * Fragt nach geforderter Augenzahl, erstellt den W�rfel und f�hrt die W�rfe durch, bef�llt dabei ein Int-Array
	 * @return Das gef�llte Int-Array mit den absoluten H�ufigkeiten
	 */
	public int[] steuerfunktion() {
		// Initialisierung
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe1 = "";
		int augenZahl;
		
		// Augenzahl einlesen
		System.out.println("Bitte geben sie die maximale Augenzahl des zu Testenden W�rfels ein! (Bitte realistisch bleiben)");
		try {
			eingabe1 = br.readLine();
		}
		catch(IOException ioex) {
			System.out.println("Fehler beim Einlesen der Augenzahl!");
			ioex.printStackTrace();
		}
		augenZahl = Integer.parseInt(eingabe1);
		
		
		//Erschaffe den W�rfel und H�ufigkeitstabelle initialisieren
		wuerfel1 = new Wuerfel(augenZahl);
		int[] ereignisse = new int[augenZahl + 1];
		for(int i = 0; i<augenZahl+1; i++) {
			ereignisse[i] = 0;
		}
		
		
		//W�rfel bis zum bitteren Ende
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
		berechnungen1 = new Berechnungen(anzahlVersuche);
		berechnungen1.initialisiereKontrolle();
		System.out.println(berechnungen1.ausgabeFunktion());
		System.out.println("\n\n");

	}
	
}
