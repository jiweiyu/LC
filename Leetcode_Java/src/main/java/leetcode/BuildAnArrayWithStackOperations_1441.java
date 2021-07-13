package leetcode;
import java.util.*;
public class BuildAnArrayWithStackOperations_1441 {

    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> res = new ArrayList<String>();
        int j = 0;
        for(int i = 1; i<=n; i++){
            if(j>=target.length) break;
            if(target[j]==i){
                j++;
                res.add("Push");
            }else{
                res.add("Push");
                res.add("Pop");
            }
        }

        return res;
    }
}
