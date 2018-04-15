package wuerfeltest;

/**
 * f�hrt alle geforderten Berechnungen durch
 * @author richard
 *
 */

public class Berechnungen {
	
	private int anzahlVersuche;
	private int[] ereignisse;
	
	/**
	 * Konstruktor
	 * @param anzahlVersuche Anzahl der W�rfe des zu testenden W�rfels
	 */
	public Berechnungen(int anzahlVersuche) {
		this.anzahlVersuche = anzahlVersuche;
	}
	
	/**
	 * initialisiert eine Instanz der Klasse Kontrolle und ruft an dieser die Steuerfunktion aus, um dem ereignisse Array Werte zuzuweisen.
	 * @return um dem UML konform zu bleiben, gibt es die Instanz der Kontrollklasse zur�ck, eigentlich w�re es schlauer, wenn da void stehen w�rde
	 */
	public Kontrolle initialisiereKontrolle() {
		Kontrolle kontrolle1 = new Kontrolle(anzahlVersuche);
		ereignisse = kontrolle1.steuerfunktion();
	// Debug: Works till here	
	//	for(int i = 0; i<ereignisse.length; i++) {
	//		System.out.println(ereignisse[i]);
	//	}

		return kontrolle1;
	}
	
	/**
	 * berechnet die relative H�ufigkeit f�r jedes Feld des ereignisse-Arrays, au�er dem Nullten. Dies geschieht f�r jedes Wurfergebnis nach der Formel: absolute H�ufigkeit/Anzahl der Versuche
	 * @return gibt einen double Array der L�nge des W�rfels+1 zur�ck, an jeder Stelle dieses Arrays steht die entsprechende relative H�ufigkeit
	 */
	public double[] relativeHaeufigkeitsberechnung() {
		double relativeHaeufigkeiten[] = new double[ereignisse.length];
		for (int i=1; i<relativeHaeufigkeiten.length; i++) {
			relativeHaeufigkeiten[i] = ((double)ereignisse[i])/anzahlVersuche;
		}
		return relativeHaeufigkeiten;
	}
	
	/**
	 * berechnet die absoluten Fehler f�r jeden Wert aus dem aktuellen Feld des ereignisse-Arrays ab dem ersten Feld, nach der Formel: relative H�ufigkeit/mathematische Wahrscheinlichkeit des W�rfelwurfs
	 * @return gibt einen double-Array von der L�nge des ereignisse-Arrays zur�ck, an jeder Stelle des Arrays stehen die entsprechenden absoluten Fehler f�r die aktuelle Zahl
	 */
	public double[] berechneAbsoluteFehler() {
		double absoluteFehler[] = new double[ereignisse.length];
		double pE = 1.0/(ereignisse.length-1);
		//System.out.println(pE);
		double[] hilfsvar = relativeHaeufigkeitsberechnung();
		for (int i=1; i<absoluteFehler.length; i++) {
			absoluteFehler[i] = hilfsvar[i] - pE;
		}
		return absoluteFehler;
	}
	
	/**
	 * berechnet die relativen Fehler f�r jeden Wert aus dem aktuellen Feld des ereignisse-Arrays ab dem ersten Feld, nach der Formel: |absolute Fehler/mathematische Wahrscheinlichkeit des W�rfelwurfs
	 * @return gibt einen double-Array von der L�nge des ereignisse-Arrays zur�ck, an jeder Stelle des Arrays stehen die entsprechenden relativen Fehler f�r die aktuelle Zahl
	 */
	public double[] berechneRelativeFehler() {
		double relativeFehler[] = new double[ereignisse.length];
		double pE = 1.0/(ereignisse.length-1);		
		double[] absoluteFehler = berechneAbsoluteFehler();
		for (int i=1; i<relativeFehler.length; i++) {
			relativeFehler[i] = Math.abs(absoluteFehler[i]/pE);
		}
		return relativeFehler;
	}
	
	/**
	 * erzeugt einen Stringbuilder, dem alle relevanten Daten m�glichst �bersichtlich angeh�ngt wurden
	 * @return gibt eine textuelle Repr�sentation aller Rechenergebnisse zur�ck. Die toString Methode wird benutzt, um dem UML treu zu bleiben und einen String (keinen StringBuilder) zur�ck zu geben.
	 */
	public String ausgabeFunktion() {
		StringBuilder ausgabe = new StringBuilder();
		double[] relativeHaeufigkeiten = relativeHaeufigkeitsberechnung();
		double[] absoluteFehler = berechneAbsoluteFehler();
		double[] relativeFehler = berechneRelativeFehler();
		ausgabe.append("\n====================================================\n");
		ausgabe.append("\nResultate nach Wurfergebnissen:\n\n");
		for (int i=1; i<ereignisse.length; i++) {
			ausgabe.append("Wurfergebnis: " + i + "\n\t" + " | relative H�ufigkeit: " + relativeHaeufigkeiten[i] + "\n\t | absoluter Fehler: " + absoluteFehler[i] + "\n\t | relativer Fehler: " + relativeFehler[i]+ "\n\t | berechnete Wahrscheinlichkeit: " + 1.0/(ereignisse.length-1) + "\n");
		}
		ausgabe.append("\n====================================================\n");
		return ausgabe.toString();
	}
	

}
