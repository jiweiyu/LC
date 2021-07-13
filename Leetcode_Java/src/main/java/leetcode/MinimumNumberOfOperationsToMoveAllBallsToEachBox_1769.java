package leetcode;
import java.util.*;
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox_1769 {


    //
    public int[] minOperations_(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0, ops = 0, cnt = 0; i < boxes.length(); ++i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        for (int i = boxes.length() - 1, ops = 0, cnt = 0; i >= 0; --i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }
        return res;
    }

    //
    public int[] minOperations(String boxes) {
        List<Integer> one = new ArrayList<>();
        int len = boxes.length();
        for(int i=0;i<len;i++){
            if(boxes.charAt(i)=='1') one.add(i);
        }
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i]=help(i, one);
        }
        return res;
    }

    int help(int curr, List<Integer> one){
        int sum = 0;
        for(int check : one){
            if(check==curr) continue;
            sum+=Math.abs(curr-check);
        }
        return sum;
    }
}
