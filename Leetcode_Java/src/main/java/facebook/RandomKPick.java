package facebook;
import java.util.*;
public class RandomKPick {

    Random rand = new Random();

    public static void main(String args[]){
        int nums[] = {3,2,4,3,5,3,5,2,9};
        RandomKPick obj = new RandomKPick();
        System.out.println(obj.pickRandomKNums(nums, 3));
    }

    public List<Integer> pickRandomKNums(int nums[], int k){
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        for(int i = 0;i<n;i++){
            int index = i + rand.nextInt(n-i);
            res.add(nums[index]);
            if(res.size()==k) {
                break;
            }
            swap(nums, i, index);
        }
        return res;
    }

    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
