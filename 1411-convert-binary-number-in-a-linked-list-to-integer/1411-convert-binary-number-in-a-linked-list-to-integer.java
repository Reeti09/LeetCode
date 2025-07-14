/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /**
     * Gets the decimal value of a binary number represented as a singly-linked list,
     * where each node contains a binary digit. The most significant bit is at the head of the list.
     *
     * @param head The head of the singly-linked list representing the binary number.
     * @return The integer decimal value of the binary number.
     */
    public int getDecimalValue(ListNode head) {
        int number = 0; // Initialize a variable to store the decimal number.

        // Iterate through each node of the list until the end is reached.
        while (head != null) {
            // Left-shift 'number' by 1 bit to make space for the new bit, and then
            // combine it with the current node's value using bitwise OR operation.
            number = (number << 1) | head.val;

            // Move to the next node in the list.
            head = head.next;
        }
      
        // Return the decimal number that is represented by the binary list.
        return number;
    }
}