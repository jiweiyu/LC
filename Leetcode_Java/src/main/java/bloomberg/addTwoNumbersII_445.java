package bloomberg;

import java.util.*;

/**
 * Created by yujiwei on 18/7/10.
 */
public class addTwoNumbersII_445 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }

        ListNode dummy = new ListNode(0);
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0 ){

            int cur = (s1.isEmpty()?0:s1.pop()) + (s2.isEmpty()?0:s2.pop()) + carry;
            carry = cur/10;

            if(cur > 9) {
                cur %= 10;
            }

            ListNode node = new ListNode(cur);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
