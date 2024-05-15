package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String director, int length) {
		super(title, director, length);
	}
	
	public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
		super(title, category, cost, director, length);
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
