package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestWordDistanceII_244 {

    HashMap<String, ArrayList<Integer>> map;
    public ShortestWordDistanceII_244(String[] words) {
        map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<Integer>());
            ArrayList<Integer> l = map.get(words[i]);
            l.add(i);
            map.put(words[i], l);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i=0,j=0;i<list1.size() && j<list2.size();){
            int ind1 = list1.get(i), ind2 = list2.get(j);
            if(ind1<ind2){
                res = Math.min(res, ind2-ind1);
                i++;
            }else{
                res = Math.min(res, ind1-ind2);
                j++;
            }
        }
        return res;
    }
}
