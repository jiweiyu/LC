package bloomberg;
import java.util.Stack;

/**
 * Created by yujiwei on 18/7/6.
 */
public class validParentheses_20 {

    //O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop()!=c ){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
