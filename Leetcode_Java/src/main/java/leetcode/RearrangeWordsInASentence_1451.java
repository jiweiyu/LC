package leetcode;
import java.util.*;
public class RearrangeWordsInASentence_1451 {

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        Arrays.sort(words, (s1, s2) ->{ return s1.length()-s2.length();});
        StringBuilder sb = new StringBuilder();
        for(String w:words){
            sb.append(" ").append(w.toLowerCase());
        }
        char[] res = sb.substring(1).toCharArray();
        res[0] = (char) (res[0]+'A'-'a');
        return new String(res);
    }
}
