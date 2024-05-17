package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Disc;
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
	
	public boolean isAvailable(String title, int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.match(title, id)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public Media findMedia(String title, int id) {
		Media result = new Disc("");
		for (Media media : itemsOrdered) {
			if (media.match(title, id)) {
				result = media;
				break;
			}
		}
		return result;
	}
	
	public float totalCost() {
		float cost = 0;
		for (Media media : itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
	public void viewCart() {
		System.out.println("Items placed in cart:");
		System.out.println("----------------------------");
		for(Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
	}
	
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void clear() {
		itemsOrdered.clear();
	}
}
