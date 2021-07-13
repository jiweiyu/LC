package leetcode;
/*
Time O(N), one pass for counting, one pass for sliding window
Space O(1)
 */
public class ReplaceTheSubstringForBalancedString_1234 {

    public int balancedString(String s) {
            int[] count = new int[128];
            int n = s.length();
            int left = 0;
            int minWindowLen = n;

            for(int i = 0; i < n; i++){
                ++count[s.charAt(i)];
            }

            for(int right = 0; right < n; right++){
                --count[s.charAt(right)];
                while(left<n && count['Q']<=n/4 && count['W']<=n/4 && count['E']<=n/4 && count['R']<=n/4){
                    minWindowLen = Math.min(minWindowLen, right - left + 1);
                    ++count[s.charAt(left++)];
                }
            }
            return minWindowLen;
    }
}
