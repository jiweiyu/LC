package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII_364 {

    public class NestedInteger{
        public boolean isInteger() {return true;}
        public int getInteger(){return 0;}
        public List<NestedInteger> getList(){ return new ArrayList<>(); }
    }


    //BFS
    public int depthSumInverse_bfs(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        int prev = 0;
        int total = 0;
        for (NestedInteger next: nestedList) {
            queue.offer(next);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) levelSum += current.getInteger();
                List<NestedInteger> nextList = current.getList();
                if (nextList != null) {
                    for (NestedInteger next: nextList) {
                        queue.offer(next);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }


    //DFS
    public int depthSumInverse(List<NestedInteger> nestedList){
        if(nestedList==null || nestedList.size()==0) return 0;
        int h = helper(nestedList);
        int res = getSum(nestedList, h);
        return res;
    }

    private int helper(List<NestedInteger> l){
        if(l==null || l.size()==0) return 0;
        int max = 0;
        for(NestedInteger n : l){
            if(n.isInteger()) max = Math.max(max, 1);
            else max = Math.max(max, helper(n.getList())+1);
        }
        return max;
    }

    private int getSum(List<NestedInteger> l, int layer){
        int sum = 0;
        if(l==null || l.size()==0) return sum;
        for(NestedInteger n : l){
            if(n.isInteger()) sum += n.getInteger()*layer;
            else sum+= getSum(n.getList(), layer-1);
        }
        return sum;
    }
}
