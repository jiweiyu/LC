package leetcode;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers_1689 {
    public int minPartitions(String n) {
        char[] list = n.toCharArray();
        int res = 0;
        for(int i=0;i<list.length;i++){
            res = Math.max(list[i]-'0',res);
        }
        return res;
    }
}
