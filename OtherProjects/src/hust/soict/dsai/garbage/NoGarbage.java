package hust.soict.dsai.garbage;

import java.util.Random;

public class NoGarbage {

	public static void main(String[] args) {
		long startTime, endTime;
		StringBuilder sb = new StringBuilder();
		
		Random r = new Random(123);
		String outputString = "";
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) sb.append(r.nextInt(2));

		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
