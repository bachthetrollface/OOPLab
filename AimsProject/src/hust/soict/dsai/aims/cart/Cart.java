package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
	
	public void viewCart() {
		System.out.println("Items placed in cart:");
		System.out.println("----------------------------");
		for(Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
	}
	
	public void consoleAddMedia(Store store) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		if (store.isAvailable(title, id)) {
			Media result = store.findMedia(title, id);
			addMedia(result);
		}
		else System.out.println("Item not found in store");
		scanner.close();
	}
	
	public void consoleRemoveMedia() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		Media result = new Disc(""); // blank item
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.match(title, id)) {
				result = media;
				found = true;
				break;
			}
		}
		if (found) removeMedia(result);
		else System.out.println("Item not found in cart");
		scanner.close();
	}
	
	public void consolePlayMedia() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		Media result = new Disc(""); // blank item
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.match(title, id)) {
				result = media;
				found = true;
				break;
			}
		}
		if (found) {
			if (result instanceof Disc) {
				Disc disc = (Disc) result;
				disc.play();
			}
			else System.out.println("The selected media is unplayable.");
		}
		else System.out.println("Item not found in cart");
		scanner.close();
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
