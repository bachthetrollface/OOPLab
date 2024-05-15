package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Cart() {
		
	}

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
	
//	public float totalCost() {
//		float cost = 0;
//		for (int i = 0; i < qtyOrdered; i++) {
//			cost += itemsOrdered[i].getCost();
//		}
//		return cost;
//	}
//	
//	public void showDiscs(DigitalVideoDisc dvds[], int count) {
//		for (int i = 0; i < count; i++) {
//			System.out.print(i+1);
//			System.out.print(". ");
//			System.out.println(dvds[i].toString());
//		}
//	}
//	
//	public void showCart() {
//		System.out.println("***********************CART***********************");
//		System.out.println("Ordered Items:");
//		showDiscs(itemsOrdered, qtyOrdered);
//		System.out.println("Total cost: " + totalCost());
//		System.out.println("**************************************************");
//	}
//	
//	public void searchDigitalVideoDisc(int id) {
//		DigitalVideoDisc foundDVD;
//		for (int i = 0; i < qtyOrdered; i++) {
//			if (itemsOrdered[i].getId() == id) {
//				foundDVD = itemsOrdered[i];
//				System.out.println("Found DVD: " + foundDVD.toString());
//				return;
//			}
//		}
//		System.out.println("DVD not found.");
//	}
//	
//	public void searchDigitalVideoDisc(String title) {
//		DigitalVideoDisc foundDVDs[] = new DigitalVideoDisc[qtyOrdered];
//		int count = 0;
//		for (int i = 0; i < qtyOrdered; i++) {
//			if (itemsOrdered[i].isMatch(title)) {
//				foundDVDs[count] = itemsOrdered[i];
//				count++;
//			}
//		}
//		if (count == 0) System.out.println("No matching DVD was found in the cart.");
//		else {
//			System.out.println("Matching DVD(s) found in the cart:");
//			showDiscs(foundDVDs, count);
//		}
//	}
}
