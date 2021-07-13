package leetcode;

public class SwapNodesinPairs_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs_recursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs_recursive(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    public ListNode swapPairs_iterative(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNode = dummy;

        while(head!=null && head.next != null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head=firstNode.next;
        }

        return dummy.next;
    }
}
