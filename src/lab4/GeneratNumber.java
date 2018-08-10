package lab4;

import java.util.Random;

public class GeneratNumber {
	 Random generator = new Random();
	int number;
	public GeneratNumber(int number) {
		 this.number = number;
	}
	public int gn() {
		int i = generator.nextInt(number);
	    return i;
	}
}
