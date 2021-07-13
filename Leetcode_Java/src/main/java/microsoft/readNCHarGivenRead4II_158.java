package microsoft;

import java.util.*;

/*

 */

public class readNCHarGivenRead4II_158 {

    private int buffPtr = 0;
    private int buffCnt = 0;
    private final char[] buff = new char[4];
    public int read(char[] buf, int n){
        int ptr = 0;
        while(ptr < n){
            if(buffPtr == 0){
                buffCnt = read4(buff);
            }
            if(buffCnt == 0){
                break;
            }
            while(ptr < n && buffPtr < buffCnt){
                buf[ptr++] = buff[buffPtr++];
            }
            if(buffPtr >= buffCnt){
                buffPtr = 0;
            }
        }
        return ptr;
    }

    public int read4(char[] a){
        return 0;
    }

}
