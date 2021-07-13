package leetcode;

public class VerifyingAnAlienDictionary_953 {
    //solution 1
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < words.length-1; i++){
            if(!helper(words[i], words[i+1], order)) return false;
        }
        return true;
    }

    boolean helper(String one, String two, String order){
        int l1 = one.length();
        int l2 = two.length();
        for(int i = 0; i < l1 && i < l2; i++){
            if(one.charAt(i) != two.charAt(i)){
                return order.indexOf(one.charAt(i)) < order.indexOf(two.charAt(i)) ;
            }
        }
        return l1 <= l2;
    }

    //solution 2
    int[] mapping = new int[26];
    public boolean isAlienSorted_(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (bigger(words[i - 1], words[i]))
                return false;
        return true;
    }

    boolean bigger(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; ++i)
            if (s1.charAt(i) != s2.charAt(i))
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
        return n > m;
    }
}
