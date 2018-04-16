package wuerfeltest;
/**
 * Unabhängiger Würfel mit variabler Augenzahl, den man würfeln kann
 * @author Lukas
 *
 */
public class Wuerfel {
	private int max;
	
	/**
	 * Konstruktor
	 * @param max maximale Augenzahl des Würfels
	 */
	public Wuerfel(int max) {
		this.max = max;
	}
	
	/**
	 * Würfelt zufällig eine Zahl zwischen 1 und der maximalen Augenzahl des Würfels
	 * @return gewürfelte Augen-Zahl
	 */
	public int wuerfelMich() {
		int rueckgabe = (int) ((Math.random() * this.max) +1);
		// System.out.println(rueckgabe); 
		return rueckgabe;
	}

	/**
	 * gibt UML-konform die maximale Augenzahl des Würfels zurück
	 * @return Augenzahl des Würfels
	 */
	public int getMax() {
		return max;
	}
	
}
