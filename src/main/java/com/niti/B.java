package com.niti;

import java.util.Scanner;

public class B {
	public static void main(String args[]) {

		B b = new B();
		// read the charecter and the max amount we need to iterate to.

		System.out.println("Enter the charecter");
		Scanner scanner = new Scanner(System.in);
		char alphabet = scanner.next().charAt(0);

		System.out.println("Enter the max iterator");

		int max = scanner.nextInt();

		// output variable.
		String output = "";
		//output = b.execute(output, alphabet, max);
		b.execute(max, output, alphabet);
		System.out.println(output);
	}
	
	public void execute(int max, String output, char alphabet) {

		while(max>0) {
				output = getLine(max, output, alphabet);
				output = output + "\n";
				max = max-1;
				System.out.println(output);
		}
	}	

	public String getLine(int max, String output, char alphabet) {
		
		int prefix=0;
		output="";
		while (max>0) {
				output = getWord(output, max, alphabet, prefix);
				max = max-1;
				prefix = prefix+1;
		}
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
