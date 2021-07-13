package leetcode;

public class AddBinary_67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry=0;
        while(i>=0 || j>=0 || carry==1){
            int num1 = i>=0?(a.charAt(i--)-'0'):0;
            int num2 = j>=0?(b.charAt(j--)-'0'):0;
            int sum = num1+num2+carry;
            sb.insert(0,sum%2);
            carry = sum/2;
        }
        return sb.toString();
    }
}
