package wuerfeltest;

/**
 * führt alle geforderten Berechnungen durch
 * @author richard
 *
 */

public class Berechnungen {
	
	private int anzahlVersuche;
	private int[] ereignisse;
	
	/**
	 * Konstruktor
	 * @param anzahlVersuche
	 */
	public Berechnungen(int anzahlVersuche) {
		this.anzahlVersuche = anzahlVersuche;
	}
	
	/**
	 * initialisiert eine Instanz der Klasse Kontrolle und ruft an dieser die Steuerfunktion aus, um dem ereignisse Array Werte zuzuweisen.
	 * @return um dem UML konform zu bleiben, gibt es die Instanz der Kontrollklasse zurück, eigentlich wäre es schlauer, wenn da void stehen würde
	 */
	public Kontrolle initialisiereKontrolle() {
		Kontrolle kontrolle1 = new Kontrolle(anzahlVersuche);
		ereignisse = kontrolle1.steuerfunktion();
		return kontrolle1;
	}
	
	/**
	 * berechnet die relative Häufigkeit für jedes Feld des ereignisse-Arrays, außer dem Nullten. Dies geschieht für jedes Wurfergebnis nach der Formel: absolute Häufigkeit/Anzahl der Versuche
	 * @return gibt einen double Array der Länge des Würfels+1 zurück, an jeder Stelle dieses Arrays steht die entsprechende relative Häufigkeit
	 */
	public double[] relativeHaeufigkeitsberechnung() {
		double relativeHaeufigkeiten[] = new double[ereignisse.length];
		for (int i=1; i<relativeHaeufigkeiten.length; i++) {
			relativeHaeufigkeiten[i] = ((double)ereignisse[i])/anzahlVersuche;
			//auf den double zu casten ist wichtig
		}
		return relativeHaeufigkeiten;
	}
	
	/**
	 * berechnet die absoluten Fehler für jeden Wert aus dem aktuellen Feld des ereignisse-Arrays ab dem ersten Feld, nach der Formel: relative Häufigkeit/mathematische Wahrscheinlichkeit des Würfelwurfs
	 * @return gibt einen double-Array von der Länge des ereignisse-Arrays zurück, an jeder Stelle des Arrays stehen die entsprechenden absoluten Fehler für die aktuelle Zahl
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
	 * berechnet die relativen Fehler für jeden Wert aus dem aktuellen Feld des ereignisse-Arrays ab dem ersten Feld, nach der Formel: |absolute Fehler/mathematische Wahrscheinlichkeit des Würfelwurfs|
	 * @return gibt einen double-Array von der Länge des ereignisse-Arrays zurück, an jeder Stelle des Arrays stehen die entsprechenden relativen Fehler für die aktuelle Zahl
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
	 * erzeugt einen Stringbuilder, dem alle relevanten Daten möglichst übersichtlich angehängt wurden
	 * @return gibt eine textuelle Repräsentation aller Rechenergebnisse zurück. Die toString Methode wird benutzt, um dem UML treu zu bleiben und einen String (keinen StringBuilder) zurück zu geben.
	 */
	public String ausgabeFunktion() {
		if(ereignisse == null) {
			return new String("Die Augenzahl des W�rfels konnte nicht richtig umgesetzt werden..");
		}
		
		StringBuilder ausgabe = new StringBuilder();
		double[] relativeHaeufigkeiten = relativeHaeufigkeitsberechnung();
		double[] absoluteFehler = berechneAbsoluteFehler();
		double[] relativeFehler = berechneRelativeFehler();
		ausgabe.append("\n====================================================\n");
		ausgabe.append("\nResultate nach Wurfergebnissen:\n\n");
		for (int i=1; i<ereignisse.length; i++) {
			ausgabe.append("Wurfergebnis " + i + " wurde "+ ereignisse[i] + " mal geworfen. " + "\n\t" + " | relative Häufigkeit: " + relativeHaeufigkeiten[i] + "\n\t | absoluter Fehler: " + absoluteFehler[i] + "\n\t | relativer Fehler: " + relativeFehler[i]+ "\n\t | berechnete Wahrscheinlichkeit: " + 1.0/(ereignisse.length-1) + "\n");
		}
		ausgabe.append("\n====================================================\n");
		return ausgabe.toString();
	}
	

}
