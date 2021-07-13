package leetcode;

public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        boolean res = true;
        if(word == null) return res;

        if(Character.isUpperCase(word.charAt(0))){
            int check = 0;
            for(int i = 1; i < word.length();i++){
                if(Character.isUpperCase(word.charAt(i))){
                    check += 1;
                }
            }
            System.out.println(check);
            res = check == 0 || check == word.length() - 1;
        }else{
            for(int i = 1; i < word.length();i++){
                if(Character.isUpperCase(word.charAt(i))){
                    res = false;
                }
            }
        }
        return res;
    }
}
