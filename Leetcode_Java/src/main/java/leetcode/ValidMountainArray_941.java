package leetcode;

public class ValidMountainArray_941 {
    public boolean validMountainArray(int[] arr) {
        int l = 0, r = arr.length-1;
        while(l<r && arr[l]<arr[l+1]) l++;
        while(l<r && arr[r-1]>arr[r]) r--;
        if(l==0 || r==arr.length-1) return false;
        for(int i=l;i<r;i++){
            if(arr[i]>=arr[i+1]) return false;
        }
        return true;
    }
}
