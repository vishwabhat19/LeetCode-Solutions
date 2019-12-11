package com.test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciNumbers {

    static HashMap<Integer, BigInteger> result = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        if (!(n > 0)) {
            System.out.println("Enter a number equal to or greater than 1:");
        } else {
            long t1 = System.nanoTime();
            System.out.println(fibDP(n));
            long t = System.nanoTime() - t1;
            System.out.println("Time taken in Nano seconds: " + t);
        }

        // If the input is 3..then output should be
        // 0,1,1
    }

    // 0,1,1,2,3,5,8,13,....
    public static int fibonacci(long n) {

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    public static BigInteger fibDP(int n) {
        if (result.containsKey(n)) {
            return result.get(n);
        } else if (n == 1) {
            BigInteger bigInteger = new BigInteger("0");
            return bigInteger;
        } else if (n == 2) {
            BigInteger bigInteger = new BigInteger("1");
            return bigInteger;
        }

        else {
            BigInteger nthVal = fibDP(n - 1).add(fibDP(n - 2));
            result.put(n, nthVal);
            return nthVal;

        }

    }

    public static long fibNonRecursive(long n) {
        long fib = 0;
        long previousFib = 0;
        long temp = 0;
        // Can you do this non recursively?

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    fib = 0;
                    previousFib = 0;

                } else if (i == 2) {
                    fib = 1;
                    previousFib = 0;
                } else {
                    // here we need to add the last 2 fibs
                    // How to do that
                    temp = previousFib;
                    previousFib = fib;
                    fib = fib + temp;

                }

            }
            return fib;
        }

    }

}
