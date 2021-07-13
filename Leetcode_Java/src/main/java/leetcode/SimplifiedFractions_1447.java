package leetcode;
import java.util.*;
public class SimplifiedFractions_1447 {
    public List<String> simplifiedFractions(int n) {
        HashSet<String> set = new HashSet<>();

        for(int m = n; m>1; m--){
            for(int d = m-1; d>0; d--){
                if(isGCD(d, m)==1){
                    set.add(d +"/"+ m);
                }

            }
        }
        System.out.println(set.size());
        return new ArrayList<String>(set);
    }

    int isGCD(int x, int y){
        return x == 0 ? y : isGCD(y%x, x);
    }

}
