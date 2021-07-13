package leetcode;

public class PeakIndexInAMountainArray_852 {

    public int peakIndexInMountainArray(int[] arr) {
        int res_l = 0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]<arr[i]) break;
            if(arr[i+1]>arr[i]){
                res_l=i+1;
            }
        }
        return res_l;
    }
}
