package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Einsprungs-Klasse für die virtuelle Maschine
 * @author Lukas
 * @version 2.0
 */
public class Main {
	/**
	 * Fragt nach Anzahl der Würfe des zu testenden Würfels, erzeugt eine neue Kontrolle-Instanz und beginnt den Test
	 * @param args Parameter der Eingabeaufforderung werden ignoriert
	 */
	public static void main(String[] args) {
		// Führe Abbruchvariable ein
		boolean b = true;
		
		// Beginne den Test in einer mind. 1 mal durchgeführten Schleife
		do {
			
			// Versuchsanzahl einlesen und Kontrolle initialisieren
				// Erzeuge Eingabe-Stream
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				// Initialisiere Werte, damit sie nicht auf null zeigen
				String eingabe = new String("");
				int versuchsZahl = 1;
				
				// Frage nach gewollter Anzahl der Würfe
				System.out.println("Bitte geben sie nun die Anzahl der Würfe des Würfels ein!");
				try {
					
					// Lese Anzahl der Würfe ein und parse sie auf den Int-Datentyp
					eingabe = br.readLine();
					versuchsZahl = Integer.parseInt(eingabe);
				}
				catch(IOException ioex) {
					// Gib Fehlermeldung bei Input-/Output-Problemen aus
					System.out.println("Fehler beim Einlesen der Versuchsanzahl!");
					ioex.printStackTrace();
				}
				catch(NumberFormatException nfex) {
					// Gib Fehlermeldung bei Problemen mit der Darstellung der Zahlen, hier Anzahl der Würfe, aus
					System.out.println("Zu große Zahl eingegeben!");
					nfex.printStackTrace();
				}
			
			//Abfangen von unsinnigen Eingaben (Wurf-Anzahl -> 0)
			if(versuchsZahl == 0) {
				System.out.println("Nicht zu Würfeln macht bei einem Würfeltest keinen Sinn! Versuch's nochmal!");
				return;
			}
		
			// Initiiere Kontrolle und überlasse beginneTest() alles weitere
			Kontrolle k = new Kontrolle(versuchsZahl);
			k.beginneTest();
		
			// Frage nach dem Weiterausführen des Programms für einen neuen Test
			System.out.println("Wollen sie einen weiteren Test durchführen? (Y/N)");
			String s = new String("");
		
			try {
				s = br.readLine().toLowerCase();
			}
			catch(IOException ioex) {
				System.out.println("Nicht lesbare Eingabe");
				ioex.printStackTrace();
			}
			
			// Wenn n eingegeben wird, beende das Programm über die Abbruchbedingung der Do-While-Schleife, sonst fahre fort
			if (s.equals("n")) {
				b = false;
				System.out.println("\nBis zum nächsten Mal!");
			}
			
			// Schaffe anschaulich Platz zum nächsten Test
			System.out.println("\n\n\n\n\n\n\n");
		}
		while(b);
	}

}
