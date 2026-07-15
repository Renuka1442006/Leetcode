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
    public boolean isPalindrome(ListNode head) {
       /* int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        int[] arr=new int[len];
        temp=head;
        int i=0;
        while(temp!=null)
        {
            arr[i]=temp.val;
            i++;
            temp=temp.next;
        }
        int left=0;
        int right=len-1;
        while(left<right)
        {
            if(arr[left]!=arr[right])
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
        */
        if(head==null || head.next==null)
        {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode pre=null;
        while(slow!=null)
        {
            ListNode next=slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }
        ListNode left=head;
        ListNode right=pre;
        while(right!=null)
        {
            if(left.val!=right.val)
            {
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
}