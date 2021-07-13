package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin_824 {

    public String toGoatLatin(String S) {
        String[] list= S.split(" ");

        for(int k = 0; k < list.length; k++){

            String s = list[k];
            if(s.length() > 1 && (s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u") || s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O") || s.startsWith("U"))){
                s = s + "ma";
            }else{
                s = s.substring(1) + s.charAt(0) + "ma";
            }

            for(int x = 1; x <= k+1; x++){
                s = s + "a";
            }
            list[k] = s;
        }
        String res = list[0];
        for(int j = 1; j < list.length; j++){
            res = res + " " + list[j];
        }
        return res;
    }

    public String toGoatLatin_(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowels.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) {
                res += "a";
            }
        };
        return res.substring(1);
    }
}
