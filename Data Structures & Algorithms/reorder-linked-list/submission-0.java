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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode currNode = head;

        while (currNode != null) {
            nodeList.add(currNode);
            currNode = currNode.next;
        }

        int i = 0;
        int j = nodeList.size() - 1;
        
        while (i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if(i >= j) break;
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }

        nodeList.get(i).next = null;
    }
}
