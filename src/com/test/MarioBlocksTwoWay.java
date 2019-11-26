package com.test;

import java.util.Scanner;

public class MarioBlocksTwoWay {

	public static void main(String[] args) {
		
		
		int height = 0;
		Scanner scanner = new Scanner(System.in);
		boolean valid = false;
		while(!valid) {
			System.out.println("Enter height");
			height = scanner.nextInt();
			if(height>0 && height <=8) {
				valid = true;
			}
		}

		for(int rowCounter = 1; rowCounter <= height; rowCounter++) {
			int spaceCounter = height - rowCounter;
			int hashCounter = height - spaceCounter;
			for(int i=0; i<spaceCounter;i++) {
				System.out.print(" ");
			}
			for(int i=0;i<hashCounter;i++) {
				System.out.print("#");
			}
			System.out.print("  ");
			for(int i=0;i<hashCounter;i++) {
				System.out.print("#");
			}
			for(int i=0; i<spaceCounter;i++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
