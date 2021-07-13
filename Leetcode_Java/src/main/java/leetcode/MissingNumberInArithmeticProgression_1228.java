package leetcode;

public class MissingNumberInArithmeticProgression_1228 {

    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n-1]-arr[0])/n;

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]!=diff) return arr[i-1]+diff;
        }
        return arr[0];
    }
}
