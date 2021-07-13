package leetcode;

public class ReverseNodesinKGroup_25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;

        while(k>0){
            ListNode next_node = ptr.next;
            ptr.next = new_head;
            new_head = ptr;

            ptr = next_node;
            k--;
        }
        return new_head;
    }

    public ListNode reverseKGroup_recursive(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        while(count < k && ptr !=null){
            ptr = ptr.next;
            count++;
        }

        if(count == k){
            ListNode reversedHead = this.reverseLinkedList(head, k);
            head.next = this.reverseKGroup_recursive(ptr,k);
            return reversedHead;
        }
        return head;
    }

    public ListNode reverseKGroup_iterate(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;

        ListNode new_head = null;
        while(ptr!=null){
            int count = 0;
            ptr=head;
            while(count<k && ptr!=null){
                ptr= ptr.next;
                count+=1;
            }

            if(count==k){
                ListNode revHead = this.reverseLinkedList(head,k);
                if(new_head==null){
                    new_head = revHead;
                }
                if(ktail !=null){
                    ktail.next = revHead;
                }
                ktail=head;
                head=ptr;
            }
        }
        if(ktail!=null){
            ktail.next = head;
        }
        return new_head == null?head:new_head;
    }

}
