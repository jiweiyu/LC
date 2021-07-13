package microsoft;

import java.util.*;

public class intersectionOfTwoArrays_349 {

    public int[] intersection_1(int[] num1, int[] num2){
        Set<Integer> set = new HashSet<>();
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i = 0, j = 0;
        while(i < num1.length && j < num2.length){
            if(num1[i] < num2[j]) i++;
            else if(num1[i] > num2[j]) j++;
            else {
                set.add(num1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for(Integer num : set){
            result[k++] = num;
        }
        return result;
    }

    public int[] intersection_2(int[] num1, int[] num2){
        Set<Integer> set = new HashSet<>();
        Arrays.sort(num2);
        for(Integer num : num1){
            if(binarySearch(num2, num)){
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for(Integer num : set){
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low  + (high - low) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] < target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
