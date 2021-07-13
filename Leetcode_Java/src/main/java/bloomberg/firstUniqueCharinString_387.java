package bloomberg;

/**
 * Created by yujiwei on 18/7/5.public int firstUniqChar(String s) {
 *         int res = -1;
 *         if(s.length() == 0){
 *             return res;
 *         }
 *
 *         int[] check = new int[26];
 *         for(int i=0;i<s.length();i++){
 *             check[s.charAt(i)-'a']++;
 *         }
 *
 *         for(int i=0;i<s.length();i++){
 *             if(check[s.charAt(i)-'a']==1){
 *                 return i;
 *             }
 *         }
 *         return res;
 *     }
 */
public class firstUniqueCharinString_387 {

    //O(n)
    public int firstUniqChar(String s) {
        int res = -1;
        if(s.length() == 0){
            return res;
        }

        int[] check = new int[26];
        for(int i=0;i<s.length();i++){
            check[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(check[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return res;
    }

}
