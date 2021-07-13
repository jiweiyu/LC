package bloomberg;

/**
 * Created by yujiwei on 18/7/5.
 */
public class reverseLinkedList_206 {

    //iterative
    //O(n), O(1)
    public ListNode reverseList_iterative(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //recursive
    //O(n), O(n)
    public ListNode reverseList_recursive(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
