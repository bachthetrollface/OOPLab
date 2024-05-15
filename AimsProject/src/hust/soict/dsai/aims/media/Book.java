package hust.soict.dsai.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author is already added.");
			return;
		}
		else {
			authors.add(authorName);
			System.out.println("Author " + authorName + " is added.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName + " is removed.");
			return;
		}
		else System.out.println("Author is not available.");
	}
	
}
