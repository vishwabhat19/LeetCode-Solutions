package com.test;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int x = scanner.nextInt();
        System.out.println(reverse(x));
        scanner.close();
    }

    public static int reverse(int x) {

        /*
         * Reverse the number ? How
         * Keep modding the number and push the data into a stack
         * Use ArrayDeque push and pop
         * The number will be reversed
         */
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = (x * -2) + x;
        }
        ArrayDeque<Integer> a = new ArrayDeque<>();
        int mod = 0;
        /*
         * Most of the things are handled.
         * Only thing that needs to be handled is the negative integer
         * For example -12
         * This when reversed will become -21
         * so -12 needs to be changed to 12 keeping in mind that it is a negative value
         * so we need an extra indicator to store that it is a negative value
         * how to change -12 to 12 -> ((number*2) + number)
         */

        while (true) {
            /*
             * Divide and keep the quotient
             * 
             */
            mod = x % 10;
            x = x / 10;

            // What is the stopping condition here ?
            /*
             * Stop when all the numbers are done.
             * Each number will take 1 iteration
             * So stop when the iterator count equals the
             * total number of digits in the number
             */

            /*
             * Stop when quotient is equal to 0;
             * That is stop when x = 0;
             */
            a.push(mod);
            if (x == 0)
                break;


        }

        // Now you have the reversed number in the queue
        // So start popping it
        /*
         * Start popping and multiply by nth power of 10 and start adding it
         */
        int powerMulti = 0;
        int finalNumber = 0;
        while (!a.isEmpty()) {
            try {
                finalNumber = Math.addExact(finalNumber, (int) (a.pop() * Math.pow(10, powerMulti)));

            } catch (ArithmeticException e) {
                return 0;
            }

            powerMulti++;
        }
        if (isNegative) {
            finalNumber = 0 - finalNumber;
        }
        return finalNumber;
    }

}
