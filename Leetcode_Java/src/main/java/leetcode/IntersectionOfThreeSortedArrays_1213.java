package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays_1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        int i1 = 0, i2 = 0, i3 = 0;
        while(i1!=arr1.length && i2!=arr2.length && i3!=arr3.length){
            if(arr1[i1] == arr2[i2] && arr2[i2]==arr3[i3]){
                list.add(arr1[i1]);
                i1++;
                i2++;
                i3++;
            }else if(arr1[i1]<arr2[i2]){
                i1++;
            }else if(arr1[i3]<arr2[i2]){
                i3++;
            }else{
                i2++;
            }
        }
        return list;
    }
}
