package com.test;

import java.util.Scanner;

/*
 * This class has the logic to 
 * check if a given String is palindrome or not without reversing
 * the String
 */
public class Palindrome {

    public static void main(String[] args) {

        // Check if a String is palindrome or not
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String s = scanner.next();
        // Call the function
        System.out.println(palindrome(s));

    }

    public static boolean palindrome(String s) {
        if (s.isEmpty() || s.length() == 0 || s.length() == 1) {
            return true;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return true;
            else
                return false;
        }
        // How to do this
        // Start with the first and the last index
        // and keep comparing the characters
        StringBuffer sb = new StringBuffer(s);
        // get the length of the String
        int length = s.length();
        int lastIndex1, lastIndex2;
        if (length % 2 == 0) {
            lastIndex1 = (length / 2) - 1;
            lastIndex2 = (length / 2);
        } else {
            lastIndex1 = (length / 2) - 1;
            lastIndex2 = (length / 2) + 1;
        }
        int i = sb.length() - 1;
        int j = 0;
        boolean isPalindrome = true;
        while (true) {
            // We also need an additional condition to break
            // in case the middle of the String has returned.

            if (sb.charAt(i) == sb.charAt(j)) {
                if (i == lastIndex1 && j == lastIndex2) {
                    break;
                } else {
                    i--;
                    j++;
                }

            } else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;

    }

}
