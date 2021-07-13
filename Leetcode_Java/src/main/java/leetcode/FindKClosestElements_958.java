package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements_958 {

    public List<Integer> findClosetElements(int[] A, int k, int x){
        int left = 0, right = A.length-k;
        while(left<right){
            int mid = left + (right-left)/2;
            if(x - A[mid] > A[mid+k] - x) left = mid+1;
            else right = mid;
        }
        return Arrays.stream(A, left, left+k).boxed().collect(Collectors.toList());
    }


}
