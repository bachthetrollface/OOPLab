package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	public Store store = new Store();
	public Cart anOrder = new Cart();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		showMenu(scanner);
		
		
		
		scanner.close();
	}
	
	public static void showMenu(Scanner scanner) {
		while(true) {
			System.out.println("AIMS: ");
			System.out.println("----------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1: 
				storeMenu(scanner);
				break;
			case 2:
				//add/remove media from store
				break;
			case 3:
				cartMenu(scanner);
				break;
			}
			if (input == 0) break;
		}
	}
	
	public static void storeMenu(Scanner scanner) {
		while(true) {
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. See a media's details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1:
				// see details
				break;
			case 2:
				// add media
				break;
			case 3:
				//play media
				break;
			case 4:
				cartMenu(scanner);
				break;
			}
			if (input == 0) break;
		}
	}
	
	public static void mediaDetailsMenu(Scanner scanner) {
		while(true) {
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play"); //if is Disc
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1:
				// add to cart
				break;
			case 2:
				// play if is Disc
				break;
			}
			if (input == 0) break;
		}
	}
	
	public static void cartMenu(Scanner scanner) {
		while(true) {
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1:
				// filter medias
				break;
			case 2:
				// sort medias in cart
				break;
			case 3:
				// remove media
				break;
			case 4:
				//play media
				break;
			case 5:
				System.out.println("An order is created.");
				//clear cart
				break;
			}
			if (input == 0) break;
		}
	}
}