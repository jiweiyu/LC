package leetcode;

public class ReverseInteger_7 {
    public int reverse(int x) {
        long res = 0;
        int sign = x > 0 ? 1 : -1;
        if(x<0) x=-x;
        while(x>0){
            int cur = x%10;
            res = res*10+cur;
            if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE)return 0;
            x = x/10;
        }
        return (int)res*sign;
    }
}
