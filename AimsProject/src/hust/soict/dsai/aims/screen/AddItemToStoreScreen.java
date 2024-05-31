package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {

	private Store store;
	
	public AddItemToStoreScreen(Store store) {
		super();
		this.store = store;
	}
	
	protected Store getStore() {
		return store;
	}
}
