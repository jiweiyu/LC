package facebook;

public class EncryptedWords {

    String findEncryptedWord(String s) {
        // Write your code here
        if(s==null || s.length()<=2) return s;
        int left = 0, right = s.length()-1;
        int mid = left+(right-left)/2;
        return s.charAt(mid) + findEncryptedWord(s.substring(0, mid)) + findEncryptedWord(s.substring(mid+1)) ;
    }
}
