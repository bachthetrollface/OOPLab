package hust.soict.dsai.aims.media;

public class Track implements Playable {

	private String title;
	private int length;
	
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
	
	public void play() {
		System.out.println("Playing track: " + getTitle());
		System.out.println("Track length: " + getLength());
	}
	
	public boolean equals(Object other) {
		if (other instanceof Track) {
			Track otherTrack = (Track) other;
			return (this.title.equals(otherTrack.getTitle()) 
					&& this.length == otherTrack.getLength());
		} else return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title);
		sb.append(" - ");
		sb.append(length);
		sb.append(" minutes");
		return sb.toString();
	}
}
