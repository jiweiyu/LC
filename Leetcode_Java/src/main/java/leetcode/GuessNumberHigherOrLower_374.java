package leetcode;

public class GuessNumberHigherOrLower_374 {

    public int guessNumber(int n) {
        int l=1, r=n;
        while(l<r){
            int m = l+(r-l)/2;
            int res = guess(m);
            if(res==0) return m;
            if(res==-1) r=m-1;
            else l=m+1;
        }
        return l;
    }

    int guess(int a){
        return 0;
    }
}
