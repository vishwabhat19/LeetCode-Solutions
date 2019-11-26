package com.test;

import java.util.Scanner;

public class MarioBlocks {

	public static void main(String[] args) {
		int height = 0;
		
		Scanner scanner = new Scanner(System.in);
		boolean valid = false;
		while(!valid) {
			System.out.println("Enter a number between 1- 8: ");
			height = scanner.nextInt();
			if(height > 0 && height <=8) {
				valid = true;
			}
		}
		
		
		for(int rowIterator = 1; rowIterator <= height; rowIterator++) {
			
			int spaceCounter = height - rowIterator;
			int hashCounter = height - spaceCounter;
			for(int i = 0; i < spaceCounter; i++) {
				System.out.print(" ");
			}
			for(int j = 0; j < hashCounter; j++) {
				System.out.print("#");
			}
			System.out.println("");
		}

	}

}
