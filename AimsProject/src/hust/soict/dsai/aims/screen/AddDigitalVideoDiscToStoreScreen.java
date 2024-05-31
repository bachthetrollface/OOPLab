package hust.soict.dsai.aims.screen;

import java.io.IOException;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setVisible(true);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("fxml/AddItemToStore.fxml"));
					AddDVDScreenController controller = new AddDVDScreenController(store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});	
	}

}
