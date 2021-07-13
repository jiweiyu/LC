package leetcode;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR_1442 {
    public int countTriplets(int[] arr) {
        int res = 0;
        if(arr.length==1) return res;

        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                int a = 0;
                for(int x = i;x<j;x++){
                    a ^= arr[x];
                }
                for(int k = j; k < arr.length; k++){
                    int b = 0;
                    for(int y = j; y<=k; y++){
                        b ^= arr[y];
                    }
                    if(a==b) res++;
                }
            }
        }
        return res;
    }
}


//check here:
//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/discuss/623747/JavaC%2B%2BPython-One-Pass-O(N4)-to-O(N)
