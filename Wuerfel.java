package Würfeltest;

public class Wuerfel {
	private int max;
	
	public Wuerfel(int max) {
		this.max = max;
	}
	
	public int wuerfelMich() {
		int rueckgabe = (int) ((Math.random() * this.max) +1);
		// System.out.println(rueckgabe); 
		return rueckgabe;
	}

	
	public int getMax() {
		return max;
	}
	
}
