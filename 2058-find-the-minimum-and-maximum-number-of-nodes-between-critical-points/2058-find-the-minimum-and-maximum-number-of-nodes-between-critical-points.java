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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prev = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode previous = head;
        ListNode current = head.next;

        int position = 1;

        while (current.next != null) {
            if ((current.val > previous.val && current.val > current.next.val) ||
                (current.val < previous.val && current.val < current.next.val)) {
                if (first == -1) {
                    first = position;
                } 
                else {
                    minDistance = Math.min(minDistance, position - prev);

                    maxDistance = position - first;
                }
                prev = position;
            }

            previous = current;
            current = current.next;
            position++;
        }

        if (prev == first) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}