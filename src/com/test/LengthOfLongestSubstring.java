package com.test;

import java.util.Scanner;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println("Enter your String: ");
        Scanner scanner = new Scanner(System.in);
        // String s = "tmmzuxt";
        String s = scanner.next();
        System.out.println(lengthOfLongestSubstring(s));
        scanner.close();
    }

    public static int lengthOfLongestSubstring(String s) {

        int max_length = 1;
        if (s.equals("")) {
            return 0;
        } else {

            int processed[] = new int[256];
            for (int i = 0; i < 256; i++) {
                processed[i] = -1;
            }
            // we start from the first character outside the for loop
            // We are updating the processed array's ACSII position with the index of the first character in the String
            // and that is 0. Index is 0
            processed[s.charAt(0)] = 0;
            int current_length = 1;

            // we need to iterate over the String, not the entire array of 256 characters
            for (int index = 1; index < s.length(); index++) {
                int prevIndex = processed[s.charAt(index)];
                if ((prevIndex == -1) || ((index - current_length) > prevIndex)) {
                    //what is missing here is it checks if index is repeated 
                    //but we also need to check if the index is not at all present in 
                    //the current Unique String
                    //So we can check the range of the current unique string.
                    //Current unique string is between index - currentLength
                    //if prev index falls between index - currentLength then we need to
                    //go to else condition and change the current length to index - prev index
                    // If index is -1 then it means that the character was
                    // not found
                    // So just increase the current length variable by 1.
                    // here we also need to update the ASCII position of the processed array
                    // Bug at the charAt(0). This should actually be s.charAt(index)
                    processed[s.charAt(index)] = index;
                    current_length++;
                    if (max_length < current_length) {
                        max_length = current_length;
                    }
                } else {
                    // Else means that the character is repeated and that we need to
                    // 2 things
                    // 1. Update the processed array for that character with the index
                    processed[s.charAt(index)] = index;
                    // 2. Update max length to current length
                    if (max_length < current_length) {
                        max_length = current_length;
                    }
                    // also we need to restart the processed string.
                    // This can be subtracting the prev index of the character
                    // from the current index
                    // all we are doing here is updating the current length
                    // i.e. we are reducing the current length of the string
                    current_length = index - prevIndex;

                }
            }

            // the calculation of max length needs to be common to both the conditions

            return max_length;
        }

    }

}
