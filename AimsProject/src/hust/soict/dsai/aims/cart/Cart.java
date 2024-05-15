package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Cart() { }

	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			System.out.println("Item is already in cart");
			return;
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " is added to cart");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " is removed from cart");
		} else {
			System.out.println("Item not found in cart");
		}
	}
	
	public float totalCost() {
		float cost = 0;
		for (Media media : itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}
