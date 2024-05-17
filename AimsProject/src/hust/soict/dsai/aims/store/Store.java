package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.media.*;

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
	
	public void viewStore() {
		System.out.println("Items available in store:");
		System.out.println("----------------------------");
		for(Media media : itemsInStore) {
			System.out.println(media.toString());
		}
	}
	
	public boolean isAvailable(String title, int id) {
		boolean found = false;
		for (Media media : itemsInStore) {
			if (media.match(title, id)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public Media findMedia(String title, int id) {
		Media result = new Disc("");
		for (Media media : itemsInStore) {
			if (media.match(title, id)) {
				result = media;
				break;
			}
		}
		return result;
	}
	
	public void consoleAddMedia() {
		Scanner scanner = new Scanner(System.in);
		Media newMedia;
		String[] info;
		System.out.println("Enter details of media in one of the following format:");
		System.out.println("Book,Title,Category,Cost");
		System.out.println("CD,Title,Category,Cost,Director,Artist");
		System.out.println("DVD,Title,Category,Cost,Director,Length");
		while (true) {
			System.out.println("Type \"exit\" to return to previous menu.");
			String input = scanner.nextLine();
			
			if (input.equals("exit")) {
				scanner.close();
				return;
			}
			
			info = input.split(",");
			switch(info[0]) {
			case "Book":
				newMedia = new Book(info[1], info[2], Float.parseFloat(info[3]));
				break;
			case "DVD":
				newMedia = new DigitalVideoDisc(info[1], info[2], Float.parseFloat(info[3]), info[4], Integer.parseInt(info[5]));
				break;
			case "CD":
				newMedia = new CompactDisc(info[1], info[2], Float.parseFloat(info[3]), info[4], info[5]);
				break;
			default:
				System.out.println("Invalid format! Please type again.");
				continue;
			}
			break;
		}
		
		addMedia(newMedia);
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
		for (Media media : itemsInStore) {
			if (media.match(title, id)) {
				result = media;
				found = true;
				break;
			}
		}
		if (found) removeMedia(result);
		else System.out.println("Item not found in store");
		scanner.close();
	}
	
	public void consoleViewMediaDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the title of the media:");
		String title = scanner.nextLine();
		System.out.println("Enter the ID of the media:");
		int id = scanner.nextInt();
		Media result = new Disc(""); // blank item
		boolean found = false;
		for (Media media : itemsInStore) {
			if (media.match(title, id)) {
				result = media;
				found = true;
				break;
			}
		}
		if (found) result.showDetails();
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
		for (Media media : itemsInStore) {
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
		else System.out.println("Item not found in store");
		scanner.close();
	}
}