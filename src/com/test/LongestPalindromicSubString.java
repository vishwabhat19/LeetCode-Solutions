package com.test;

import java.util.Scanner;

/*
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Input: "cbbd"
Output: "bb"
 */

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = scanner.next();
        //print out all the substrings
        scanner.close();
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        /*
         * Check for empty String
         */

        // There are two types of palindromes
        /*
         * aba - This is with one center
         * abba - This is with two centers
         * The thing to do is imagine that each letter is a center and start moving towards the left and
         * right and stop if you reach the end indices or if you get a character which is not a palindrome
         * For this have left index, right index and it should move one step to left and right
         * Check if each character is a center of a palindrome and if yes for how long and record the length
         */

        /*
         * Looks like I have not handled empty String and I need to do this.
         * How do I do it?
         * If empty String
         */

        if (null == s || s == "" || s.isEmpty())
            return "";


        String longestPalindrome = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            // This is for checking the palindromes with one character at the center

            String temp = expand(i, i, s);
            if (temp.length() > longestPalindrome.length())
                longestPalindrome = temp;
            // This is for checking the palindrome with two characters at the center
            temp = expand(i, i + 1, s);
            if (temp.length() > longestPalindrome.length())
                longestPalindrome = temp;
        }

        return longestPalindrome;
    }

    static String expand(int left, int right, String s) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            /*
             * This means that the substring is still a palindrome and that it has still
             * not reached the end of the limits
             */
            left--;
            right++;
        }
        /*
         * If control come here it means that palindrome has ended.
         * Now record the length of the current palindrome
         */
        return s.substring(left + 1, right);
    }

    public static void printSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                System.out.println(s.substring(i, j));
                // For each substring check if it is a palindrome
                // If it is a palindrome store it in a variable
            }
        }
    }

}
