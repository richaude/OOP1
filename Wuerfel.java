package wuerfeltest;
/**
 * Unabhängiger Würfel mit variabler Augenzahl, den man würfeln kann
 * @author Lukas
 * @version 2.0
 */
public class Wuerfel {
	// Variable max für die maximale Augenzahl des Würfels als int
	private int max;
	
	/**
	 * Konstruktor
	 * @param max maximale Augenzahl des Würfels
	 */
	public Wuerfel(int max) {
		// Weißt die maximale Augenzahl der Klassenvariable max zu
		this.max = max;
	}
	
	/**
	 * Würfelt zufällig eine Zahl zwischen 1 und der maximalen Augenzahl des Würfels
	 * @return gewürfelte Augen-Zahl
	 */
	public int wuerfelMich() {
		// Rechnet einen Wert zwischen 1 und der Klassenvariable max aus und gibt diesen als Int zurück, +1 hier, weil Math.random()
		// Double-Werte zw. 0 und 1, aber auch 0 erreichbar, zurückgibt.
		int rueckgabe = (int) ((Math.random() * this.max) +1);
		// Gibt den ausgerechneten Wert zurück 
		return rueckgabe;
	}

	/**
	 * gibt UML-konform die maximale Augenzahl des Würfels zurück
	 * @return Augenzahl des Würfels
	 */
	public int getMax() {
		// Gibt den Wert der Klassenvariable max zurück, dient Sicherheitsnormen
		return max;
	}
	
}
