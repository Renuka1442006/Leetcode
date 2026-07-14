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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return null;

        }
       /* Stack<Integer> s=new Stack<>();
        ListNode temp=head;
        s.push(temp.val);
        while(temp.next!=null)
        {
            temp=temp.next;
            s.push(temp.val);
        }
        head.val=s.pop();
        ListNode curr=head;
        while(!s.isEmpty())
        {
            curr=curr.next;
            curr.val=s.pop();
        }
        */
        ListNode pre=null;
        ListNode curr=head;
        
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}