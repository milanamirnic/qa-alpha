package practice;

public class Main {

	public static void main(String[] args) {

		Test test = new Test();
		test.myFirstMethod();
		test.checkNumber(5);
		test.checkNumber(15);
		test.practicingForLoop(3, 8);
		test.evenOdd(3);
		test.evenOdd(4);
		test.sum(17,23);
		int z = test.sum(17,23);
		System.out.println(z);
		
		int[] arr = { 5, 1, 9, 24 };
		test.sortDescending(arr);
	

	}

}
