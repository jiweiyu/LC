package leetcode;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int[] checks = new int[26];
        int[] checkt = new int[26];

        for(char c : s.toCharArray()){
            checks[c-'a']++;
        }

        for(char c : t.toCharArray()){
            checkt[c-'a']++;
        }

        for(int i=0;i<26;i++){
            if(checks[i]!=checkt[i]) return false;
        }
        return true;
    }

}
