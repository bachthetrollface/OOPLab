package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc() {
		this(0, "", "", 0.0f, "", 0, "");
	}

	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
	}
	
	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.println("This track is already added.");
			return;
		}
		else {
			tracks.add(newTrack);
			setLength(getLength() + newTrack.getLength());
			System.out.println("Track " + newTrack.getTitle() + " is added.");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			setLength(getLength() - track.getLength());
			System.out.println("Track " + track.getTitle() + " is removed.");
			return;
		}
		else System.out.println("Track is not available.");
	}
}
