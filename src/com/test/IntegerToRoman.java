package com.test;

import java.util.Scanner;

public class IntegerToRoman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the integer: ");
        int n = scanner.nextInt();
        System.out.println(intToRoman(n));
        scanner.close();
    }

    static String intToRoman(int n) {

        StringBuilder roman = new StringBuilder("");

        while (n != 0) {

            /*
             * Check if the number is greater than one of the roman codes
             */

            if (n >= 1000) {
                roman.append("M");
                n = n - 1000;
            } else if (n >= 900) {
                roman.append("CM");
                n = n - 900;
            }

            else if (n >= 500) {
                roman.append("D");
                n = n - 500;
            }

            else if (n >= 400) {
                roman.append("CD");
                n = n - 400;
            }

            else if (n >= 100) {
                roman.append("C");
                n = n - 100;
            } else if (n >= 90) {
                roman.append("XC");
                n = n - 90;
            }

            else if (n >= 50) {
                roman.append("L");
                n = n - 50;
            } else if (n >= 40) {
                roman.append("XL");
                n = n - 40;
            } else if (n >= 10) {
                roman.append("X");
                n = n - 10;
            } else if (n >= 9) {
                roman.append("IX");
                n = n - 9;
            } else if (n >= 5) {
                roman.append("V");
                n = n - 5;
            } else if (n >= 4) {
                roman.append("IV");
                n = n - 4;
            } else if (n >= 1) {
                roman.append("I");
                n = n - 1;
            }

            /*
             * 12 is written as XII.
             * First mod will give 2 so nothing will be appeneded
             * Then next mod will give 0. SO this logic will fail.
             */

        }

        // System.out.println(roman);

        return roman.toString();

        // This will return the String

    }
}
