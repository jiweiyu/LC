package leetcode;

public class PowXN_50 {

    public double pow_(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow_(x*x, n/2) : x*pow_(x*x, n/2);
    }

    public double pow(double x, int n){
        if(n==0){
            return 1;
        }
        if(n==Integer.MIN_VALUE){
            return pow(x, -Integer.MAX_VALUE) * 1/x;
        }
        if(n<0 && n>Integer.MIN_VALUE){
            n = -n;
            x = 1/x;
        }
        return (n%2==0)?pow(x*x, n/2) : x*pow(x*x,n/2);
    }
}
