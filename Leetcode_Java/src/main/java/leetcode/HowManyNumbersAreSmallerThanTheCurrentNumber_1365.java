package leetcode;

public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {

    public int[] smallerNumbersThanCurrent_better(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }

        return res;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] check = new int[101];
        for(int a : nums){
            check[a]++;
        }
        int[] res = new int[nums.length];
        for(int j=0;j<res.length;j++){
            for(int i=0;i<nums[j];i++){
                res[j] += check[i];
            }
        }
        return res;
    }
}
