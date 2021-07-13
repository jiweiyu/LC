package leetcode;

public class PlusOneLinkedList_369 {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNoteNine = dummy, node = head;

        while(node!=null){
            if(node.val!=9){
                lastNoteNine = node;
            }
            node = node.next;
        }
        lastNoteNine.val++;
        node = lastNoteNine.next;
        while(node!=null){
            node.val = 0;
            node = node.next;
        }
        return dummy.val == 1? dummy:dummy.next;
    }

}
