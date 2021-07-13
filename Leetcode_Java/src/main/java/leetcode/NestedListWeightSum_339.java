package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum_339 {

    public class NestedInteger{
        public boolean isInteger() {return true;}
        public int getInteger(){return 0;}
        public List<NestedInteger> getList(){ return new ArrayList<>(); }
    }

    //DFS
    public int depthSum_(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth)
    {
        int ret = 0;
        for (NestedInteger e: list)
        {
            ret += e.isInteger()? e.getInteger() * depth: helper(e.getList(), depth + 1);
        }
        return ret;
    }

    //Queue
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList ==null) return 0;
        int sum = 0;
        int level=1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while(queue.size()>0){
            int size = queue.size();
            while(size-- >0){
                NestedInteger ni = queue.poll();
                if(ni.isInteger()){
                    sum+=ni.getInteger()*level;
                }else{
                    queue.addAll(ni.getList());
                }
            }
            level++;
        }
        return sum;
    }
}
