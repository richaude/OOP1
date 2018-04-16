package wuerfeltest;
/**
 * Unabh�ngiger W�rfel mit variabler Augenzahl, den man w�rfeln kann
 * @author Lukas
 * @version 2.0
 */
public class Wuerfel {
	// Variable max f�r die maximale Augenzahl des W�rfels als int
	private int max;
	
	/**
	 * Konstruktor
	 * @param max maximale Augenzahl des W�rfels
	 */
	public Wuerfel(int max) {
		// Wei�t die maximale Augenzahl der Klassenvariable max zu
		this.max = max;
	}
	
	/**
	 * W�rfelt zuf�llig eine Zahl zwischen 1 und der maximalen Augenzahl des W�rfels
	 * @return gew�rfelte Augen-Zahl
	 */
	public int wuerfelMich() {
		// Rechnet einen Wert zwischen 1 und der Klassenvariable max aus und gibt diesen als Int zur�ck, +1 hier, weil Math.random()
		// Double-Werte zw. 0 und 1, aber auch 0 erreichbar, zur�ckgibt.
		int rueckgabe = (int) ((Math.random() * this.max) +1);
		// Gibt den ausgerechneten Wert zur�ck 
		return rueckgabe;
	}

	/**
	 * gibt UML-konform die maximale Augenzahl des W�rfels zur�ck
	 * @return Augenzahl des W�rfels
	 */
	public int getMax() {
		// Gibt den Wert der Klassenvariable max zur�ck, dient Sicherheitsnormen
		return max;
	}
	
}
