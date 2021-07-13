package leetcode;
import java.util.HashMap;
public class MakeTwoArraysEqualByReversingSubArrays_1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length!=arr.length) return false;
        HashMap<Integer, Integer> map_1 = new HashMap<>();
        HashMap<Integer, Integer> map_2 = new HashMap<>();

        for(int a : target){
            map_1.put(a, map_1.getOrDefault(a, 0)+1);
        }
        for(int b : arr){
            map_2.put(b, map_2.getOrDefault(b, 0)+1);
        }

        return map_1.equals(map_2);
    }
}
