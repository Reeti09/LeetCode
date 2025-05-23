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
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                current.next=l1;
                l1=l1.next;
            }
            else{
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        current.next=(l1!=null)? l1: l2;
        return dummy.next;

    }
    public ListNode sortList(ListNode head) {
        if(head==null|| head.next==null) return head;
        ListNode slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        prev.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(slow);
        return merge(left, right);



        
    }
}