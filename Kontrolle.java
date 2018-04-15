package Würfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kontrolle {
	private Wuerfel wuerfel1;
	private Berechnungen berechnungen1;
	private int anzahlVersuche;
	
	public Kontrolle(int anzahlVersuche) {
		this.anzahlVersuche = anzahlVersuche;
	}
	
	
	
	public int[] steuerfunktion() {
		// Initialisierung
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe1 = ""; String eingabe2 = "";
		int augenZahl;
		
		// Augenzahl einlesen
		System.out.println("Bitte geben sie die Augenzahl des zu Testenden Würfels ein! (Bitte realistisch bleiben)");
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
	public void beginneTest() {
	
		berechnungen1.initialisiereKontrolle();
		// Soll Kontrolle instanziieren, um mittels SteuerFunktion das Array zu befüllen
	}
	
}
