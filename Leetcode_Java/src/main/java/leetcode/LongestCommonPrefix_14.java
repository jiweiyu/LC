package leetcode;

public class LongestCommonPrefix_14 {

    //use index of
    public String longestCommonPrefix_(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0) // !-0 means not startwith(pre) from beginning
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    //Divide and conquer

    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length-1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r){
        if(l==r){
            return strs[l];
        }else{
            int mid = l + (r - l)/2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid+1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right){
        int min = Math.min(left.length(), right.length());
        for(int i = 0; i < min; i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left.substring(0, min);
    }

}
