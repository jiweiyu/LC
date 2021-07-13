package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class NumberOfRecentCalls_933 {

    TreeSet<Integer> set;
    public NumberOfRecentCalls_933() {
        set = new TreeSet<>();
    }

    public int ping(int t) {
        set.add(t);
        return set.tailSet(t - 3000).size();
    }

    //Queue
    Queue<Integer> q;

//    public NumberOfRecentCalls_933() {
//        q = new LinkedList<>();
//    }

    public int ping_queue(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) { q.poll(); }
        return q.size();
    }

}
