package leetcode;

import java.util.Stack;

public class BasicCalculatorIII_772 {

    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0 ; i < s.length();) {
            char c = s.charAt(i);
            if (c == '(') {
                // find the block and use the recursive to solve
                int l = 1;
                int j = i+1;
                while (j < s.length() && l > 0) {
                    if(s.charAt(j) == '(') l ++;
                    else if(s.charAt(j) == ')') l --;
                    j++;
                }
                int blockValue = calculate(s.substring(i + 1, j-1));
                i = j;
                if (sign == '+') {
                    stack.push(blockValue);
                } else if (sign == '-') {
                    stack.push(-blockValue);
                } else if (sign == '*') {
                    stack.push(stack.pop() * blockValue);
                } else if (sign == '/') {
                    stack.push(stack.pop() / blockValue);
                }
            } else if (Character.isDigit(c)) {
                int j = i;
                int value = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    value = 10 * value + (s.charAt(j) - '0');
                    j++;
                }
                i = j;
                if (sign == '+') {
                    stack.push(value);
                } else if (sign == '-') {
                    stack.push(-value);
                } else if (sign == '*') {
                    stack.push(stack.pop() * value);
                } else if (sign == '/') {
                    stack.push(stack.pop() / value);
                }
            } else {
                sign = c;
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int basicCalculatorIII(String s) {

        int l1=0, o1=1;
        int l2=1, o2=1;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(++i)-'0');
                }
                l2 = (o2==1?l2*num : l2/num);
            }else if(c=='('){
                int j=i;
                for(int cnt = 0;i<s.length();i++){
                    if(s.charAt(i)=='(') cnt++;
                    if(s.charAt(i)==')') cnt--;
                    if(cnt==0) break;
                }
                int num = basicCalculatorIII(s.substring(j+1,i));
                l2=(o2==1 ? l2*num : l2/num);
            }else if(c=='*' || c=='/'){
                o2 = (c=='*' ? 1 : -1);
            }else if(c=='+' || c=='-'){
                l1 = l1 + o1*l2;
                o1 = (c=='+'?1:-1);
                l2=1;o2=1;
            }
        }
        return (l1+o1*l2);
    }
}
