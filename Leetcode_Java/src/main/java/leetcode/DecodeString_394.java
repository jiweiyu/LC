package leetcode;
import java.util.*;
public class DecodeString_394 {

    int index = 0;
    String decodeString_recursion(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else {
                int k = 0;
                // build k while next character is a digit
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                // ignore the opening bracket '['
                index++;
                String decodedString = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                // build k[decodedString] and append to the result
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }

    //two stack
    //Time Complexity: \mathcal{O}(\text{maxK} \cdot n)O(maxK⋅n),
    // where \text{maxK}maxK is the maximum value of kk and nn is the length of a given string ss.
    // We traverse a string of size nn and iterate kk times to decode each pattern of form \text{k[string]}k[string].
    // This gives us worst case time complexity as \mathcal{O}(\text{maxK} \cdot n)O(maxK⋅n).
    //
    //Space Complexity: \mathcal{O}(m+n)O(m+n), where mm is the number of letters(a-z) and
    // nn is the number of digits(0-9) in string ss. In worst case,
    // the maximum size of \text{stringStack}stringStack and \text{countStack}countStack could be mm and nn respectively.
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if(s.charAt(idx) == '['){
                resStack.push(res);
                res = "";
                idx++;
            }
            else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for(int i =0;i<repeatTimes;i++){
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else{
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
