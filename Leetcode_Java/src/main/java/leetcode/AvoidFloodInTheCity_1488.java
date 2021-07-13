package leetcode;
import java.util.*;
public class AvoidFloodInTheCity_1488 {

    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> tree = new TreeSet<>();
        int[] ans = new int[rains.length];
        HashMap<Integer, Integer> lastOccurence = new HashMap<>();
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0) {
                tree.add(i);
            }else{
                ans[i] = -1;
                if(lastOccurence.containsKey(rains[i])){
                    // Find the first occurence of 0 closest to the right of last occurence of rains[i]
                    Integer ceiling = tree.ceiling(lastOccurence.get(rains[i]));
                    if(ceiling != null){
                        tree.remove(ceiling);
                        ans[ceiling] = rains[i];
                    }else{
                        return new int[0];
                    }
                }
                lastOccurence.put(rains[i], i);
            }
        }
        for(Integer emptyPlaces: tree){
            ans[emptyPlaces] = 1;
        }
        return ans;
    }
}
