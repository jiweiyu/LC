package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithAnOceanView_1762 {

    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>();
        int right = heights[heights.length-1];
        res.add(heights.length-1);

        for(int i=heights.length-1;i>=0;i--){
            if(heights[i]<=right){
                continue;
            }else{
                res.add(i);
                right = heights[i];
            }
        }

        int[] res_ = new int[res.size()];
        for(int i=0;i<res.size();i++){
            res_[res.size()-i-1] = res.get(i);
        }
        return res_;
    }
}
