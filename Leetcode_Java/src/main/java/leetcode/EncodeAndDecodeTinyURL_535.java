package leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL_535 {

    Map<String, String> index = new HashMap<>();
    Map<String, String> revIndex = new HashMap<>();
    static String BASE_HOST = "http://tinyurl.com/";

    public String encode(String longUrl){
        if (revIndex.containsKey(longUrl)){
            return BASE_HOST + revIndex.get(longUrl);
        }

        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++){
                int r = (int)(Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        }while(index.containsKey(key));

        index.put(key, longUrl);
        revIndex.put(longUrl, key);
        return BASE_HOST+key;
    }

    public String decode(String shortUrl){
        return index.get(shortUrl.replace(BASE_HOST,""));
    }
}
