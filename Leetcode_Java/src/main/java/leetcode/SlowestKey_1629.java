package leetcode;

public class SlowestKey_1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] check = new int[26];
        char[] list = keysPressed.toCharArray();
        for(int i=0;i<list.length;i++){
            check[list[i]-'a'] = i==0?releaseTimes[0] : check[list[i]-'a']>(releaseTimes[i]-releaseTimes[i-1])?check[list[i]-'a']:(releaseTimes[i]-releaseTimes[i-1]);
        }
        char res = 'a';
        for(int i = 25;i>=0;i--){
            //System.out.println("i:"+i+" , check[i]: " + check[i]);
            if(check[i]>check[res-'a'] || check[i]==check[res-'a'] && i>(res-'a')) res = (char)('a' + i);
        }
        return res;
    }
}
