package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DesignAStackWithIncrementOperation_1381 {

    private final List<Integer> stk = new ArrayList<>();
    private final int sz;

    public DesignAStackWithIncrementOperation_1381(int maxSize){
        sz = maxSize;
    }

    public void push(int x){
        if(stk.size() < sz){
            stk.add(x);
        }
    }

    public int pop(){
        return stk.isEmpty()?-1:stk.remove(stk.size()-1);
    }

    public void increment(int k, int val){
        for(int i=0;i<k && i<stk.size();i++){
            stk.set(i,stk.get(i)+val);
        }
    }
}
