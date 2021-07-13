package leetcode;

public class ConvertBinaryNumberInALinkedListToInteger_1290 {

    public int getDecimalValue(ListNode head) {
        ListNode newhead = reverse(head);
        int res = 0;
        int lev = 0;
        //System.out.println(newhead.val);
        while(newhead!=null){
            int a = (int)Math.pow(2,lev);
            //System.out.println(newhead.val+", "+a);
            res = newhead.val*a+res;
            lev++;
            newhead = newhead.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}
