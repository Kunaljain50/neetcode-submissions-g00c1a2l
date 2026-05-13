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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;
        int size = 0;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        curr = head;
        int newSize = size - n - 1;

        if (newSize < 0) {
            return head.next;
        }


        while (newSize > 0) {
            newSize--;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}
