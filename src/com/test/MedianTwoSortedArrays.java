package com.test;

import java.util.ArrayList;

public class MedianTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		int l1 = nums1.length;
		int l2 = nums2.length;
		
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		
		boolean e1 = false,e2 = false,bothEmpty = false;
		
		if(l1 == 0) e1 = true;
		if(l2 == 0) e2 = true;
		if(e1 && e2) bothEmpty = true;
		for(int i=0,j=0;!bothEmpty;) {
			//First condition is that both the lists are not empty
			if(!e1 && !e2) {
				if(nums1[i]<nums2[j]) {
					finalList.add(nums1[i]);
					i++;
				}
				else if(nums1[i]>nums2[j]) {
					finalList.add(nums2[j]);
					j++;
				}
				else if(nums1[i] == nums2[j]) {
					finalList.add(nums1[i]);
					finalList.add(nums2[j]);
					i++;
					j++;
				}
			}
			else if(e1 && !e2) {
				//This means that list1 is empty, but list2 is still remaining
				finalList.add(nums2[j]);
				j++;
			}
			else if(!e1 && e2) {
				//This means that list1 is empty, but list2 is still remaining
				finalList.add(nums1[i]);
				i++;
			}
			
			//Condition to set bothEmpty
			if(i == l1 && j == l2) {
				bothEmpty = true;
			}
		}
		
		//Now find the median
		//if the final array size is odd then median is just the middle index number
		if(finalList.size() % 2 != 0) {
			//Size is odd
			int half = finalList.size()/2;
			return finalList.get(half);
		}
		else {
			//size is even
			int half = finalList.size()/2;
			double d1 = finalList.get(half);
			double d2 = finalList.get(half-1);
			return ((d1+d2)/2);
		}
    }
}
