package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets_904 {

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0;
        for(int j = 0; j < tree.length; j++){
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while(count.size() > 2){
                count.put(tree[i], count.get(tree[i])-1);
                if(count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
