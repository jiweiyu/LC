package leetcode;

//*****

public class ReverseLinkedListII_92 {

    public ListNode reverseBetween_onepass(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

    //recursion
    private boolean stop;
    private ListNode left;

    public void reverseBetween_recursion(ListNode right, int m, int n) {

        if(n == 1) {
            return;
        }
        right = right.next;
        if(m > 1){
            this.left = this.left.next;
        }
        this.reverseBetween_recursion(right, m-1, n-1);
        if(this.left == right || right.next == this.left){
            this.stop = true;
        }
        if(!this.stop){
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = this.left.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n){
        this.left = head;
        this.stop = false;
        this.reverseBetween_recursion(head, m, n);
        return head;
    }

    //iterate
    public ListNode reverseBetween_iterate(ListNode head, int m, int n){
        if(head==null) return null;

        ListNode cur = head, prev = null;
        while(m >1){
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = cur;
        ListNode third = null;
        while(n>0){
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        if(con!=null){
            con.next = prev;
        }else{
            head = prev;
        }

        tail.next = cur;
        return head;

    }
}

