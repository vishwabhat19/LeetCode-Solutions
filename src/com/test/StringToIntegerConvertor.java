package com.test;

import java.util.Scanner;

public class StringToIntegerConvertor {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String s = scanner.next();
		System.out.println(myAtoi(s));
		scanner.close();
	}
	
	public static int myAtoi(String s) {
		int returnNumber = 0;
		
		
		
		s = s.trim();
		if(s.isEmpty()||s==""||null==s) {
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		if(s.charAt(index)=='+' || s.charAt(index)=='-') {
			sb.append(s.charAt(index));
			index++;
		}
		if(index>=s.length()) return 0;
		if(index<s.length() && Character.isDigit(s.charAt(index))) {
			/*
			 * This is flow if the Character is a digit
			 * Loop through the String and then keep adding each character 
			 * to the StringBuilder 
			 */
			while(index<s.length() && Character.isDigit(s.charAt(index))) {
				sb.append(s.charAt(index));
				index++;
			}
			
		}
		else if(index<s.length() && !Character.isDigit(s.charAt(index))) {
			return 0;
		}
		
		try {
			returnNumber = Integer.parseInt(sb.toString());
		}
		catch(NumberFormatException e) {
			if(sb.charAt(0)=='-') {
				return -2147483648;
			}
		
			else return (2147483647);
		}
		
		return returnNumber;
		
	}

}
