package com.test;

import java.util.Scanner;

public class BubbleSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 6 elements with a space in between and then press enter: ");
        int a[] = new int[6];
        for (int i = 0; i < 6; i++) {
            a[i] = scanner.nextInt();
        }
        bubbleSort(a);
        scanner.close();
    }

    static void bubbleSort(int[] a) {
        /*
         * Doing the bubble Sort
         * Start with the first index and compare the next value
         */

        // The below iteration has to be repeated.
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {

                int temp = 0;
                if (a[j] > a[j + 1]) {
                    // Swap the i and i+1 values
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }

        // Print the sorted array
        for (int n : a) {
            System.out.println(n);
        }

    }


}
