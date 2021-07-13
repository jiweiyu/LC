package leetcode;

public class MaximumNumberOfVowalsInASubstringOfGivenLength_1456 {

    public int maxVowels(String s, int k) {
        int res = 0;
        int current = 0;
        if(s.length() < k) return res;

        for(int i = 0 ; i < k; i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                current++;
            }
        }
        res = current;
        System.out.println("check current: " + current);
        for(int i = k;i<=s.length()-1;i++){

            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                current++;
            }
            if(s.charAt(i-k)=='a' || s.charAt(i-k)=='e' || s.charAt(i-k)=='i' || s.charAt(i-k)=='o' || s.charAt(i-k)=='u'){
                current--;
            }
            System.out.println("check add: " + s.charAt(i) + ", remove : " + s.charAt(i-k) + ", cuurent: " + current);
            res = Math.max(res, current);
        }
        return res;
    }
}
