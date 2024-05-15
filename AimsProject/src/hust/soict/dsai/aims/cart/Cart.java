package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public Cart() {
		this.qtyOrdered = 0;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			return;
		}
		
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		System.out.println("The \"" + disc.getTitle() + "\" disc has been added");
		
		if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
			System.out.println("The cart is almost full");
		}
		else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//		for (DigitalVideoDisc dvd : dvdList) addDigitalVideoDisc(dvd);
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
		for (DigitalVideoDisc dvd: dvds) addDigitalVideoDisc(dvd);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean hasRemoved = false;
		if (qtyOrdered == 0) {
			System.out.println("The cart is empty");
			return;
		}
		
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				for (int j = i+1; j < qtyOrdered; j++) {
					itemsOrdered[i] = itemsOrdered[j];
					i++;
				}
				hasRemoved = true;
				qtyOrdered--;
				System.out.println("The \"" + disc.getTitle() + "\" disc is removed from cart");
				break;
			}
		}
		if (!hasRemoved) System.out.println("The \"" + disc.getTitle() + "\" disc is not found in the cart");
	}
	
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	
	public void showDiscs(DigitalVideoDisc dvds[], int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(i+1);
			System.out.print(". ");
			System.out.println(dvds[i].toString());
		}
	}
	
	public void showCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		showDiscs(itemsOrdered, qtyOrdered);
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}
	
	public void searchDigitalVideoDisc(int id) {
		DigitalVideoDisc foundDVD;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				foundDVD = itemsOrdered[i];
				System.out.println("Found DVD: " + foundDVD.toString());
				return;
			}
		}
		System.out.println("DVD not found.");
	}
	
	public void searchDigitalVideoDisc(String title) {
		DigitalVideoDisc foundDVDs[] = new DigitalVideoDisc[qtyOrdered];
		int count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				foundDVDs[count] = itemsOrdered[i];
				count++;
			}
		}
		if (count == 0) System.out.println("No matching DVD was found in the cart.");
		else {
			System.out.println("Matching DVD(s) found in the cart:");
			showDiscs(foundDVDs, count);
		}
	}
}
