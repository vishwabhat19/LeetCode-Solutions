package com.test;

import java.util.Stack;



public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		Stack<Integer> simpleStack = new Stack<Integer>();
		int sum = 0, carry = 0;
		
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		sum = l1.val + l2.val;
		if(sum >=10) {
			sum = sum - 10;
			carry = 1;
		}
		else {
			carry = 0;
		}
		simpleStack.add(sum);
		
		boolean l1Empty = false,l2Empty = false;
		
		if(temp1.next==null) {
			l1Empty = true;
		}
		
		if(temp2.next==null) {
			l2Empty = true;
		}
		
		while(true) {
			
			
			
			if(temp1.next!=null) {
				temp1 = temp1.next;
			}
			else {
				l1Empty = true;
			}
			if(temp2.next!=null) {
				temp2 = temp2.next;
			}
			else {
				l2Empty = true;
			}
			if(!l1Empty && !l2Empty) {
				sum = temp1.val+temp2.val+carry;
				if(sum >=10) {
					sum = sum - 10;
					carry = 1;
				}
				else {
					carry = 0;
				}
			}
			else if(l1Empty && !l2Empty) {
				sum = temp2.val + carry;
				if(sum >=10) {
					sum = sum - 10;
					carry = 1;
				}
				else {
					carry = 0;
				}
			}
			
			else if(!l1Empty && l2Empty) {
				sum = temp1.val + carry;
				if(sum >=10) {
					sum = sum - 10;
					carry = 1;
				}
				else {
					carry = 0;
				}
			}
			
			if(l1Empty && l2Empty) {
				if(carry == 1 ) {
					simpleStack.add(1);
				}
				break;
			}
			
			simpleStack.add(sum);
		}//End of while block
		
		//Form the linked list and return the resultHead
		ListNode head = null;
		if(!simpleStack.isEmpty()) {
			 head = new ListNode(simpleStack.pop());
		}
		
		
		while(!simpleStack.isEmpty()) {
			
			ListNode temp = head;
			
			head = new ListNode(simpleStack.pop());
			head.next = temp;
			
				
			}
			
			
		
		
		return head;
	}
    
   
}
