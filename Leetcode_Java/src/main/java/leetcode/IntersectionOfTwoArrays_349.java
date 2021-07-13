package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> check = new HashSet<>();
        for(int a : nums1) check.add(a);
        List<Integer> reslist = new ArrayList<>();
        for(int b : nums2){
            if(check.contains(b)){
                reslist.add(b);
                check.remove(b);
            }
        }
        return reslist.stream().mapToInt(i->i).toArray();
    }
}
