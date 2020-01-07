package com.test;

import java.util.Scanner;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = scanner.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the array:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(maxArea(a));

    }

    /*
     * Each index can be considered as an x-axis coordinate
     * Multiply it with the index
     * 
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int value = 0;
        // Keep doing this untill left is less than right
        while (left < right) {

            value = Math.max(value, (right - left) * (Math.min(height[left], height[right])));
            // the aim is to find the bigger length
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return value;
    }

}
