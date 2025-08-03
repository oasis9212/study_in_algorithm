package stu_20241020;
import java.util.*;

public class programmers_17684 {
    public static void main(String[] args) {
        String msg="TOBEORNOTTOBEORTOBEORNOT";

        LinkedHashMap<String, Integer> map =new LinkedHashMap<String, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=26;i++) {
            char a=(char) (64+i);
            map.put(String.valueOf(a), i);
        } // 알파벳 넣기
        int msglen=msg.length();
        int cur =0;
        int inc=1;  // map 에해당 string 있다면 ++ 시키고 없다면 1 로 초기화를 시킨다. 
        int insert=0;

        while (cur<msglen){
            if(cur+inc>msglen) {
                String f=msg.substring(cur,msglen);
                insert=map.get(f);
                list.add(insert);
                break;
            }

            String s= msg.substring(cur, inc);
            if(map.get(s)!=null){
                inc++;
                insert=map.get(s);
            }else{
                map.put(s, map.size()+1);
                list.add(insert);
                insert=0;
                cur=cur+inc-1;
                inc=1;
            }
        }

    }
}
