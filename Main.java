package W�rfeltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Versuchsanzahl einlesen und Kontrolle initialisieren
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eingabe = new String("");
		System.out.println("Bitte geben sie nun die Anzahl der W�rfe des W�rfels ein!");
		try {
			eingabe = br.readLine();
		}
		catch(IOException ioex) {
			System.out.println("Fehler beim Einlesen der Versuchsanzahl!");
			ioex.printStackTrace();
		}
		int versuchsZahl = Integer.parseInt(eingabe);
		Kontrolle k = new Kontrolle(versuchsZahl);
		
		// �berlasse beginneTest() alles weitere
		k.beginneTest();
	}

}
