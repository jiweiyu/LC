package leetcode;

public class RepeatedSubstringPattern_459 {

    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i = l/2; i>=1 ; i--){
            if(l%i == 0){
                String p = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j< (l/i);j++){
                    sb.append(p);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
