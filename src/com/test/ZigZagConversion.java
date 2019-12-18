package com.test;

import java.util.LinkedList;
import java.util.Scanner;
/*
 * 
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

public class ZigZagConversion {

    public static void main(String args[]) {
        System.out.println("Enter String: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        System.out.println(convert(s, numRows));
        scanner.close();
    }

    public static String convert(String s, int numRows) {
        
        if (numRows == 1)
            return s;

        if (s.length() <= numRows) {
            return s;
        }

        /*
         * Logic for this
         * start with a 2D array such that you start the number of rows from 0
         * and the upper bound is the numRows
         * Columns should be dynamic
         */

        LinkedList<Character> str = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            str.add(s.charAt(i));
        }

        /*
         * I need to caclulate the number of columns required
         * How do i do it
         * Allowed columns is always numRows - 2
         */
        int n = s.length();
        int allowedColumns = numRows - 2;
        int columnCount = 0;
        while (true) {
            // Start subtracting chunks

            // here you also need to check if the number of chars
            // left can be accomodated in the next column ?

            if (n < numRows) {
                columnCount++;
                break;
            }
            if ((n - numRows) >= 0) {
                n = n - numRows;
                columnCount++;
            }
            if (n < allowedColumns) {
                columnCount = columnCount + n;
                break;
            }
            if ((n - allowedColumns) >= 0) {
                n = n - allowedColumns;
                columnCount = columnCount + allowedColumns;
            }
            if (n == 0)
                break;
        }
        Character multi[][] = new Character[numRows][columnCount];

        //Start with the rows, column should stay the same and the iteration should be done
        //on the rows
        /*
         * Have a value called complete
         * This is to tell the code that all the letters are done and that 
         * column iteration can stop
         */
        boolean complete = false;
        boolean zigging = false;
        int colPosition = 0;
        while (!complete) {
                
            if (!zigging) {

                for (int j = 0; j < numRows; j++) {

                    /*
                     * How do i handle the String count
                     * Like take the String from the next position
                     * We can use a Stack for that and keep popping values
                     */
                    if (!str.isEmpty()) {
                        multi[j][colPosition] = str.removeFirst();
                    } else {
                        complete = true;
                    }

                }

                zigging = true;
            } else if (zigging) {
                // Here zigging is true and hence we are moving diagonally
                /*
                 * Here we are incrementing the row and the column both by one
                 * until we reach a value where the value of row reaches a value
                 * one more than rownumber. Then set the zigzagging as false
                 */

                int i = numRows - 2; // This will be the row iterator
                colPosition++; // Move to the next column
                while (i > 0 && !str.isEmpty()) {
                  
                        multi[i][colPosition] = str.removeFirst();
                        i--;
                        colPosition++;

                    
                }
                if(str.isEmpty()){
                    complete = true;
                }
                zigging = false;
            }

        }

        // Output the numbers
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < columnCount; j++) {
                if(null!=multi[i][j]){
                    
                        returnString.append(multi[i][j]);
                    }   
            
        }
    }
        return returnString.toString();

    }
}
