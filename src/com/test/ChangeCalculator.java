package com.test;

import java.util.Scanner;

public class ChangeCalculator {

	public static void main(String[] args) {
		boolean valid = false;
		double change = 0;
		while(!valid) {
			System.out.println("Enter the amount: ");
			Scanner scanner = new Scanner(System.in);
			change = scanner.nextDouble();
			if(change>0) {
				valid = true;
			}
		}
		int coins = 0;
		while(change>=0.25) {
			change = change - 0.25;
			coins++;
		}
		while(change>=0.10) {
			change = change - 0-10;
			coins++;
		}
		while(change >=0.05) {
			change = change - 0.05;
			coins++;
		}
		if(change >0) { 
			coins = coins + (int)(change/0.01);
		}
		System.out.println("No. of coins: "+coins);

	}

}
