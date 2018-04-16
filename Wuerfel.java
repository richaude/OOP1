package wuerfeltest;
/**
 * Unabh�ngiger W�rfel mit variabler Augenzahl, den man w�rfeln kann
 * @author Lukas
 *
 */
public class Wuerfel {
	private int max;
	
	/**
	 * Konstruktor
	 * @param max maximale Augenzahl des W�rfels
	 */
	public Wuerfel(int max) {
		this.max = max;
	}
	
	/**
	 * W�rfelt zuf�llig eine Zahl zwischen 1 und der maximalen Augenzahl des W�rfels
	 * @return gew�rfelte Augen-Zahl
	 */
	public int wuerfelMich() {
		int rueckgabe = (int) ((Math.random() * this.max) +1);
		// System.out.println(rueckgabe); 
		return rueckgabe;
	}

	/**
	 * gibt UML-konform die maximale Augenzahl des W�rfels zur�ck
	 * @return Augenzahl des W�rfels
	 */
	public int getMax() {
		return max;
	}
	
}
