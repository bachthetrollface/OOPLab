package hust.soict.dsai.garbage;

import java.util.Random;

public class GarbageCreator {

	public static void main(String[] args) throws Exception {
		long startTime, endTime;
		
		Random r = new Random(123);
		String outputString = "";
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) outputString += r.nextInt(2);

		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
