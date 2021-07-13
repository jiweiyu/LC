package leetcode;

import java.util.Arrays;

public class LargestNumber_179 {

    public String largestNumber(int[] num) {
        if(num==null || num.length==0) return "";

        String[] s_num = new String[num.length];
        for(int i=0;i<num.length;i++){
            s_num[i]=String.valueOf(num[i]);
        }

        Arrays.sort(s_num, (s1,s2)->((s2+s1).compareTo(s1+s2)));

        if(s_num[0].charAt(0)=='0'){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : s_num){
            sb.append(s);
        }
        return sb.toString();
    }
}
