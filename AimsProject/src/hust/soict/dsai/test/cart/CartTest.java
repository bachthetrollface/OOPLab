package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		
		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd2, dvd1);
		anOrder.addDigitalVideoDisc(dvd2, dvd3);
		anOrder.searchDigitalVideoDisc(0);
		anOrder.searchDigitalVideoDisc(3);
		anOrder.searchDigitalVideoDisc("lion,star");
		
//		anOrder.showCart();
//		
//		System.out.print("Total cost is: ");
//		System.out.print(anOrder.totalCost());
//		System.out.println();
		
//		anOrder.removeDigitalVideoDisc(dvd2);
//		anOrder.removeDigitalVideoDisc(dvd2);
//		anOrder.removeDigitalVideoDisc(dvd2);
//		anOrder.removeDigitalVideoDisc(dvd1);
//		anOrder.removeDigitalVideoDisc(dvd1);
//		anOrder.removeDigitalVideoDisc(dvd1); // Returns result as not found
//		// Remaining: 1 dvd2 + 2 dvd3 -> 24.95 + 2*18.99 = 62.93
//		
//		System.out.print("Total cost is: ");
//		System.out.print(anOrder.totalCost());
//		System.out.println();
		
//		System.out.println(dvd1.getCategory());
//		System.out.println(dvd1.getTitle());
//		System.out.println(dvd1.getDirector());
//		System.out.println(dvd1.getLength());
//		System.out.println(dvd1.getCost());

	}

}
