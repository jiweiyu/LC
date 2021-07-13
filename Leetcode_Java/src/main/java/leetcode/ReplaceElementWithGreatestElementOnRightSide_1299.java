package leetcode;

public class ReplaceElementWithGreatestElementOnRightSide_1299  {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int curmax = arr[n-1], x;
        int i = n-1;
        arr[i--] = -1;
        while(i >= 0){
            x = arr[i];
            arr[i] = curmax;
            curmax = Math.max(curmax, x);
            i--;
        }
        return arr;
    }

}
