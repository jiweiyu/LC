package leetcode;

public class LongestRepeatingCharacterReplacement_424 {

    public int solution(String s, int k){
        int[] cArr = new int[26];
        int maxCount = 0, start = 0, maxSize = 0;

        for(int end = 0; end < s.length(); end++){
            cArr[s.charAt(end)-'A']++;
            maxCount = Math.max(maxCount, cArr[s.charAt(end)]);

            if(end-start+1-maxCount > k){
                cArr[s.charAt(start)-'A']--;
                start++;
            }
            maxSize = Math.max(maxSize, end-start+1);
        }
        return maxSize;
    }
}
