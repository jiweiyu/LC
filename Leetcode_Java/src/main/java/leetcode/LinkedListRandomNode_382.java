package leetcode;

import java.util.Random;

public class LinkedListRandomNode_382 {

    int count = 0;
    ListNode head;

    //for very long data
    Random random;

    public LinkedListRandomNode_382(ListNode head){
        this.head = head;
        ListNode tmp = head;
        while(tmp!=null){
            count++;
            tmp = tmp.next;
        }

        //for very long data
        this.head = head;
        random = new Random();

    }

    public int getRandom(){
        ListNode fakehead = head;
        Random r = new Random();
        int random = r.nextInt(count);
        for(int i=0;i<random;i++){
            fakehead = fakehead.next;
        }
        return fakehead.val;
    }

    public int getRandom_(){
        int count = 0;
        int result = -1;
        ListNode dummyhead = head;
        while(dummyhead!=null){
            if(random.nextInt(++count)==0){
                result = dummyhead.val;
            }
            dummyhead = dummyhead.next;
        }
        return result;
    }


}
