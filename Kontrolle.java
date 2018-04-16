package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * unabhängiger Würfel mit variabler Augenzahl
 * @author Lukas
 *
 */
public class Kontrolle {
	private Wuerfel wuerfel1;
	private Berechnungen berechnungen1;
	private int anzahlVersuche;
	
	/**
	 * Konstruktor
	 * @param anzahlVersuche Anzahl der Würfe des zu testenden Würfels
	 */
	
	public Kontrolle(int anzahlVersuche) {
		this.anzahlVersuche = anzahlVersuche;
	}
	
	
	/**
	 * Fragt nach geforderter Augenzahl, erstellt den Würfel und führt die Würfe durch, befüllt dabei ein Int-Array
	 * @return Das gefüllte Int-Array mit den absoluten Häufigkeiten
	 */
	public int[] steuerfunktion() {
		// Initialisierung
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe1 = "";
		int augenZahl;
		
		// Augenzahl einlesen
		System.out.println("Bitte geben sie die maximale Augenzahl des zu Testenden Würfels ein! (Bitte realistisch bleiben)");
		try {
			eingabe1 = br.readLine();
		}
		catch(IOException ioex) {
			System.out.println("Fehler beim Einlesen der Augenzahl!");
			ioex.printStackTrace();
		}
		augenZahl = Integer.parseInt(eingabe1);
		
		
		//Erschaffe den Würfel und Häufigkeitstabelle initialisieren
		wuerfel1 = new Wuerfel(augenZahl);
		int[] ereignisse = new int[augenZahl + 1];
		for(int i = 0; i<augenZahl+1; i++) {
			ereignisse[i] = 0;
		}
		
		
		//Würfel bis zum bitteren Ende
		for(int i = 0; i<anzahlVersuche; i++) {
			int gewürfelt = wuerfel1.wuerfelMich();
			ereignisse[gewürfelt] += 1;
		}
		
		//Gib fertiges Array zurück
		return ereignisse;
	}
	
	/**
	 * Lenkt den Programm-Ablauf möglichst UML-Konform und die Reihenfolge der Aufrufe der Methoden
	 */
	public void beginneTest() {
		berechnungen1 = new Berechnungen(anzahlVersuche);
		berechnungen1.initialisiereKontrolle();
		System.out.println(berechnungen1.ausgabeFunktion());
		System.out.println("\n\n");

	}
	
}
