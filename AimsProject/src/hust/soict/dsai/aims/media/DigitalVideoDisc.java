package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	private static int nbDigitalVideoDisc = 0;
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public DigitalVideoDisc() {
		nbDigitalVideoDisc++;
		setId(nbDigitalVideoDisc);
	}
	
	boolean equals(DigitalVideoDisc otherDisc) {
		return (getTitle().equals(otherDisc.getTitle()) && getCategory().equals(otherDisc.getCategory()) 
				&& this.director.equals(otherDisc.getDirector()) && this.length == otherDisc.getLength() && getCost() == otherDisc.getCost());
	}
	
	public String toString() {
		return "DVD - " + getTitle() + " - " + getCategory() + " - " 
					+ director + " - " + length + ": " + getCost() + " $";
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
}
