package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class IntersectionOfTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> reslist = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j])i++;
            else if(nums1[i]>nums2[j])j++;
            else{
                reslist.add(nums1[i]);
                i++;
                j++;
            }
        }
        return reslist.stream().mapToInt(a->a).toArray();
    }
}
