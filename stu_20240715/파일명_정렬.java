package stu_20240715;

import java.util.Arrays;
import java.util.Comparator;

//https://school.programmers.co.kr/learn/courses/30/lessons/17686
public class 파일명_정렬 {
    public static void main(String[] args) {
        String files[]={"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        Arrays.sort(files, (o1, o2) -> {
            String o1Head="";
            String o2Head="";
            String o1num="";
            String o2num="";

            int change=-1;
            int startnum=0;
            int endnum=0;

            for(int i=0;i<o1.length();i++){
                char a= o1.charAt(i);
                if(change==-1 && a>='0' && a<='9'){
                    change=1;
                    startnum=i;
                }else if(change==1 && (a<'0' || a>'9')){
                    endnum=i;
                    break;
                }

            }

            o1Head=o1.substring(0,startnum); // 문자열 끊기.
            o1num=o1.substring(startnum,endnum-startnum>=5 ? startnum+5 :   endnum);// 숫자

            change=-1;
            startnum=0;
            endnum=0;
            for(int i=0;i<o2.length();i++){
                char a= o2.charAt(i);
                if(change==-1 && a>='0' && a<='9'){
                    change=1;
                    startnum=i;
                }else if(change==1 && (a<'0' || a>'9')){
                    endnum=i;
                    break;
                }

            }
            o2Head=o2.substring(0,startnum); // 문자열 끊기.
            o2num=o2.substring(startnum,endnum-startnum>=5 ? startnum+5: endnum);
            int o1int=Integer.parseInt(o1num);
            int o2int=Integer.parseInt(o2num);
            if(o1Head.toLowerCase().equals(o2Head.toLowerCase())){
                return Integer.compare(o1int, o2int);
            }else{
                return o1Head.toLowerCase().compareTo(o2Head.toLowerCase());
            }



        });

        for (String i: files){
            System.out.println(i);
        }



    }
}
