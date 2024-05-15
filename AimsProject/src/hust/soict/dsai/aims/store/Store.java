package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {

	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public Store() { }
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("Item is already in store");
			return;
		} else {
			itemsInStore.add(media);
			System.out.println(media.getTitle() + " is added to store");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println(media.getTitle() + " is removed from store");
		} else {
			System.out.println("Item not found in store");
		}
	}
}