package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {

    public List<String> findMissingRanges(int[] a, int lo, int hi){
        List<String> res = new ArrayList<String>();

        int next = lo;
        for(int i = 0;i<a.length;i++){
            if(a[i]<next) continue;
            if(a[i]==next){
                next++;
                continue;
            }
            res.add(getRange(next,a[i]-1));
            next = a[i]+1;
        }
        if(next<=hi) res.add(getRange(next,hi));
        return res;
    }

    String getRange(int n1, int n2){
        return (n1==n2)?String.valueOf(n1):String.format("%d->%d", n1,n2);
    }
}
