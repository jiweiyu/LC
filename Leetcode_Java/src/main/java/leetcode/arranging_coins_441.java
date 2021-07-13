package leetcode;

public class arranging_coins_441 {

    public int arrangeCoins_1(int n) {
        int i = 0;
        while(n>0){
            i++;
            n -= i;
        }
        return n==0 ? i : i-1;
    }

    public int arrangeCoins_2(int n) {
        long l = 0, r = n, t = 2 * (long) n;
        while (l < r) {
            long m = (l + r + 1) / 2;
            if ((1 + m) * m <= t) l = m;
            else r = m - 1;
        }
        return (int) l;
    }

    public int arrangeCoins_3(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}
