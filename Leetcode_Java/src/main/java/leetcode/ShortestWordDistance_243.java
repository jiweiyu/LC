package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class ShortestWordDistance_243 {

    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }

    public int shortestDistance_(String[] words, String word1, String word2) {
        HashMap<String, LinkedList<Integer>> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i], new LinkedList<Integer>());
            LinkedList<Integer> l = map.get(words[i]);
            l.add(i);
            map.put(words[i], l);
        }
        LinkedList<Integer> list1 = map.get(word1);
        LinkedList<Integer> list2 = map.get(word2);
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
