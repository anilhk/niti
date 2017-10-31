package com.niti;

public class Test {

	public static void main(String[] args) {

		Test test = new Test("A", 5);
		System.out.print(test);
	}

	private String letter;
	private int amount;

	public Test() {
		letter = " ";
		amount = 0;
	}

	public Test(String c, int amt) {
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(String c) {
		this.letter = c;
	}

	public void setAmount(int amt) {
		this.amount = amt;
	}

	@Override
	public String toString() {
		String output = "";

		char test = letter.charAt(0);
		int count=0;
	
		while(count<amount) {
			
			for (int i = 0; i < amount-count; i++) {
					output = output + (char) (test+count) + "";
			}
			output = output + " ";
			count = count + 1;
		}	
			output = output + "\n";
	
		
		return output;
	}

}
