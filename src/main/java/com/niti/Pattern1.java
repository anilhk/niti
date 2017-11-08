package com.niti;

import java.util.Scanner;

/*
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
1 2 3 4 5 6 7
*/

public class Pattern1 {

	public static void main(String[] args) {

		Pattern1 pattern1 = new Pattern1();
		Scanner scanner = new Scanner(System.in);
		int max = scanner.nextInt();
		pattern1.execute(max);
	}

	private void execute(int max) {

		for(int i=1;i<=max;i++) {
			
			for (int j=1;j<=i;j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	
}
