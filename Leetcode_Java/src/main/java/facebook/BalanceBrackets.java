package facebook;
import java.util.Stack;
public class BalanceBrackets {

    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{' ){
                stack.push(c);
            }else{
                if(c == ')'){
                    if(stack.isEmpty() || stack.peek()!='(') {System.out.println(c); return false;}
                    else stack.pop();
                }
                else if(c == ']'){
                    if(stack.isEmpty() || stack.peek()!='[') {System.out.println(c); return false;}
                    else stack.pop();
                }
                else if(c == '}'){
                    if(stack.isEmpty() || stack.peek()!='{') {System.out.println(c); return false;}
                    else stack.pop();
                }
            }
        }
        System.out.println(stack.size());
        return stack.isEmpty();

    }
}
