package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	public static Store store = new Store();
	
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Scanner scanner = new Scanner(System.in);
		showMenu(scanner, anOrder);
		scanner.close();
	}
	
	public static void showMenu(Scanner scanner, Cart cart) {
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
				storeMenu(scanner, cart);
				break;
			case 2:
				updateStore(scanner);
				break;
			case 3:
				cartMenu(scanner, cart);
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
			if (input == 0) break;
		}
	}
	
	public static void storeMenu(Scanner scanner, Cart cart) {
		while(true) {
			store.viewStore();
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
				store.consoleViewMediaDetails();
				break;
			case 2:
				cart.consoleAddMedia(store);
				break;
			case 3:
				store.consolePlayMedia();
				break;
			case 4:
				cartMenu(scanner, cart);
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
			if (input == 0) break;
		}
	}
	
	public static void mediaDetailsMenu(Scanner scanner, Cart cart, Media media) {
		media.showDetails();
		System.out.println("Options: ");
		System.out.println("----------------------------------");
		System.out.println("1. Add to cart");
		if(media instanceof Playable) {
			System.out.println("2. Play");
		}
		System.out.println("0. Back");
		System.out.println("----------------------------------");
		if(media instanceof Disc) System.out.println("Please choose a number: 0-1");
		else System.out.println("Please choose a number: 0-1-2");
		while(true) {
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1:
				cart.addMedia(media);
				System.out.println(media.getTitle() + " is added to cart.");
				break;
			case 2:
				if(media instanceof Playable) {
					Playable disc = (Playable) media;
					disc.play();
					break;
				}
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
			if (input == 0) break;
		}
	}
	
	public static void cartMenu(Scanner scanner, Cart cart) {
		while(true) {
			cart.viewCart();
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
				sortingOptions(scanner, cart);
				break;
			case 3:
				cart.consoleRemoveMedia();
				break;
			case 4:
				cart.consolePlayMedia();
				break;
			case 5:
				System.out.println("An order is created.");
				cart.clear();
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
			if (input == 0) break;
		}
	}
	
	public static void sortingOptions(Scanner scanner, Cart cart) {
		System.out.println("Please choose ordering rule:");
		System.out.println("(Note: The remaining rule will be used as secondary rule)");
		System.out.println("1. Sort ascending by title");
		System.out.println("2. Sort descending by cost");
		System.out.println("0. Back");
		while (true) {
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1:
				cart.sortByTitleCost();
				System.out.println("Cart sorted by title.");
				break;
			case 2:
				cart.sortByCostTitle();
				System.out.println("Cart sorted by cost.");
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
				continue;
			}
			break;
		}
	}
	
	public static void updateStore(Scanner scanner) {
		while (true) {
			store.viewStore();
			System.out.println("Options: ");
			System.out.println("----------------------------------");
			System.out.println("1. Add media to store");
			System.out.println("2. Remove media from store");
			System.out.println("0. Back");
			System.out.println("----------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			int input = scanner.nextInt();
			switch(input) {
			case 0: break;
			case 1:
				store.consoleAddMedia();
				break;
			case 2:
				store.consoleRemoveMedia();
				break;
			default:
				System.out.println("Incorrect option! Please choose again:");
			}
			if(input == 0) break;
		}
	}
}