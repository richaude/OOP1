package wuerfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Einsprungs-Klasse f�r die virtuelle Maschine
 * @author Lukas
 *
 */
public class Main {
	/**
	 * Fragt nach Anzahl der W�rfe des zu testenden W�rfels, erzeugt eine neue Kontrolle-Instanz und beginnt den Test
	 * @param args Parameter der Eingabeaufforderung werden ignoriert
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = true;
		do {
			//Versuchsanzahl einlesen und Kontrolle initialisieren
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String eingabe = new String("");
			int versuchsZahl = 1;
			System.out.println("Bitte geben sie nun die Anzahl der W�rfe des W�rfels ein!");
			try {
				eingabe = br.readLine();
				versuchsZahl = Integer.parseInt(eingabe);
			}
			catch(IOException ioex) {
				System.out.println("Fehler beim Einlesen der Versuchsanzahl!");
				ioex.printStackTrace();
			}
			catch(NumberFormatException nfex) {
				System.out.println("Zu gro�e Zahl eingegeben!");
				nfex.printStackTrace();
			}
			
			//Abfangen von Bullshit
			if(versuchsZahl == 0) {
				System.out.println("Nicht zu W�rfeln macht bei einem W�rfeltest keinen Sinn! Versuch's nochmal!");
				return;
			}
		
			// Initiiere Kontrolle und � berlasse beginneTest() alles weitere
			Kontrolle k = new Kontrolle(versuchsZahl);
			k.beginneTest();
		
			// Neuer Test?
			System.out.println("Wollen sie einen weiteren Test durchf�hren? (Y/N)");
			String s = new String("");
		
			try {
				s = br.readLine().toLowerCase();
			}
			catch(IOException ioex) {
				System.out.println("Nicht lesbare Eingabe");
				ioex.printStackTrace();
			}
			if (s.equals("n")) {
				b = false;
				System.out.println("\nBis zum n�chsten Mal!");
			}
			System.out.println("\n\n\n\n");
		}
		while(b);
	}

}
