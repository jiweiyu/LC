package leetcode;

import java.util.HashSet;

public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head){
        if(head==null || head.next==null) return null;

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                while(head!=fast){
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    public ListNode detectCycle_(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashSet nodes = new HashSet();
        ListNode current = head;

        while(current != null){
            if(nodes.contains(current))
                return current;
            nodes.add(current);
            current = current.next;
        }

        return null;
    }

}
