package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextClosestTime_681 {

    public String nextClosestTime(String time) {
        char[] array = time.toCharArray();
        int[] max = new int[5];
        max[0] = 2;

        if(array[0] - '0' <= 1){
            max[1] = 9;
        }else{
            max[1] = 3;
        }

        max[3] = 5;
        max[4] = 9;

        List<Integer> digits = new ArrayList<>();

        for(char digit : array){
            if(digit != ':'){
                digits.add(digit - '0');
            }
        }

        Collections.sort(digits);

        for(int i =4; i>=0; i--) {
            if (i == 2) continue;
            if (array[i] - '0' < max[i]) {
                for (int j = 0; j < 4; j++) {
                    if (digits.get(j) > array[i] - '0' && digits.get(j) <= max[i]) {
                        array[i] = (char) (digits.get(j) + '0');
                        return String.valueOf(array);
                    }
                }
            }
            array[i] = (char)(digits.get(0) + '0');
        }
        return String.valueOf(array);
    }
}
