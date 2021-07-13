package bloomberg;

/**
 * Created by yujiwei on 18/7/6.
 */
public class stringCompression_443 {

    public int compress(char[] chars) {
        if(chars.length <= 1){
            return chars.length;
        }

        int newindex = 0;
        int index = 0;

        while(index<chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index<chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[newindex++] = currentChar;
            if(count!=1){
                for(char c:Integer.toString(count).toCharArray()){
                    chars[newindex++]=c;
                }
            }
        }
        return newindex;
    }
}
