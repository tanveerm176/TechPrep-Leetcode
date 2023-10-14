/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // return a ListNode type, take ListNode as input
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // create a dummy head to our return list with value of 0
        ListNode dummyHead = new ListNode(0);

        // create a tail pointer that points to the start of the return list
        // in the end this will point to the last node of the return list
        ListNode tail = dummyHead;

        // init a remainder value in case we need it
        int carry = 0;

        // Start a loop that continues until there are no more digits in both input lists (l1 and l2) 
        // and there is no remaining carry value.

        // The while loop exists when carry is 0, l1 and l2 are at their end.
        // if both l1 & l2 are at their end and carry is 1
        // that is added to a new node at the end of the return list
        while (l1 != null || l2 != null || carry != 0) {

            // find the vals at each pointer
            // int x = (l1 != null) ? l1.val : 0;
            int digit1 = 0;
            if (l1 != null) {
                digit1 = l1.val;
            } else {
                digit1 = 0;
            }

            // int y = (l2 != null) ? l2.val : 0;
            int digit2 = 0;
            if (l2 != null) {
                digit2 = l2.val;
            } else {
                digit2 = 0;
            }

            //sum x & y with the remainder, if any
            int sum = digit1 + digit2 + carry;

            //calculate the digit to be added to the new node (returns 1's place)
            int digit3 = sum % 10; 

            // calculate the carry over value, if any (returns 10's place)
            carry = sum / 10;

            // Create and attach a new node with the result digit
            tail.next = new ListNode(digit3);

            // Move ptrs of tail, l1, and l2 to their next nodes
            tail = tail.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // Return dummy.next, which returns the first node in the return list l3
        // Also delete the dummyHead node
        ListNode l3  = dummyHead.next;
        dummyHead.next = null;
        return l3;

    }
}
// @lc code=end
