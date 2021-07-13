package leetcode;

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {
        int count = 1;
        int[] ugly = new int[n];

        int ugly_2 = 2;
        int ugly_3 = 3;
        int ugly_5 = 5;

        int ind_2 = 0;
        int ind_3 = 0;
        int ind_5 = 0;

        ugly[0] = 1;
        int next_ugly = 1;

        while(count<n){
            next_ugly = Math.min(Math.min(ugly_2, ugly_3), ugly_5);
            ugly[count] = next_ugly;
            if(ugly_2 == next_ugly){
                ugly_2 = ugly[++ind_2] * 2;
            }
            if(ugly_3 == next_ugly){
                ugly_3 = ugly[++ind_3] * 3;
            }
            if(ugly_5 == next_ugly){
                ugly_5 = ugly[++ind_5] * 5;
            }
            count++;

        }
        return ugly[n-1];
    }
}
