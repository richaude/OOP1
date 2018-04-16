package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Einsprungs-Klasse f�r die virtuelle Maschine
 * @author Lukas
 * @version 2.0
 */
public class Main {
	/**
	 * Fragt nach Anzahl der W�rfe des zu testenden W�rfels, erzeugt eine neue Kontrolle-Instanz und beginnt den Test
	 * @param args Parameter der Eingabeaufforderung werden ignoriert
	 */
	public static void main(String[] args) {
		// F�hre Abbruchvariable ein
		boolean b = true;
		
		// Beginne den Test in einer mind. 1 mal durchgef�hrten Schleife
		do {
			
			// Versuchsanzahl einlesen und Kontrolle initialisieren
				// Erzeuge Eingabe-Stream
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				// Initialisiere Werte, damit sie nicht auf null zeigen
				String eingabe = new String("");
				int versuchsZahl = 1;
				
				// Frage nach gewollter Anzahl der W�rfe
				System.out.println("Bitte geben sie nun die Anzahl der W�rfe des W�rfels ein!");
				try {
					
					// Lese Anzahl der W�rfe ein und parse sie auf den Int-Datentyp
					eingabe = br.readLine();
					versuchsZahl = Integer.parseInt(eingabe);
				}
				catch(IOException ioex) {
					// Gib Fehlermeldung bei Input-/Output-Problemen aus
					System.out.println("Fehler beim Einlesen der Versuchsanzahl!");
					ioex.printStackTrace();
				}
				catch(NumberFormatException nfex) {
					// Gib Fehlermeldung bei Problemen mit der Darstellung der Zahlen, hier Anzahl der W�rfe, aus
					System.out.println("Zu gro�e Zahl eingegeben!");
					nfex.printStackTrace();
				}
			
			//Abfangen von unsinnigen Eingaben (Wurf-Anzahl -> 0)
			if(versuchsZahl == 0) {
				System.out.println("Nicht zu W�rfeln macht bei einem W�rfeltest keinen Sinn! Versuch's nochmal!");
				return;
			}
		
			// Initiiere Kontrolle und �berlasse beginneTest() alles weitere
			Kontrolle k = new Kontrolle(versuchsZahl);
			k.beginneTest();
		
			// Frage nach dem Weiterausf�hren des Programms f�r einen neuen Test
			System.out.println("Wollen sie einen weiteren Test durchf�hren? (Y/N)");
			String s = new String("");
		
			try {
				s = br.readLine().toLowerCase();
			}
			catch(IOException ioex) {
				System.out.println("Nicht lesbare Eingabe");
				ioex.printStackTrace();
			}
			
			// Wenn n eingegeben wird, beende das Programm �ber die Abbruchbedingung der Do-While-Schleife, sonst fahre fort
			if (s.equals("n")) {
				b = false;
				System.out.println("\nBis zum n�chsten Mal!");
			}
			
			// Schaffe anschaulich Platz zum n�chsten Test
			System.out.println("\n\n\n\n\n\n\n");
		}
		while(b);
	}

}
