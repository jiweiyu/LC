package leetcode;

public class KthMissingPositiveNumber_1539 {

    public int findKthPositive(int[] arr, int k) {
        int[] list = new int[arr.length+k];

        for(int i = 1;i<=list.length;i++){
            list[i-1] = i;
        }


        for(int i=0,j=0;i<list.length&&j<arr.length;i++){
            if(list[i]!=arr[j]){
                k--;
            }else{
                j++;
            }
            if(k==0) return list[i];
        }
        return list[list.length-1];
    }

    public int findKthPositive_(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] - mid - 1 < k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (arr[hi] - hi - 1 < k) return k - (arr[hi] - hi - 1) + arr[hi];
        if (arr[lo] - lo - 1 < k) return k - (arr[lo] - lo - 1) + arr[lo];
        return 1 + (k - 1);
    }
}
