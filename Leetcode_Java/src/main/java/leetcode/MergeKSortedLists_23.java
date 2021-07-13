package leetcode;

import java.util.*;
public class MergeKSortedLists_23 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists){
        if(lists==null || lists.size()==0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        for(ListNode node : lists){
            if(node != null){
                minHeap.add(node);
            }
        }

        if(minHeap.isEmpty()) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!minHeap.isEmpty()){
            tail.next = minHeap.poll();
            tail = tail.next;

            if(tail.next != null){
                minHeap.add(tail.next);
            }

        }
        return dummy.next;
    }


}
