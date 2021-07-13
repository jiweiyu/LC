package facebook;
import java.io.IOException;
import java.util.*;
public class MinimumLengthSubstrings {

    int minLengthSubstring(String s, String t) {
        // Write your code here
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            Character c = t.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        int first_index = -1, last_index = -1;

        for(int i=0;i<s.length();i++){

            if(hm.size()>0 && hm.containsKey(s.charAt(i))){
                if(first_index < 0) first_index = i;
                if(last_index < i) last_index = i;
                hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
                if(hm.get(s.charAt(i))==0) hm.remove(s.charAt(i));
            }
        }

        if(hm.size()==0){
            return last_index - first_index + 1;
        }

        return -1;

    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

}
