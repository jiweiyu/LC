package leetcode;

public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        int l=0,r=n;
        while(l<r){
            int m = l+(r-l)/2;
            if(isBadVersion(m)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int a){
        return false;
    }
}
