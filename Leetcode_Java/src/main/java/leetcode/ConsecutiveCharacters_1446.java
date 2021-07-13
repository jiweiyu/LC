package leetcode;

public class ConsecutiveCharacters_1446 {

    public int maxPower(String s) {
        int res = 0;
        if(s==null) return res;
        res = 1;
        int cur = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                cur++;
            }else{
                cur = 1;
            }
            res = Math.max(res, cur);
        }
        return Math.max(res,cur);
    }
}
