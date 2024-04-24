
public class StoreTest {

	public static void main(String[] args) {
		Store firstStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		
		firstStore.addDVD(dvd1);
		firstStore.addDVD(dvd2);
		firstStore.addDVD(dvd3);
		firstStore.addDVD(dvd2);
		firstStore.addDVD(dvd3);
		
		firstStore.removeDVD("Star Wars");
		firstStore.removeDVD(3);
		firstStore.removeDVD(dvd2);

	}

}
