package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * unabhängiger Würfel mit variabler Augenzahl
 * @author Lukas
 * @version 2.0
 */
public class Kontrolle {
	// Klassenvariablen, die eine Instanz des Würfels und eine der Berechnungen enthalten und dazu die Anzahl der Würfe in anzahlVersuche
	private Wuerfel wuerfel1;
	private Berechnungen berechnungen1;
	private int anzahlVersuche;
	
	/**
	 * Konstruktor
	 * @param anzahlVersuche Anzahl der Würfe des zu testenden Würfels
	 */
	
	public Kontrolle(int anzahlVersuche) {
		// Weißt anzahlVersuche die Anzahl der Würfe zu
		this.anzahlVersuche = anzahlVersuche;
	}
	
	
	/**
	 * Fragt nach geforderter Augenzahl, erstellt den Würfel und führt die Würfe durch, befüllt dabei ein Int-Array
	 * @return Das gefüllte Int-Array mit den absoluten Häufigkeiten
	 */
	public int[] steuerfunktion() {
		// Initialisierung, lege Eingabe-Stream  und Augen-Zahl-Variable an 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe1 = "";
		int augenZahl = 1;
		
		// Versuche die Augenzahl per Konsole einzulesen, fange Exceptions ab
		System.out.println("Bitte geben sie die maximale Augenzahl des zu Testenden Würfels ein! (Bitte realistisch bleiben)");
		try {
			eingabe1 = br.readLine();
			augenZahl = Integer.parseInt(eingabe1);
		}
		catch(IOException ioex) {
			System.out.println("Fehler beim Einlesen der Augenzahl!");
			ioex.printStackTrace();
		}
		catch(NumberFormatException nfex) {
			System.out.println("Zu große Augenzahl eingegeben!");
			nfex.printStackTrace();
		}

		
		// Unsinnige Eingabe wird abgefangen (Augenzahl -> 0)
		if(augenZahl == 0) {
			System.out.println("Ein Würfel ohne würfelbare Ereignisse macht keinen Sinn! Programm bricht ab.");
			return null;
		}
		
		
		// Erschaffe Würfelinstanz und initialisiere die Häufigkeitstabelle mit 0
		wuerfel1 = new Wuerfel(augenZahl);
		int[] ereignisse = new int[augenZahl + 1];
		for(int i = 0; i<augenZahl+1; i++) {
			ereignisse[i] = 0;
		}
		
		
		// Führe die Würfe des Würfels aus und erhöhe den Wert des Arrays an der Stelle des Ereignisses (Häufigkeitszähler)
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
		// Erzeuge ein Objekt vom Typ Berechnungen und übergebe ihm die Anzahl der Würfe
		berechnungen1 = new Berechnungen(anzahlVersuche);
		
		// Initialisiere das Berechnungen-Objekt
		berechnungen1.initialisiereKontrolle();
		
		// Gib die Inhalte der errechnete Tabellen sauber formatiert aus
		System.out.println(berechnungen1.ausgabeFunktion());
		System.out.println("\n\n");

	}
	
}
