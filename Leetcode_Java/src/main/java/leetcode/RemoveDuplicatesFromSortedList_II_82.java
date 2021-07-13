package leetcode;

public class RemoveDuplicatesFromSortedList_II_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode curr = head;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(pre.next == curr){
                pre = pre.next;
            }else{
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
