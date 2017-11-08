package com.niti;

import java.util.Scanner;

public class A {
	public static void main(String args[]) {

		A a = new A();
		// read the charecter and the max amount we need to iterate to.

		System.out.println("Enter the charecter");
		Scanner scanner = new Scanner(System.in);
		char alphabet = scanner.next().charAt(0);

		System.out.println("Enter the max iterator");

		int max = scanner.nextInt();

		// output variable.
		String output = "";
		output = a.execute(output, alphabet, max);
		System.out.println(output);
	}
	
	public String execute(String output, char alphabet, int max) {
		int counter = 0;

		do {
			output = getLine(output, alphabet, max);
			output = output + "\n";
			max = max-1;
		} while (max>counter);
	return output;
	}

	public String getLine(String output, char alphabet, int max) {
		int prefix = 0;


			do {
				output = addSpacetoWord(getWord(output, max, alphabet, prefix), max);
				max = max - 1;
				prefix = prefix + 1;
			} while (max > 0);
			return output;
		}
	

	public String getWord(String output, int max, char alphabet, int prefix) {

		for (int i = 0; i < max; i++) {
			output = output + (char) (alphabet + prefix);
		}
		return output;
	}

	public String addSpacetoWord(String output, int max) {
		if (max == 1) {
			return output;
		} else {
			return output = output + " ";
		}
	}

}