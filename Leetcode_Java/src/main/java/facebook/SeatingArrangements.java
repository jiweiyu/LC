package facebook;
import java.util.*;
public class SeatingArrangements {

    int getAwk(int[] arr)
    {
        int awk=0;
        for(int i=1;i<arr.length;i++)
            awk = Math.max(awk, Math.abs(arr[i-1] - arr[i]));

        return  Math.max(awk, Math.abs(arr[0] - arr[arr.length-1]));

    }

    int minOverallAwkwardness(int[] arr) {
        // Write your code here

        Arrays.sort(arr);

        int[] table = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        //Start filling the table from both ends, so that two tallest will be at the 0 and n-1 index there by minimizing the awkwardness
        for(int i=arr.length-1;i>=0;i--)
        {
            if(i%2==0)
                table[left++] = arr[i];
            else
                table[right--] = arr[i];
        }
        return getAwk(table);
    }

}
