package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	private static int nbDigitalVideoDisc = 0;
	
	public DigitalVideoDisc() {
		this("", "", 0.0f, "", 0);
	}
	
	public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
		super(0, title, category, cost, director, length);
		nbDigitalVideoDisc++;
		setId(nbDigitalVideoDisc);
	}
	
	public boolean equals(DigitalVideoDisc otherDisc) {
		return (getTitle().equals(otherDisc.getTitle()) && getCategory().equals(otherDisc.getCategory()) 
				&& getDirector().equals(otherDisc.getDirector()) && getLength() == otherDisc.getLength() && getCost() == otherDisc.getCost());
	}
	
	public String toString() {
		return "DVD - " + getTitle() + " - " + getCategory() + " - " 
					+ getDirector() + " - " + getLength() + ": " + getCost() + " $";
	}
	
	public boolean isMatch(String title) {
		String keywords[] = title.split(",");
		for (String word : getTitle().split(" ")) {
			for (String keyword : keywords) {
				if (word.equalsIgnoreCase(keyword)) return true;
			}
		}
		return false;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + getTitle());
		System.out.println("DVD length: " + getLength());
	}
}
