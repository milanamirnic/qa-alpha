package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

	String text = "Hello world!"; // variable
	int x = 1;

	public void myFirstMethod() {

		System.out.println(text);

	}

	public void checkNumber(int num) {
		if (num < 10) {
			System.out.println(num + " is less than 10");
		} else {
			System.out.println(num + " is greater or equal to 10");
		}
	}

	public void practicingForLoop(int x, int y) {
		for (int i = x; i <= y; i++) {
			System.out.println(i);
		}
	}

	public void evenOdd(int n) {
		if (n % 2 == 0) {
			System.out.println(n + " is even number");
		} else {
			System.out.println(n + " is odd number");

		}
	}

	public int sum(int x, int y) {
		return x + y;

	}

	protected void enterMark() {
		Scanner scanner = new Scanner(System.in);
		String ocjena;
		do {
			System.out.println("Molim unesite validnu ocjenu:");
			System.out.println("---------------------------");
			ocjena = scanner.nextLine();
		} while (!ocjena.equals("1") && !ocjena.equals("2") && !ocjena.equals("3") && !ocjena.equals("4")
				&& !ocjena.equals("5"));
		System.out.println("-----------------");
		System.out.println("Odlicno, ocjena je " + ocjena);

	}

	public static void sortDescending(int[] array) {
		Arrays.sort(array);
		array = reverse(array);
		System.out.println("Descending order: " + Arrays.toString(array));
	}
	
	public static int[] reverse(int[] array) {
		int[] reversed = new int[array.length];
		
		for (int i = 0; i < array.length; i++) { 
			int current = array[i]; 
			reversed[array.length - 1 - i] = current;
		}
		
		return reversed;
	}


}
