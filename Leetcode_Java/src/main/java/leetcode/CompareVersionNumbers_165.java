package leetcode;

public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");

        int m = list1.length, n = list2.length, i = 0, j = 0;

        while(i<m || j<n){
            if(i<m && j<n){
                if(Integer.parseInt(list1[i]) > Integer.parseInt(list2[j])){
                    return 1;
                }else if(Integer.parseInt(list1[i]) < Integer.parseInt(list2[j])){
                    return -1;
                }
            }else if(i<m && j>=n && Integer.parseInt(list1[i]) > 0){
                return 1;
            }else if(i>=m && j<n && Integer.parseInt(list2[j]) > 0){
                return -1;
            }
            i++;j++;
        }
        return 0;
    }
}
