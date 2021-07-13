package leetcode;

import java.util.List;

public class AddTwoNumbersII_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int len1 = getLength(l1), len2 = getLength(l2);
        if(len1<len2){
            ListNode tmp  = l1;
            l1 = l2;
            l2 = tmp;
        }
        int diff = Math.abs(len1-len2);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode lastnot9node = dummy;

        while(diff>0){
            tail.next = new ListNode(l1.val);
            if(l1.val != 9) lastnot9node = tail.next;
            tail = tail.next;
            l1 = l1.next;
            diff--;
        }

        while(l1 != null){
            int val = l1.val+l2.val;
            if(val>=10){
                val -= 10;
                lastnot9node.val++;
                lastnot9node = lastnot9node.next;
                while(lastnot9node != null){
                    lastnot9node.val = 0;
                    lastnot9node = lastnot9node.next;
                }
                //lastnot9node = tail;
            }

            tail.next = new ListNode(val);
            if(val!=9) lastnot9node = tail.next;

            tail=tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(dummy.val == 1) return dummy;
        return dummy.next;

    }

    private int getLength(ListNode node){
        int len = 0;
        while(node!=null){
            len++;
            node = node.next;
        }
        return len;
    }

}
