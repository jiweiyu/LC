package leetcode;

public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {
        int j = height.length-1, i = 0, res = 0;
        while(i<j){
            res = Math.max(res, (j-i)*(Math.min(height[i],height[j])));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }

        }
        return res;
    }
}
