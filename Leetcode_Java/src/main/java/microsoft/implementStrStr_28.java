package microsoft;

public class implementStrStr_28 {

    public int strStr(String haystack, String needle){
        int L = needle.length(), n = haystack.length();
        if(L == 0){
            return 0;
        }

        int pn = 0;
        while(pn < n - L + 1){
            while(pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)){
                ++pn;
            }
            int currLen = 0, pL = 0;
            while(pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)){
                ++pn;
                ++pL;
                ++currLen;
            }
            if(currLen == L) return pn - L;
            pn = pn - currLen + 1;
        }
        return -1;
    }

}
