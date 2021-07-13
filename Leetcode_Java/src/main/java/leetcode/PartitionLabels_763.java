package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        for(int i = 0;i<S.length();i++){
            map[S.charAt(i)-'a'] = i;
        }

        int last = 0;
        int start = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<S.length();i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last-start+1);
                start = last+1;
            }
        }
        return list;
    }

}
