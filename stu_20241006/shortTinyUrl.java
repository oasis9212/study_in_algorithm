package stu_20241006;

import java.util.HashMap;
import java.util.Map;

public class shortTinyUrl {

    public static void main(String[] args) {
    }
}

class Codec {
    Map <String,String> TinyURl=new HashMap<>();
    char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder key= new StringBuilder();
        for(int i=0;i<6;i++){
            key.append(map[(int) (Math.random() * (map.length-1))]);
        }
        TinyURl.put(key.toString(), longUrl);
        return key.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return TinyURl.get(shortUrl);
    }
}