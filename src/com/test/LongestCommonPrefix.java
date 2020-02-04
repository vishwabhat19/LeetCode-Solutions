package com.test;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String strs[] = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strs));

    }

    static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        else if (strs.length == 1)
            return strs[0];
        


        else {
            /*
             * Sort the arrays to get the most different Strings
             * at the extreme ends
             */
            Arrays.sort(strs);

            String first = strs[0];
            String last = strs[strs.length - 1];

            /*
             * Now we need to start iterating through both the Strings
             */
            StringBuilder longestPrefix = new StringBuilder();
            int length = (first.length() >= last.length()) ? last.length() : first.length();

            
            for (int i = 0; i < length; i++) {
                if (first.charAt(i) == last.charAt(i)) {
                    longestPrefix.append(first.charAt(i));
                }
                else{
                    break;
                }
            }

            return longestPrefix.toString();
        }
    }

}
