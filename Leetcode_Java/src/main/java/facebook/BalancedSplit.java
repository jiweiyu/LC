package facebook;
import java.util.*;
public class BalancedSplit {


    static boolean balancedSplitExists2(int[] arr) {

        // **** initialization ****
        int leftSum     = 0;
        int rightSum    = 0;

        // **** sort the array O(n log(n) ****
        Arrays.sort(arr);

        // **** ****
        for (int i = 0; i < arr.length; i++)
            leftSum += arr[i];

        // **** ****
        for (int i = arr.length - 1; i >= 0; i--) {

            // **** ****
            leftSum  -= arr[i];
            rightSum += arr[i];

            // **** ****
            if (leftSum == rightSum) {
                try {
                    if (arr[i - 1] < arr[i])
                        return true;
                } catch (Exception e) {
                    System.out.println("balancedSplitExists2 <<< EXCEPTION e: " + e.toString());
                    System.exit(-1);
                }

            }
        }

        // **** ****
        return false;
    }
}
