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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null)
        {
            return null;
        }
        if(right==left)
        {
            return head;
        }
        ListNode temp=head;
        int cnt=0;
        while(temp.next!=null)
        {
            cnt++;
            if(cnt==left)
            {
                int pos=left;
                Stack<Integer> s=new Stack<>();
                s.push(temp.val);
                ListNode curr=temp;
                while(pos+1<=right && curr!=null)
                {
                    curr=curr.next;
                    s.push(curr.val);
                    pos++;
                }
                temp.val=s.pop();
                ListNode c=temp;
                while(!s.isEmpty())
                {
                    c=c.next;
                    c.val=s.pop();
                }
            }
           temp=temp.next;
        }
          return head;
    }
}