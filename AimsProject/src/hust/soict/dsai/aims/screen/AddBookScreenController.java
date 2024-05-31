package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookScreenController {
	
	private Store store;
    @FXML private TextField tfTitle;
    @FXML private TextField tfCategory;
    @FXML private TextField tfCost;
    @FXML private TextField tfAuthors;
    @FXML private Button btnAdd;
    
    public AddBookScreenController(Store store) {
    	this.store = store;
    }

    @FXML
    void btnAddPressed(ActionEvent event) {
    	Book newBook = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
    	String[] authors = tfAuthors.getText().split(",");
    	if (authors.length > 0) {
    		for (String author : authors) {
    			newBook.addAuthor(author);
    		}
    	}
    	store.addMedia(newBook);
    }

}

