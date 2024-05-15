package hust.soict.dsai.aims.media;

public class Track {

	private String title;
	private int length;
	
	public Track() {
		this("", 0);
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	public boolean equals(Track otherTrack) {
		return (this.title.equals(otherTrack.getTitle()) && this.length == otherTrack.getLength());
	}
}
